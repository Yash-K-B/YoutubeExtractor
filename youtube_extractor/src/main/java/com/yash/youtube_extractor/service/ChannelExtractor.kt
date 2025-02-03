package com.yash.youtube_extractor.service

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yash.youtube_extractor.constants.Constants
import com.yash.youtube_extractor.constants.ResponseFrom
import com.yash.youtube_extractor.models.YoutubeChannelInfo
import com.yash.youtube_extractor.models.YoutubePlaylist
import com.yash.youtube_extractor.pojo.channel.v2.RichShelfRenderer
import com.yash.youtube_extractor.pojo.channel.v2.YtInitialData
import com.yash.youtube_extractor.utility.CommonUtility
import com.yash.youtube_extractor.utility.JsonUtil
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.json.JSONObject

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object ChannelExtractor {
    private const val TAG = "ChannelExtractor"
    val moshiKotlin: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

//    fun channelInfo(channelId: String): YoutubeChannelInfo {
//        val youtubeChannelInfo = YoutubeChannelInfo()
//        try {
//            val url = String.format(Constants.CHANNEL_URL_PLACEHOLDER, channelId)
//            val playlistHtml = CommonUtility.getHtmlString(url)
//
//            val apiInfo = JsonUtil.extractJsonFromHtml("\"INNERTUBE_API_KEY\"", playlistHtml)
//            val apiInfoJson = JSONObject(String.format("{\"INNERTUBE_API_KEY%s}", apiInfo))
//            youtubeChannelInfo.apiKey = apiInfoJson.getString("INNERTUBE_API_KEY")
//            youtubeChannelInfo.clientVersion = apiInfoJson.getString("INNERTUBE_CLIENT_VERSION")
//            youtubeChannelInfo.visitorData =
//                apiInfoJson.getJSONObject("INNERTUBE_CONTEXT").getJSONObject("client")
//                    .getString("visitorData")
//            val youtubePlaylistMap: MutableMap<String, List<YoutubePlaylist>> = LinkedHashMap()
//
//            val channelDetailJson = JsonUtil.extractJsonFromHtmlV2(
//                "\"sectionListRenderer\":{\"contents\":[",
//                playlistHtml,
//                ResponseFrom.END
//            )
//            val adapter = ExtractorHelper.moshi.adapter<List<ChannelItem>>(
//                Types.newParameterizedType(
//                    MutableList::class.java,
//                    ChannelItem::class.java
//                )
//            )
//
//            val channelItems = adapter.fromJson(channelDetailJson)
//            if (CollectionUtility.isEmpty(channelItems)) return youtubeChannelInfo
//
//            for (item in channelItems!!) {
//                val itemSectionRenderer = item.itemSectionRenderer ?: continue
//                val contents = itemSectionRenderer.contents
//                for (contentsItem in contents) {
//                    val shelfRenderer = contentsItem.shelfRenderer ?: continue
//                    val title = shelfRenderer.title
//                    val playlists: MutableList<YoutubePlaylist> = ArrayList()
//                    for (playlistItem in shelfRenderer.content.horizontalListRenderer.items) {
//                        val playlist = YoutubePlaylist()
//                        if (playlistItem.gridPlaylistRenderer != null) {
//                            val gridPlaylistRenderer = playlistItem.gridPlaylistRenderer
//                            playlist.title = gridPlaylistRenderer.title.runs[0].text
//                            playlist.description = gridPlaylistRenderer.shortBylineText.runs[0].text
//                            playlist.playlistId = gridPlaylistRenderer.playlistId
//                            playlist.videoCount =
//                                CollectionUtility.join(
//                                    gridPlaylistRenderer.videoCountText.runs,
//                                    { obj: RunsItem -> obj.text }, ' '
//                                )
//                            val thumbnails = gridPlaylistRenderer.thumbnail.thumbnails
//                            val url1 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else thumbnails[0]!!
//                                    .url
//                            val url2 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else if (thumbnails.size > 1) thumbnails[1]!!
//                                    .url else url1
//                            val url3 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else thumbnails[thumbnails.size - 1]!!
//                                    .url
//                            playlist.artUrlMedium = url2
//                            playlist.artUrlSmall = url1
//                            playlist.artUrlHigh = url3
//                        } else if (playlistItem.lockupViewModel != null) {
//                            val lockupViewModel = playlistItem.lockupViewModel
//                            playlist.title =
//                                lockupViewModel.metadata.lockupMetadataViewModel.title.content
//                            val contentMetadataViewModel =
//                                lockupViewModel.metadata.lockupMetadataViewModel.metadata.contentMetadataViewModel
//
//                            val description = contentMetadataViewModel.metadataRows.stream()
//                                .map { obj: MetadataRowsItem -> obj.metadataParts }
//                                .filter { obj: List<MetadataPartsItem>? -> Objects.nonNull(obj) }
//                                .flatMap { obj: List<MetadataPartsItem> -> obj.stream() }
//                                .map { obj: MetadataPartsItem -> obj.text }
//                                .map { obj: Text -> obj.content }.collect(
//                                    Collectors.joining(contentMetadataViewModel.delimiter)
//                                )
//
//                            playlist.description = description
//                            playlist.playlistId = lockupViewModel.contentId
//                            val thumbnailViewModel =
//                                lockupViewModel.contentImage.collectionThumbnailViewModel.primaryThumbnail.thumbnailViewModel
//
//                            val badgeText = thumbnailViewModel.overlays.stream()
//                                .map { obj: OverlaysItem -> obj.thumbnailOverlayBadgeViewModel }
//                                .map { obj: ThumbnailOverlayBadgeViewModel -> obj.thumbnailBadges }
//                                .filter { obj: List<ThumbnailBadgesItem>? -> Objects.nonNull(obj) }
//                                .flatMap { obj: List<ThumbnailBadgesItem> -> obj.stream() }
//                                .map { obj: ThumbnailBadgesItem -> obj.thumbnailBadgeViewModel }
//                                .map { obj: ThumbnailBadgeViewModel -> obj.text }.findFirst()
//                            playlist.videoCount = badgeText.orElse("")
//                            val thumbnails = thumbnailViewModel.image.sources
//                            val url1 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else thumbnails[0]!!
//                                    .url
//                            val url2 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else if (thumbnails.size > 1) thumbnails[1]!!
//                                    .url else url1
//                            val url3 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else thumbnails[thumbnails.size - 1]!!
//                                    .url
//                            playlist.artUrlMedium = url2
//                            playlist.artUrlSmall = url1
//                            playlist.artUrlHigh = url3
//                        } else if (playlistItem.compactStationRenderer != null) {
//                            val compactStationRenderer = playlistItem.compactStationRenderer
//                            playlist.title = compactStationRenderer.title.simpleText
//                            playlist.description = compactStationRenderer.description.simpleText
//                            playlist.playlistId =
//                                if (Objects.isNull(compactStationRenderer.navigationEndpoint.watchEndpoint)) compactStationRenderer.navigationEndpoint.watchPlaylistEndpoint.playlistId else compactStationRenderer.navigationEndpoint.watchEndpoint.playlistId
//                            playlist.videoCount =
//                                CollectionUtility.join(
//                                    compactStationRenderer.videoCountText.runs,
//                                    { obj: RunsItem -> obj.text }, ' '
//                                )
//                            val thumbnails = compactStationRenderer.thumbnail.thumbnails
//                            val url1 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else thumbnails[0]!!
//                                    .url
//                            val url2 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else if (thumbnails.size > 1) thumbnails[1]!!
//                                    .url else url1
//                            val url3 =
//                                if (CollectionUtility.isEmpty(thumbnails)) null else thumbnails[thumbnails.size - 1]!!
//                                    .url
//                            playlist.artUrlMedium = url2
//                            playlist.artUrlSmall = url1
//                            playlist.artUrlHigh = url3
//                        }
//                        if (playlist.playlistId != null) playlists.add(playlist)
//                    }
//
//                    if (!CollectionUtility.isEmpty(title.runs)) {
//                        youtubePlaylistMap[title.runs[0].text] = playlists
//                    } else {
//                        youtubePlaylistMap[UUID.randomUUID().toString()] = playlists
//                    }
//                    youtubeChannelInfo.playlistsByCategory = youtubePlaylistMap
//                }
//            }
//        } catch (e: Exception) {
//            Log.e(TAG, "Error while fetching channel details : $e")
//        }
//
//        return youtubeChannelInfo
//    }


    fun channelInfoV2(channelId: String): YoutubeChannelInfo {
        val youtubeChannelInfo = YoutubeChannelInfo()
        try {
            val url = String.format(Constants.CHANNEL_URL_PLACEHOLDER, channelId)
            val playlistHtml = CommonUtility.getHtmlString(url)

            val apiInfo = JsonUtil.extractJsonFromHtml("\"INNERTUBE_API_KEY\"", playlistHtml)
            val apiInfoJson = JSONObject(String.format("{\"INNERTUBE_API_KEY%s}", apiInfo))
            youtubeChannelInfo.apiKey = apiInfoJson.getString("INNERTUBE_API_KEY")
            youtubeChannelInfo.clientVersion = apiInfoJson.getString("INNERTUBE_CLIENT_VERSION")
            youtubeChannelInfo.visitorData = apiInfoJson.getJSONObject("INNERTUBE_CONTEXT").getJSONObject("client")
                    .getString("visitorData")
            val youtubePlaylistMap = LinkedHashMap<String, List<YoutubePlaylist>>()

            val channelDetailJson = JsonUtil.extractJsonFromHtmlV2(
                "var ytInitialData = {",
                playlistHtml,
                ResponseFrom.END
            )

            val adapter = moshiKotlin.adapter(YtInitialData::class.java)
            val ytInitialData = adapter.fromJson(channelDetailJson)

            val categories =
                ytInitialData?.contents?.twoColumnBrowseResultsRenderer?.tabs?.mapNotNull {
                    it?.tabRenderer?.content?.richGridRenderer?.contents
                }?.flatten()
                    ?.mapNotNull { it?.richSectionRenderer?.content?.richShelfRenderer }

            categories?.forEach {

                val categoryName = it.title?.runs?.map { item -> item?.text }?.first()
                if (categoryName == null)
                    return@forEach
                val playlists = buildPlaylists(it)

                youtubePlaylistMap[categoryName] = playlists
            }

            youtubeChannelInfo.playlistsByCategory = youtubePlaylistMap

        } catch (e: Exception) {
            Log.e(TAG, "Error while fetching channel details : $e")
        }

        return youtubeChannelInfo
    }

    private fun buildPlaylists(it: RichShelfRenderer?): List<YoutubePlaylist> {
        if (it == null)
            return listOf()

        return it.contents?.map { item ->
            val lockupViewModel = item?.richItemRenderer?.content?.lockupViewModel
            var playlist: YoutubePlaylist? = null
            if(lockupViewModel?.contentId != null) {
                playlist = YoutubePlaylist()
                playlist.title = lockupViewModel.metadata?.lockupMetadataViewModel?.title?.content
                val contentMetadataViewModel = lockupViewModel.metadata?.lockupMetadataViewModel?.metadata?.contentMetadataViewModel

                val description = contentMetadataViewModel?.delimiter?.let { delimiter ->
                    contentMetadataViewModel.metadataRows?.mapNotNull { it?.metadataParts }
                        ?.flatten()
                        ?.mapNotNull { it?.text?.content }
                        ?.joinToString (separator = delimiter) { it }
                }

                playlist.description = description
                playlist.playlistId = lockupViewModel.contentId
                val thumbnailViewModel = lockupViewModel.contentImage?.collectionThumbnailViewModel?.primaryThumbnail?.thumbnailViewModel

                val badgeText =
                    thumbnailViewModel?.overlays?.mapNotNull { it?.thumbnailOverlayBadgeViewModel?.thumbnailBadges }
                        ?.flatten()?.firstNotNullOf { it?.thumbnailBadgeViewModel?.text }
                playlist.videoCount = badgeText
                val thumbnails = thumbnailViewModel?.image?.sources
                val url1 = thumbnails?.get(0)?.url
                val url2 = thumbnails?.let { if (it.size > 1) it[1]?.url else null }
                val url3 =  thumbnails?.last()?.url
                playlist.artUrlMedium = url2
                playlist.artUrlSmall = url1
                playlist.artUrlHigh = url3
            }
            playlist
        }?.filterNotNull().orEmpty()
    }
}
