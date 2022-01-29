package com.yash.youtube_extractor;

import com.google.gson.Gson;
import com.yash.youtube_extractor.constants.Constants;
import com.yash.youtube_extractor.models.YoutubeSong;
import com.yash.youtube_extractor.pojo.search.ItemSelectionContentsItem;
import com.yash.youtube_extractor.pojo.search.ItemsItem;
import com.yash.youtube_extractor.pojo.search.SearchResponse;
import com.yash.youtube_extractor.pojo.search.SelectionListContentsItem;
import com.yash.youtube_extractor.pojo.search.ThumbnailsItem;
import com.yash.youtube_extractor.pojo.search.VideoRenderer;
import com.yash.youtube_extractor.utility.CollectionUtility;
import com.yash.youtube_extractor.utility.CommonUtility;
import com.yash.youtube_extractor.utility.JsonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExtractorHelper {

    public static final Gson gson = new Gson();

    public static List<YoutubeSong> search(String query) {
        query = query.replace(" ", "+");
        String searchHtml = CommonUtility.getHtmlString(String.format(Constants.SEARCH_URL_FORMAT, query));

        String searchResultJson = JsonUtil.extractJsonFromHtml("\"twoColumnSearchResultsRenderer\":{", searchHtml);
        SearchResponse response = gson.fromJson(searchResultJson, SearchResponse.class);

        List<YoutubeSong> youtubeSongs = new ArrayList<>();
        try {
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
                            youtubeSong.setDurationMillis(CommonUtility.stringToMillis(videoRenderer.getLengthText().getSimpleText()));
                            List<ThumbnailsItem> thumbnails = videoRenderer.getThumbnail().getThumbnails();
                            Collections.sort(thumbnails, (o1, o2) -> o1.getWidth().compareTo(o2.getWidth()));
                            String url1 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.get(0).getUrl();
                            String url2 = CollectionUtility.isEmpty(thumbnails) ? null : thumbnails.size() > 1 ? thumbnails.get(1).getUrl() : url1;
                            youtubeSong.setArtUrlMedium(url2);
                            youtubeSong.setArtUrlSmall(url1);
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
                                youtubeSong.setArtUrlMedium(url2);
                                youtubeSong.setArtUrlSmall(url1);
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
}
