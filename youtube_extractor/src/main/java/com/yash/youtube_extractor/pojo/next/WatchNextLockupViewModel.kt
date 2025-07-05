package com.yash.youtube_extractor.pojo.next

import com.squareup.moshi.Json
import com.yash.youtube_extractor.models.YoutubeSong
import com.yash.youtube_extractor.utility.CommonUtility

data class MetadataRowsItem(

	@Json(name="metadataParts")
	val metadataParts: List<MetadataPartsItem?>? = null
)

data class StyleRunExtensions(

	@Json(name="styleRunColorMapExtension")
	val styleRunColorMapExtension: StyleRunColorMapExtension? = null
)

data class LockupMetadataViewModel(

	@Json(name="image")
	val image: Image? = null,

	@Json(name="metadata")
	val metadata: Metadata? = null,

	@Json(name="title")
	val title: WNTitle? = null
)

data class ThumbnailBadgesItem(

	@Json(name="thumbnailBadgeViewModel")
	val thumbnailBadgeViewModel: ThumbnailBadgeViewModel? = null
)

data class Width(

	@Json(name="unit")
	val unit: String? = null,

	@Json(name="value")
	val value: Int? = null
)

data class LayoutProperties(

	@Json(name="margin")
	val margin: Margin? = null,

	@Json(name="width")
	val width: Width? = null,

	@Json(name="height")
	val height: Height? = null
)

data class ContentMetadataViewModel(

	@Json(name="delimiter")
	val delimiter: CharSequence? = null,

	@Json(name="metadataRows")
	val metadataRows: List<MetadataRowsItem?>? = null
)

data class ImageType(

	@Json(name="image")
	val image: Image? = null
)

data class Margin(

	@Json(name="left")
	val left: Left? = null
)

data class ThumbnailOverlayBadgeViewModel(

	@Json(name="thumbnailBadges")
	val thumbnailBadges: List<ThumbnailBadgesItem?>? = null,

	@Json(name="position")
	val position: String? = null
)

data class LottieData(

	@Json(name="settings")
	val settings: Settings? = null,

	@Json(name="url")
	val url: String? = null
)

data class CommandContext(

	@Json(name="onTap")
	val onTap: OnTap? = null
)

data class AttachmentRunsItem(

	@Json(name="startIndex")
	val startIndex: Int? = null,

	@Json(name="length")
	val length: Int? = null,

	@Json(name="alignment")
	val alignment: String? = null,

	@Json(name="element")
	val element: Element? = null
)

data class Left(

	@Json(name="unit")
	val unit: String? = null,

	@Json(name="value")
	val value: Int? = null
)

data class Element(

	@Json(name="type")
	val type: Type? = null,

	@Json(name="properties")
	val properties: Properties? = null
)

data class Avatar(

	@Json(name="avatarViewModel")
	val avatarViewModel: AvatarViewModel? = null
)

data class StyleRunsItem(

	@Json(name="startIndex")
	val startIndex: Int? = null,

	@Json(name="styleRunExtensions")
	val styleRunExtensions: StyleRunExtensions? = null
)

data class ThumbnailViewModel(

	@Json(name="image")
	val image: Image? = null,

	@Json(name="overlays")
	val overlays: List<OverlaysItem?>? = null
)

data class MetadataPartsItem(

	@Json(name="text")
	val text: WNText? = null
)

data class WatchNextLockupViewModel(

	@Json(name="metadata")
	val metadata: Metadata? = null,

	@Json(name="contentId")
	val contentId: String? = null,

	@Json(name="contentImage")
	val contentImage: ContentImage? = null,

	@Json(name="contentType")
	val contentType: String? = null
) {
	fun toYoutubeSong(): YoutubeSong {
		val song = YoutubeSong()
		song.setVideoId(this.contentId ?: "N/A")
		val videoTitle = this.metadata?.lockupMetadataViewModel?.title?.content ?: "Unknown";
		song.setTitle(videoTitle);

		val contentMetadataViewModel = this.metadata?.lockupMetadataViewModel?.metadata?.contentMetadataViewModel
		var metadataRows = listOf<String?>()
        if (contentMetadataViewModel != null) {
           metadataRows = contentMetadataViewModel.metadataRows?.map { it?.metadataParts?.map { part -> part?.text }?.joinToString(contentMetadataViewModel.delimiter ?: ",") }.orEmpty()
        }

		song.setChannelTitle(metadataRows[0]);
		song.setDurationMillis(CommonUtility.stringToMillis(
			this.contentImage?.thumbnailViewModel?.overlays?.filter { it?.thumbnailOverlayBadgeViewModel != null }?.first()
				?.thumbnailOverlayBadgeViewModel?.thumbnailBadges?.first()?.thumbnailBadgeViewModel?.text
		));
		val thumbnails = this.contentImage?.thumbnailViewModel?.image?.sources?.sortedByDescending { it?.width }
		val url1 = thumbnails?.get(0)?.url
		val url2 = thumbnails?.get(thumbnails.size - 1)?.url
		val url3 = thumbnails?.get(1)?.url
		song.setArtUrlMedium(url2);
		song.setArtUrlSmall(url1);
		song.setArtUrlHigh(url3);
		song.setView(if (metadataRows.size > 1) metadataRows[1] else "");
		return song
	}
}

data class InnertubeCommand(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="browseEndpoint")
	val browseEndpoint: BrowseEndpoint? = null
)

data class DecoratedAvatarViewModel(

	@Json(name="a11yLabel")
	val a11yLabel: String? = null,

	@Json(name="rendererContext")
	val rendererContext: RendererContext? = null,

	@Json(name="avatar")
	val avatar: Avatar? = null
)

data class Height(

	@Json(name="unit")
	val unit: String? = null,

	@Json(name="value")
	val value: Int? = null
)

data class WNText(

	@Json(name="styleRuns")
	val styleRuns: List<StyleRunsItem?>? = null,

	@Json(name="attachmentRuns")
	val attachmentRuns: List<AttachmentRunsItem?>? = null,

	@Json(name="content")
	val content: String? = null
)

data class Metadata(

	@Json(name="lockupMetadataViewModel")
	val lockupMetadataViewModel: LockupMetadataViewModel? = null,

	@Json(name="contentMetadataViewModel")
	val contentMetadataViewModel: ContentMetadataViewModel? = null
)

data class WNTitle(

	@Json(name="content")
	val content: String? = null
)

data class AvatarViewModel(

	@Json(name="image")
	val image: Image? = null,

	@Json(name="avatarImageSize")
	val avatarImageSize: String? = null
)

data class RendererContext(

	@Json(name="commandContext")
	val commandContext: CommandContext? = null,

	@Json(name="accessibilityContext")
	val accessibilityContext: AccessibilityContext? = null
)

data class SourcesItem(

	@Json(name="width")
	val width: Int? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="height")
	val height: Int? = null,

	@Json(name="clientResource")
	val clientResource: ClientResource? = null
)

data class Properties(

	@Json(name="layoutProperties")
	val layoutProperties: LayoutProperties? = null
)

data class ColorMapItem(

	@Json(name="value")
	val value: Long? = null,

	@Json(name="key")
	val key: String? = null
)

data class ContentImage(

	@Json(name="thumbnailViewModel")
	val thumbnailViewModel: ThumbnailViewModel? = null
)

data class AccessibilityContext(

	@Json(name="label")
	val label: String? = null
)

data class OnTap(

	@Json(name="innertubeCommand")
	val innertubeCommand: InnertubeCommand? = null
)

data class Settings(

	@Json(name="loop")
	val loop: Boolean? = null,

	@Json(name="autoplay")
	val autoplay: Boolean? = null
)

data class OverlaysItem(

	@Json(name="thumbnailOverlayBadgeViewModel")
	val thumbnailOverlayBadgeViewModel: ThumbnailOverlayBadgeViewModel? = null
)

data class StyleRunColorMapExtension(

	@Json(name="colorMap")
	val colorMap: List<ColorMapItem?>? = null
)

data class Image(

	@Json(name="sources")
	val sources: List<SourcesItem?>? = null,

	@Json(name="decoratedAvatarViewModel")
	val decoratedAvatarViewModel: DecoratedAvatarViewModel? = null
)

data class ThumbnailBadgeViewModel(

	@Json(name="animationActivationTargetId")
	val animationActivationTargetId: String? = null,

	@Json(name="lottieData")
	val lottieData: LottieData? = null,

	@Json(name="rendererContext")
	val rendererContext: RendererContext? = null,

	@Json(name="animationActivationEntityKey")
	val animationActivationEntityKey: String? = null,

	@Json(name="badgeStyle")
	val badgeStyle: String? = null,

	@Json(name="text")
	val text: String? = null,

	@Json(name="animatedText")
	val animatedText: String? = null,

	@Json(name="animationActivationEntitySelectorType")
	val animationActivationEntitySelectorType: String? = null
)

data class ClientResource(

	@Json(name="imageName")
	val imageName: String? = null
)

data class Type(

	@Json(name="imageType")
	val imageType: ImageType? = null
)
