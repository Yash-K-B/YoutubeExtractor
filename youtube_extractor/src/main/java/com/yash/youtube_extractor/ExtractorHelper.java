package com.yash.youtube_extractor;

import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.yash.youtube_extractor.constants.Constants;
import com.yash.youtube_extractor.constants.ContinuationType;
import com.yash.youtube_extractor.constants.ResponseFrom;
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
import com.yash.youtube_extractor.pojo.playlist.ContinuationCommand;
import com.yash.youtube_extractor.pojo.playlist.ContinuationItemRenderer;
import com.yash.youtube_extractor.pojo.playlist.PlaylistVideoItem;
import com.yash.youtube_extractor.pojo.playlist.PlaylistVideoRenderer;
import com.yash.youtube_extractor.pojo.search.ItemSelectionContentsItem;
import com.yash.youtube_extractor.pojo.search.ItemsItem;
import com.yash.youtube_extractor.pojo.search.SearchResponse;
import com.yash.youtube_extractor.pojo.search.SelectionListContentsItem;
import com.yash.youtube_extractor.pojo.search.VideoRenderer;
import com.yash.youtube_extractor.utility.CollectionUtility;
import com.yash.youtube_extractor.utility.CommonUtility;
import com.yash.youtube_extractor.utility.HttpUtility;
import com.yash.youtube_extractor.utility.JsonUtil;
import com.yash.youtube_extractor.utility.RequestUtility;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExtractorHelper {
    private static final String TAG = "ExtractorHelper";

    public static final Moshi moshi = new Moshi.Builder().build();

    /**
     * Search a string
     *
     * @param query Query string
     * @return List of youtube songs
     */
    public static List<YoutubeSong> search(String query) {
        query = query.replace(" ", "+");
        String searchHtml = CommonUtility.getHtmlString(String.format(Constants.SEARCH_URL_FORMAT, query));

        String searchResultJson = JsonUtil.extractJsonFromHtml("\"twoColumnSearchResultsRenderer\":{", searchHtml);

        List<YoutubeSong> youtubeSongs = new ArrayList<>();
        try {
            SearchResponse response = moshi.adapter(SearchResponse.class).fromJson(searchResultJson);
            if (response == null || response.getPrimaryContents() == null || response.getPrimaryContents().getSectionListRenderer() == null || response.getPrimaryContents().getSectionListRenderer().getContents() == null)
                return null;
            for (SelectionListContentsItem item : response.getPrimaryContents().getSectionListRenderer().getContents()) {
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

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return youtubeSongs;
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
        String jsonString = HttpUtility.getInstance().post("https://youtubei.googleapis.com/youtubei/v1/browse?key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8&prettyPrint=false", RequestUtility.buildContinuationRequest(continuation).toString());
        return extractPlaylistSongs(jsonString, "appendContinuationItemsAction\":{\"continuationItems\":[");
    }

    public static YoutubeResponse next(String continuation) throws IOException {
        String htmlString = HttpUtility.getInstance().post("https://youtubei.googleapis.com/youtubei/v1/next?key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8&prettyPrint=false", RequestUtility.buildContinuationRequest(continuation).toString());
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
                    if(continuationItemRenderer != null) {
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

    public static Map<String, List<YoutubePlaylist>> channelPlaylists(String channelId) {
        String url = String.format(Constants.CHANNEL_URL_PLACEHOLDER, channelId);
        String playlistHtml = CommonUtility.getHtmlString(url);

        Map<String, List<YoutubePlaylist>> youtubePlaylistMap = new LinkedHashMap<>();

        String channelDetailJson = JsonUtil.extractJsonFromHtmlV2("\"sectionListRenderer\":{\"contents\":[", playlistHtml, ResponseFrom.END);
        JsonAdapter<List<ChannelItem>> adapter = moshi.adapter(Types.newParameterizedType(List.class, ChannelItem.class));
        try {
            List<ChannelItem> channelItems = adapter.fromJson(channelDetailJson);
            if (CollectionUtility.isEmpty(channelItems))
                return youtubePlaylistMap;

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

                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while fetching channel details : " + e);
        }

        return youtubePlaylistMap;
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
