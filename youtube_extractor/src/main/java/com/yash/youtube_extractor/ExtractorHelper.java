package com.yash.youtube_extractor;

import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import com.yash.youtube_extractor.constants.Constants;
import com.yash.youtube_extractor.constants.ContinuationType;
import com.yash.youtube_extractor.constants.ResponseFrom;
import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.YoutubeChannelInfo;
import com.yash.youtube_extractor.models.YoutubeResponse;
import com.yash.youtube_extractor.models.YoutubePlaylist;
import com.yash.youtube_extractor.models.YoutubeSong;
import com.yash.youtube_extractor.pojo.channel.ChannelItem;
import com.yash.youtube_extractor.pojo.channel.CompactStationRenderer;
import com.yash.youtube_extractor.pojo.channel.ContentsItem;
import com.yash.youtube_extractor.pojo.channel.GridPlaylistRenderer;
import com.yash.youtube_extractor.pojo.channel.ItemSectionRenderer;
import com.yash.youtube_extractor.pojo.channel.PlaylistItem;
import com.yash.youtube_extractor.pojo.channel.RunsItem;
import com.yash.youtube_extractor.pojo.channel.ShelfRenderer;
import com.yash.youtube_extractor.pojo.channel.Title;
import com.yash.youtube_extractor.pojo.common.ThumbnailsItem;
import com.yash.youtube_extractor.pojo.next.CompactVideoRenderer;
import com.yash.youtube_extractor.pojo.next.WatchNextContinuationItem;
import com.yash.youtube_extractor.pojo.playlist.ContinuationCommand;
import com.yash.youtube_extractor.pojo.playlist.ContinuationItemRenderer;
import com.yash.youtube_extractor.pojo.playlist.PlaylistVideoItem;
import com.yash.youtube_extractor.pojo.playlist.PlaylistVideoRenderer;
import com.yash.youtube_extractor.pojo.search.ItemSelectionContentsItem;
import com.yash.youtube_extractor.pojo.search.ItemsItem;
import com.yash.youtube_extractor.pojo.search.SelectionListContentsItem;
import com.yash.youtube_extractor.pojo.search.VideoRenderer;
import com.yash.youtube_extractor.utility.CollectionUtility;
import com.yash.youtube_extractor.utility.CommonUtility;
import com.yash.youtube_extractor.utility.HttpUtility;
import com.yash.youtube_extractor.utility.JsonUtil;
import com.yash.youtube_extractor.utility.RequestUtility;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExtractorHelper {
    private static final String TAG = "ExtractorHelper";

    public static final Moshi moshi = new Moshi.Builder().build();
    public static final Moshi moshiKotlin = new Moshi.Builder().add(new KotlinJsonAdapterFactory()).build();

    /**
     * Search a string
     *
     * @param query Query string
     * @return List of youtube songs
     */
    public static YoutubeResponse search(String query) throws ExtractionException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("query", query);
        payload.put("context", RequestUtility.buildContext());
        return extractSearchSongs(new JSONObject(payload), "\"twoColumnSearchResultsRenderer\":{", Arrays.asList("primaryContents", "sectionListRenderer", "contents"));
    }

    public static YoutubeResponse searchContinuation(String query, String continuation) throws ExtractionException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("continuation", continuation);
        payload.put("context", RequestUtility.buildContext());
        return extractSearchSongs(new JSONObject(payload), "\"appendContinuationItemsAction\":{", Collections.singletonList("continuationItems"));
    }

    /**
     * Extract songs from search result
     *
     * @param payload           Search request
     * @param initialSearchText Text to search from response
     * @param preKeys           keys to extract from searched JSON object
     * @return Response of songs with continuation token
     */
    private static YoutubeResponse extractSearchSongs(JSONObject payload, String initialSearchText, List<String> preKeys) throws ExtractionException {
        try {
            List<YoutubeSong> youtubeSongs = new ArrayList<>();
            ContinuationCommand continuationCommand = new ContinuationCommand();
            String searchHtml = HttpUtility.getInstance().post(RequestUtility.getSearchUrl(), payload.toString());
            String searchResultJson = JsonUtil.extractJsonFromHtml(initialSearchText, searchHtml);
            JSONObject response = new JSONObject(searchResultJson);
            JSONArray finalResponse = null;
            for (int i = 0; i < preKeys.size(); i++) {
                if (i == preKeys.size() - 1) {
                    finalResponse = response.getJSONArray(preKeys.get(i));
                } else {
                    if (response.has(preKeys.get(i)))
                        response = response.getJSONObject(preKeys.get(i));
                    else return YoutubeResponse.empty();
                }
            }
            if (finalResponse == null)
                return YoutubeResponse.empty();
            JsonAdapter<List<SelectionListContentsItem>> adapter = moshi.adapter(Types.newParameterizedType(List.class, SelectionListContentsItem.class));
            List<SelectionListContentsItem> sectionListRendererItems = adapter.fromJson(finalResponse.toString());
            if (sectionListRendererItems == null)
                return YoutubeResponse.empty();
            for (SelectionListContentsItem item : sectionListRendererItems) {
                if (item.getItemSectionRenderer() != null && item.getItemSectionRenderer().getContents() != null) {
                    for (ItemSelectionContentsItem video : item.getItemSectionRenderer().getContents()) {
                        if (video.getVideoRenderer() != null) {
                            VideoRenderer videoRenderer = video.getVideoRenderer();
                            YoutubeSong youtubeSong = new YoutubeSong();
                            youtubeSong.setVideoId(videoRenderer.getVideoId());
                            String videoTitle = CollectionUtility.isEmpty(videoRenderer.getTitle().getRuns()) ? "Unknown" : videoRenderer.getTitle().getRuns().get(0).getText();
                            youtubeSong.setTitle(videoTitle);
                            String ownerTitle = CollectionUtility.isEmpty(videoRenderer.getOwnerText().getRuns()) ? "Unknown" : videoRenderer.getOwnerText().getRuns().get(0).getText();
                            youtubeSong.setChannelTitle(ownerTitle);
                            youtubeSong.setDurationMillis(CommonUtility.fromLengthText(videoRenderer.getLengthText()));
                            List<ThumbnailsItem> thumbnails = videoRenderer.getThumbnail().getThumbnails();
                            Collections.sort(thumbnails, (o1, o2) -> o1.getWidth().compareTo(o2.getWidth()));
                            String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                            String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                            String url3 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(thumbnails.size() - 1).getUrl();
                            youtubeSong.setArtUrlMedium(url2);
                            youtubeSong.setArtUrlSmall(url1);
                            youtubeSong.setArtUrlHigh(url3);
                            youtubeSong.setView(videoRenderer.getViewCountText().getSimpleText());

                            youtubeSongs.add(youtubeSong);

                        } else if (video.getShelfRenderer() != null) {
                            if (video.getShelfRenderer().getContent() == null || video.getShelfRenderer().getContent().getVerticalListRenderer() == null || video.getShelfRenderer().getContent().getVerticalListRenderer().getItems() == null)
                                continue;
                            List<ItemsItem> items = video.getShelfRenderer().getContent().getVerticalListRenderer().getItems();
                            for (ItemsItem video2 : items) {
                                VideoRenderer videoRenderer = video2.getVideoRenderer();
                                YoutubeSong youtubeSong = new YoutubeSong();
                                youtubeSong.setVideoId(videoRenderer.getVideoId());
                                String videoTitle = CollectionUtility.isEmpty(videoRenderer.getTitle().getRuns()) ? "Unknown" : videoRenderer.getTitle().getRuns().get(0).getText();
                                youtubeSong.setTitle(videoTitle);
                                String ownerTitle = CollectionUtility.isEmpty(videoRenderer.getOwnerText().getRuns()) ? "Unknown" : videoRenderer.getOwnerText().getRuns().get(0).getText();
                                youtubeSong.setChannelTitle(ownerTitle);
                                youtubeSong.setDurationMillis(CommonUtility.stringToMillis(videoRenderer.getLengthText().getSimpleText()));
                                List<ThumbnailsItem> thumbnails = videoRenderer.getThumbnail().getThumbnails();
                                Collections.sort(thumbnails, (o1, o2) -> o1.getWidth().compareTo(o2.getWidth()));
                                String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                                String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                                String url3 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(thumbnails.size() - 1).getUrl();
                                youtubeSong.setArtUrlMedium(url2);
                                youtubeSong.setArtUrlSmall(url1);
                                youtubeSong.setArtUrlHigh(url3);
                                youtubeSong.setView(videoRenderer.getViewCountText().getSimpleText());

                                youtubeSongs.add(youtubeSong);
                            }
                        }
                    }

                } else if (item.getContinuationItemRenderer() != null) {
                    continuationCommand = item.getContinuationItemRenderer().getContinuationEndpoint().getContinuationCommand();
                }
            }
            return new YoutubeResponse(youtubeSongs, continuationCommand.getToken(), continuationCommand.getRequest());
        } catch (Exception e) {
            throw new ExtractionException("Error while extracting songs from watch next", e);
        }
    }

    /**
     * 100 songs of the playlist without api key
     *
     * @param playlistId ID of the PLaylist
     * @return List of youtube songs
     */
    public static YoutubeResponse playlistSongs(String playlistId) {
        String url = String.format(Constants.PLAYLIST_URL_PLACEHOLDER, playlistId);
        String playlistHtml = CommonUtility.getHtmlString(url);

        return extractPlaylistSongs(playlistHtml, "playlistVideoListRenderer\":{\"contents\":[");
    }

    /**
     * Playlist songs continuation
     *
     * @param continuation     Continuation token
     * @param continuationType Continuation type
     * @return Paged Response
     * @throws IOException I/O Exception
     */
    public static YoutubeResponse continuationResponse(String continuation, ContinuationType continuationType) throws IOException {
        switch (continuationType) {
            case BROWSE:
                return browse(continuation);

            case NEXT:
                return next(continuation);
        }
        return YoutubeResponse.empty();
    }

    private static YoutubeResponse browse(String continuation) throws IOException {
        String jsonString = HttpUtility.getInstance().post(RequestUtility.getBrowseUrl(), RequestUtility.buildContinuationRequest(continuation).toString());
        return extractPlaylistSongs(jsonString, "appendContinuationItemsAction\":{\"continuationItems\":[");
    }

    public static YoutubeResponse next(String continuation) throws IOException {
        String htmlString = HttpUtility.getInstance().post(RequestUtility.getNextUrl(), RequestUtility.buildContinuationRequest(continuation).toString());
        return extractPlaylistSongs(htmlString, "playlistVideoListRenderer\":{\"contents\":[");
    }

    private static YoutubeResponse extractPlaylistSongs(String playlistHtml, String initialSearchText) {
        List<YoutubeSong> songs = new ArrayList<>();

        ContinuationCommand continuationCommand = new ContinuationCommand();
        String playListJson = JsonUtil.extractJsonFromHtmlV2(initialSearchText, playlistHtml, ResponseFrom.END);
        try {
            JsonAdapter<List<PlaylistVideoItem>> adapter = moshi.adapter(Types.newParameterizedType(List.class, PlaylistVideoItem.class));
            List<PlaylistVideoItem> playlistVideoItems = adapter.fromJson(playListJson);
            if (CollectionUtility.isEmpty(playlistVideoItems)) {
                return new YoutubeResponse(songs, continuationCommand.getToken(), continuationCommand.getRequest());
            }

            for (PlaylistVideoItem playlistVideoItem : playlistVideoItems) {
                PlaylistVideoRenderer videoRenderer = playlistVideoItem.getPlaylistVideoRenderer();
                if (videoRenderer == null) {
                    ContinuationItemRenderer continuationItemRenderer = playlistVideoItem.getContinuationItemRenderer();
                    if (continuationItemRenderer != null) {
                        continuationCommand = continuationItemRenderer.getContinuationEndpoint().getContinuationCommand();
                    }
                    continue;
                }
                YoutubeSong youtubeSong = new YoutubeSong();
                youtubeSong.setVideoId(videoRenderer.getVideoId());
                String videoTitle = CollectionUtility.isEmpty(videoRenderer.getTitle().getRuns()) ? "Unknown" : videoRenderer.getTitle().getRuns().get(0).getText();
                youtubeSong.setTitle(videoTitle);
                String channelTitle = CollectionUtility.isEmpty(videoRenderer.getShortBylineText().getRuns()) ? "Unknown" : videoRenderer.getShortBylineText().getRuns().get(0).getText();
                youtubeSong.setChannelTitle(channelTitle);
                youtubeSong.setDurationMillis(CommonUtility.fromLengthText(videoRenderer.getLengthText()));
                List<ThumbnailsItem> thumbnails = videoRenderer.getThumbnail().getThumbnails();
                Collections.sort(thumbnails, (o1, o2) -> o1.getWidth().compareTo(o2.getWidth()));
                String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                String url3 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(thumbnails.size() - 1).getUrl();
                youtubeSong.setArtUrlMedium(url2);
                youtubeSong.setArtUrlSmall(url1);
                youtubeSong.setArtUrlHigh(url3);

                songs.add(youtubeSong);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while fetching playlist songs : " + e);
        }

        return new YoutubeResponse(songs, continuationCommand.getToken(), continuationCommand.getRequest());
    }

    public static YoutubeChannelInfo channelInfo(String channelId) {
        YoutubeChannelInfo youtubeChannelInfo = new YoutubeChannelInfo();
        try {
            String url = String.format(Constants.CHANNEL_URL_PLACEHOLDER, channelId);
            String playlistHtml = CommonUtility.getHtmlString(url);

            String apiInfo = JsonUtil.extractJsonFromHtml("\"INNERTUBE_API_KEY\"", playlistHtml);
            JSONObject apiInfoJson = new JSONObject(String.format("{\"INNERTUBE_API_KEY%s}", apiInfo));
            youtubeChannelInfo.setApiKey(apiInfoJson.getString("INNERTUBE_API_KEY"));
            youtubeChannelInfo.setClientVersion(apiInfoJson.getString("INNERTUBE_CLIENT_VERSION"));
            youtubeChannelInfo.setVisitorData(apiInfoJson.getJSONObject("INNERTUBE_CONTEXT").getJSONObject("client").getString("visitorData"));
            Map<String, List<YoutubePlaylist>> youtubePlaylistMap = new LinkedHashMap<>();

            String channelDetailJson = JsonUtil.extractJsonFromHtmlV2("\"sectionListRenderer\":{\"contents\":[", playlistHtml, ResponseFrom.END);
            JsonAdapter<List<ChannelItem>> adapter = moshi.adapter(Types.newParameterizedType(List.class, ChannelItem.class));

            List<ChannelItem> channelItems = adapter.fromJson(channelDetailJson);
            if (CollectionUtility.isEmpty(channelItems))
                return youtubeChannelInfo;

            for (ChannelItem item : channelItems) {
                ItemSectionRenderer itemSectionRenderer = item.getItemSectionRenderer();
                if (itemSectionRenderer == null)
                    continue;
                List<ContentsItem> contents = itemSectionRenderer.getContents();
                for (ContentsItem contentsItem : contents) {
                    ShelfRenderer shelfRenderer = contentsItem.getShelfRenderer();
                    if (shelfRenderer == null)
                        continue;
                    Title title = shelfRenderer.getTitle();
                    List<YoutubePlaylist> playlists = new ArrayList<>();
                    for (PlaylistItem playlistItem : shelfRenderer.getContent().getHorizontalListRenderer().getItems()) {
                        CompactStationRenderer compactStationRenderer = playlistItem.getCompactStationRenderer();
                        YoutubePlaylist playlist = new YoutubePlaylist();
                        if (compactStationRenderer == null) {
                            GridPlaylistRenderer gridPlaylistRenderer = playlistItem.getGridPlaylistRenderer();
                            if (gridPlaylistRenderer == null)
                                continue;
                            playlist.setTitle(gridPlaylistRenderer.getTitle().getRuns().get(0).getText());
                            playlist.setDescription(gridPlaylistRenderer.getShortBylineText().getRuns().get(0).getText());
                            playlist.setPlaylistId(gridPlaylistRenderer.getPlaylistId());
                            playlist.setVideoCount(CollectionUtility.join(gridPlaylistRenderer.getVideoCountText().getRuns(), RunsItem::getText, ' '));
                            List<ThumbnailsItem> thumbnails = gridPlaylistRenderer.getThumbnail().getThumbnails();
                            String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                            String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                            String url3 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(thumbnails.size() - 1).getUrl();
                            playlist.setArtUrlMedium(url2);
                            playlist.setArtUrlSmall(url1);
                            playlist.setArtUrlHigh(url3);
                        } else {
                            playlist.setTitle(compactStationRenderer.getTitle().getSimpleText());
                            playlist.setDescription(compactStationRenderer.getDescription().getSimpleText());
                            playlist.setPlaylistId(compactStationRenderer.getNavigationEndpoint().getWatchEndpoint().getPlaylistId());
                            playlist.setVideoCount(CollectionUtility.join(compactStationRenderer.getVideoCountText().getRuns(), RunsItem::getText, ' '));
                            List<ThumbnailsItem> thumbnails = compactStationRenderer.getThumbnail().getThumbnails();
                            String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                            String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                            String url3 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(thumbnails.size() - 1).getUrl();
                            playlist.setArtUrlMedium(url2);
                            playlist.setArtUrlSmall(url1);
                            playlist.setArtUrlHigh(url3);
                        }
                        playlists.add(playlist);
                    }

                    if (!CollectionUtility.isEmpty(title.getRuns())) {
                        youtubePlaylistMap.put(title.getRuns().get(0).getText(), playlists);
                    } else {
                        youtubePlaylistMap.put(UUID.randomUUID().toString(), playlists);
                    }
                    youtubeChannelInfo.setPlaylistsByCategory(youtubePlaylistMap);

                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while fetching channel details : " + e);
        }

        return youtubeChannelInfo;
    }


    public static YoutubeResponse watchNext(String videoId) throws ExtractionException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("videoId", videoId);
        payload.put("context", RequestUtility.buildContext());
        return extractWatchNextSongs(new JSONObject(payload), "\"twoColumnWatchNextResults\":{", Arrays.asList("secondaryResults", "secondaryResults", "results"));
    }

    public static YoutubeResponse watchNextContinuation(String videoId, String continuation) throws ExtractionException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("continuation", continuation);
        payload.put("context", RequestUtility.buildContext());
        return extractWatchNextSongs(new JSONObject(payload), "\"appendContinuationItemsAction\":{", Collections.singletonList("continuationItems"));
    }

    private static YoutubeResponse extractWatchNextSongs(JSONObject payload, String initialSearchText, List<String> preKeys) throws ExtractionException {
        try {
            List<YoutubeSong> youtubeSongs = new ArrayList<>();
            ContinuationCommand continuationCommand = new ContinuationCommand();
            String watchNextHtml = HttpUtility.getInstance().post(RequestUtility.getNextUrl(), payload.toString());
            String watchNextJson = JsonUtil.extractJsonFromHtml(initialSearchText, watchNextHtml);
            JSONObject response = new JSONObject(watchNextJson);
            JSONArray finalResponse = null;
            for (int i = 0; i < preKeys.size(); i++) {
                if (i == preKeys.size() - 1) {
                    finalResponse = response.getJSONArray(preKeys.get(i));
                } else {
                    if (response.has(preKeys.get(i)))
                        response = response.getJSONObject(preKeys.get(i));
                    else return YoutubeResponse.empty();
                }
            }
            if (finalResponse == null)
                return YoutubeResponse.empty();
            JsonAdapter<List<WatchNextContinuationItem>> adapter = moshiKotlin.adapter(Types.newParameterizedType(List.class, WatchNextContinuationItem.class));
            List<WatchNextContinuationItem> watchNextContinuationItems = adapter.fromJson(finalResponse.toString());
            if (watchNextContinuationItems == null)
                return YoutubeResponse.empty();
            for (WatchNextContinuationItem item : watchNextContinuationItems) {
                if (item.getCompactVideoRenderer() != null) {
                    CompactVideoRenderer videoRenderer = item.getCompactVideoRenderer();
                    YoutubeSong youtubeSong = new YoutubeSong();
                    youtubeSong.setVideoId(videoRenderer.getVideoId());
                    String videoTitle = videoRenderer.getTitle() != null ? videoRenderer.getTitle().getSimpleText() : "Unknown";
                    youtubeSong.setTitle(videoTitle);
                    String ownerTitle = CollectionUtility.isEmpty(videoRenderer.getLongBylineText().getRuns()) ? "Unknown" : videoRenderer.getLongBylineText().getRuns().get(0).getText();
                    youtubeSong.setChannelTitle(ownerTitle);
                    youtubeSong.setDurationMillis(videoRenderer.getLengthText() != null ? CommonUtility.stringToMillis(videoRenderer.getLengthText().getSimpleText()) : 0L);
                    List<ThumbnailsItem> thumbnails = videoRenderer.getThumbnail().getThumbnails();
                    Collections.sort(thumbnails, (o1, o2) -> o1.getWidth().compareTo(o2.getWidth()));
                    String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                    String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                    String url3 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(thumbnails.size() - 1).getUrl();
                    youtubeSong.setArtUrlMedium(url2);
                    youtubeSong.setArtUrlSmall(url1);
                    youtubeSong.setArtUrlHigh(url3);
                    youtubeSong.setView(videoRenderer.getViewCountText().getSimpleText());

                    youtubeSongs.add(youtubeSong);


                } else if (item.getContinuationItemRenderer() != null) {
                    continuationCommand = item.getContinuationItemRenderer().getContinuationEndpoint().getContinuationCommand();
                }
            }

            return new YoutubeResponse(youtubeSongs, continuationCommand.getToken(), continuationCommand.getRequest());
        } catch (Exception e) {
            throw new ExtractionException("Error while extracting songs from watch next", e);
        }
    }

    public static void contentFromYoutubeMusic() {
        try {
            String url = "https://music.youtube.com";
            String playlistHtml = CommonUtility.getHtmlUnescapedString(url);

            String data = JsonUtil.extractJsonFromHtmlV2("initialData.push({path: '\\/browse'", playlistHtml, ResponseFrom.START, 17);
            String dataIdentifier = "data: '";
            if (data.length() > dataIdentifier.length()) {
                String jsonPayload = data.substring(data.indexOf(dataIdentifier) + dataIdentifier.length(), data.length() - 2);
                String s = StringEscapeUtils.unescapeJava(jsonPayload.replace("\\x", "\\u00"));
                Log.d(TAG, s);
            }

            Log.d(TAG, playlistHtml);

        } catch (Exception e) {
            Log.e(TAG, "Exception :", e);
        }

    }
}
