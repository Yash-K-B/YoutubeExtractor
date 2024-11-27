package com.yash.youtube_extractor.pojo.next

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import com.yash.youtube_extractor.pojo.common.LengthText
import com.yash.youtube_extractor.pojo.common.ThumbnailsItem
import com.yash.youtube_extractor.pojo.playlist.ContinuationCommand

@JsonClass(generateAdapter = true)
data class WatchNextContinuationItem(

	@Json(name="continuationItemRenderer")
	val continuationItemRenderer: ContinuationItemRenderer? = null,

	@Json(name="compactVideoRenderer")
	val compactVideoRenderer: CompactVideoRenderer? = null
)

@JsonClass(generateAdapter = true)
data class NotificationMultiActionRenderer(

	@Json(name="dismissalViewStyle")
	val dismissalViewStyle: String? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="buttons")
	val buttons: List<ButtonsItem?>? = null,

	@Json(name="responseText")
	val responseText: ResponseText? = null
)

@JsonClass(generateAdapter = true)
data class SignalServiceEndpoint(

	@Json(name="signal")
	val signal: String? = null,

	@Json(name="actions")
	val actions: List<ActionsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class UndoFeedbackEndpoint(

	@Json(name="undoToken")
	val undoToken: String? = null,

	@Json(name="actions")
	val actions: List<ActionsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class UrlEndpoint(

	@Json(name="url")
	val url: String? = null,

	@Json(name="target")
	val target: String? = null
)

@JsonClass(generateAdapter = true)
data class NavigationEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="watchEndpoint")
	val watchEndpoint: WatchEndpoint? = null,

	@Json(name="browseEndpoint")
	val browseEndpoint: BrowseEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class PlaylistEditEndpoint(

	@Json(name="playlistId")
	val playlistId: String? = null,

	@Json(name="actions")
	val actions: List<ActionsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class Popup(

	@Json(name="notificationActionRenderer")
	val notificationActionRenderer: NotificationActionRenderer? = null,

	@Json(name="unifiedSharePanelRenderer")
	val unifiedSharePanelRenderer: UnifiedSharePanelRenderer? = null
)

@JsonClass(generateAdapter = true)
data class ShortBylineText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class ReplaceEnclosingAction(

	@Json(name="item")
	val item: Item? = null
)

@JsonClass(generateAdapter = true)
data class MovingThumbnailDetails(

	@Json(name="logAsMovingThumbnail")
	val logAsMovingThumbnail: Boolean? = null,

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class ChannelThumbnail(

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class OwnerBadgesItem(

	@Json(name="metadataBadgeRenderer")
	val metadataBadgeRenderer: MetadataBadgeRenderer? = null
)

@JsonClass(generateAdapter = true)
data class Item(

	@Json(name="notificationMultiActionRenderer")
	val notificationMultiActionRenderer: NotificationMultiActionRenderer? = null
)

@JsonClass(generateAdapter = true)
data class ViewCountText(

	@Json(name="simpleText")
	val simpleText: String? = null
)

@JsonClass(generateAdapter = true)
data class MenuServiceItemRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="text")
	val text: Text? = null,

	@Json(name="serviceEndpoint")
	val serviceEndpoint: ServiceEndpoint? = null,

	@Json(name="hasSeparator")
	val hasSeparator: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ThumbnailOverlayTimeStatusRenderer(

	@Json(name="style")
	val style: String? = null,

	@Json(name="text")
	val text: Text? = null
)

@JsonClass(generateAdapter = true)
data class ToggledServiceEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="playlistEditEndpoint")
	val playlistEditEndpoint: PlaylistEditEndpoint? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

@JsonClass(generateAdapter = true)
data class SignalAction(

	@Json(name="signal")
	val signal: String? = null
)

@JsonClass(generateAdapter = true)
data class CommonConfig(

	@Json(name="url")
	val url: String? = null
)

@JsonClass(generateAdapter = true)
data class GetDownloadActionCommand(

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="params")
	val params: String? = null
)

@JsonClass(generateAdapter = true)
data class MenuRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="items")
	val items: List<ItemsItem?>? = null,

	@Json(name="targetId")
	val targetId: String? = null
)

@JsonClass(generateAdapter = true)
data class OnCreateListCommand(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="createPlaylistServiceEndpoint")
	val createPlaylistServiceEndpoint: CreatePlaylistServiceEndpoint? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

@JsonClass(generateAdapter = true)
data class AddToPlaylistCommand(

	@Json(name="onCreateListCommand")
	val onCreateListCommand: OnCreateListCommand? = null,

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="openMiniplayer")
	val openMiniplayer: Boolean? = null,

	@Json(name="openListPanel")
	val openListPanel: Boolean? = null,

	@Json(name="listType")
	val listType: String? = null,

	@Json(name="videoIds")
	val videoIds: List<String?>? = null
)

@JsonClass(generateAdapter = true)
data class Icon(

	@Json(name="iconType")
	val iconType: String? = null
)

@JsonClass(generateAdapter = true)
data class ThumbnailOverlayToggleButtonRenderer(

	@Json(name="untoggledIcon")
	val untoggledIcon: UntoggledIcon? = null,

	@Json(name="toggledIcon")
	val toggledIcon: ToggledIcon? = null,

	@Json(name="toggledTooltip")
	val toggledTooltip: String? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="toggledAccessibility")
	val toggledAccessibility: ToggledAccessibility? = null,

	@Json(name="untoggledTooltip")
	val untoggledTooltip: String? = null,

	@Json(name="untoggledAccessibility")
	val untoggledAccessibility: UntoggledAccessibility? = null,

	@Json(name="untoggledServiceEndpoint")
	val untoggledServiceEndpoint: UntoggledServiceEndpoint? = null,

	@Json(name="toggledServiceEndpoint")
	val toggledServiceEndpoint: ToggledServiceEndpoint? = null,

	@Json(name="isToggled")
	val isToggled: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ToggledAccessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

@JsonClass(generateAdapter = true)
data class MovingThumbnailRenderer(

	@Json(name="enableOverlay")
	val enableOverlay: Boolean? = null,

	@Json(name="enableHoveredLogging")
	val enableHoveredLogging: Boolean? = null,

	@Json(name="movingThumbnailDetails")
	val movingThumbnailDetails: MovingThumbnailDetails? = null
)

@JsonClass(generateAdapter = true)
data class RichThumbnail(

	@Json(name="movingThumbnailRenderer")
	val movingThumbnailRenderer: MovingThumbnailRenderer? = null
)


@JsonClass(generateAdapter = true)
data class UntoggledAccessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

@JsonClass(generateAdapter = true)
data class AddToPlaylistServiceEndpoint(

	@Json(name="videoId")
	val videoId: String? = null
)

@JsonClass(generateAdapter = true)
data class Command(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="continuationCommand")
	val continuationCommand: ContinuationCommand? = null,

	@Json(name="urlEndpoint")
	val urlEndpoint: UrlEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class CommandMetadata(

	@Json(name="webCommandMetadata")
	val webCommandMetadata: WebCommandMetadata? = null
)

@JsonClass(generateAdapter = true)
data class Thumbnail(

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>
)

@JsonClass(generateAdapter = true)
data class RunsItem(

	@Json(name="text")
	val text: String? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class OnAddCommand(

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="getDownloadActionCommand")
	val getDownloadActionCommand: GetDownloadActionCommand? = null
)

@JsonClass(generateAdapter = true)
data class UnifiedSharePanelRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="showLoadingSpinner")
	val showLoadingSpinner: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class Button(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

@JsonClass(generateAdapter = true)
data class WatchEndpointSupportedOnesieConfig(

	@Json(name="html5PlaybackOnesieConfig")
	val html5PlaybackOnesieConfig: Html5PlaybackOnesieConfig? = null
)

@JsonClass(generateAdapter = true)
data class Title(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

@JsonClass(generateAdapter = true)
data class ShareEntityServiceEndpoint(

	@Json(name="serializedShareEntity")
	val serializedShareEntity: String? = null,

	@Json(name="commands")
	val commands: List<CommandsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class ThumbnailOverlaysItem(

	@Json(name="thumbnailOverlayNowPlayingRenderer")
	val thumbnailOverlayNowPlayingRenderer: ThumbnailOverlayNowPlayingRenderer? = null,

	@Json(name="thumbnailOverlayToggleButtonRenderer")
	val thumbnailOverlayToggleButtonRenderer: ThumbnailOverlayToggleButtonRenderer? = null,

	@Json(name="thumbnailOverlayTimeStatusRenderer")
	val thumbnailOverlayTimeStatusRenderer: ThumbnailOverlayTimeStatusRenderer? = null
)

@JsonClass(generateAdapter = true)
data class MenuServiceItemDownloadRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="serviceEndpoint")
	val serviceEndpoint: ServiceEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class Text(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null,

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

@JsonClass(generateAdapter = true)
data class Accessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

@JsonClass(generateAdapter = true)
data class CommandsItem(

	@Json(name="openPopupAction")
	val openPopupAction: OpenPopupAction? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

@JsonClass(generateAdapter = true)
data class ButtonRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="size")
	val size: String? = null,

	@Json(name="style")
	val style: String? = null,

	@Json(name="isDisabled")
	val isDisabled: Boolean? = null,

	@Json(name="text")
	val text: Text? = null,

	@Json(name="command")
	val command: Command? = null,

	@Json(name="serviceEndpoint")
	val serviceEndpoint: ServiceEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class NotificationActionRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="responseText")
	val responseText: ResponseText? = null
)

@JsonClass(generateAdapter = true)
data class WebCommandMetadata(

	@Json(name="sendPost")
	val sendPost: Boolean? = null,

	@Json(name="apiUrl")
	val apiUrl: String? = null,

	@Json(name="rootVe")
	val rootVe: Int? = null,

	@Json(name="webPageType")
	val webPageType: String? = null,

	@Json(name="url")
	val url: String? = null
)

@JsonClass(generateAdapter = true)
data class Html5PlaybackOnesieConfig(

	@Json(name="commonConfig")
	val commonConfig: CommonConfig? = null
)

@JsonClass(generateAdapter = true)
data class UntoggledServiceEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="signalServiceEndpoint")
	val signalServiceEndpoint: SignalServiceEndpoint? = null,

	@Json(name="playlistEditEndpoint")
	val playlistEditEndpoint: PlaylistEditEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class FeedbackEndpoint(

	@Json(name="uiActions")
	val uiActions: UiActions? = null,

	@Json(name="feedbackToken")
	val feedbackToken: String? = null,

	@Json(name="actions")
	val actions: List<ActionsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class ThumbnailOverlayNowPlayingRenderer(

	@Json(name="text")
	val text: Text? = null
)

@JsonClass(generateAdapter = true)
data class PublishedTimeText(

	@Json(name="simpleText")
	val simpleText: String? = null
)

@JsonClass(generateAdapter = true)
data class OfflineVideoEndpoint(

	@Json(name="onAddCommand")
	val onAddCommand: OnAddCommand? = null,

	@Json(name="videoId")
	val videoId: String? = null
)

@JsonClass(generateAdapter = true)
data class ResponseText(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class WatchEndpoint(

	@Json(name="nofollow")
	val nofollow: Boolean? = null,

	@Json(name="watchEndpointSupportedOnesieConfig")
	val watchEndpointSupportedOnesieConfig: WatchEndpointSupportedOnesieConfig? = null,

	@Json(name="videoId")
	val videoId: String? = null
)

@JsonClass(generateAdapter = true)
data class UndoFeedbackAction(

	@Json(name="hack")
	val hack: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class MetadataBadgeRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="style")
	val style: String? = null,

	@Json(name="label")
	val label: String? = null,

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="tooltip")
	val tooltip: String? = null
)

@JsonClass(generateAdapter = true)
data class ServiceEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="getReportFormEndpoint")
	val getReportFormEndpoint: GetReportFormEndpoint? = null,

	@Json(name="feedbackEndpoint")
	val feedbackEndpoint: FeedbackEndpoint? = null,

	@Json(name="shareEntityServiceEndpoint")
	val shareEntityServiceEndpoint: ShareEntityServiceEndpoint? = null,

	@Json(name="addToPlaylistServiceEndpoint")
	val addToPlaylistServiceEndpoint: AddToPlaylistServiceEndpoint? = null,

	@Json(name="playlistEditEndpoint")
	val playlistEditEndpoint: PlaylistEditEndpoint? = null,

	@Json(name="signalServiceEndpoint")
	val signalServiceEndpoint: SignalServiceEndpoint? = null,

	@Json(name="undoFeedbackEndpoint")
	val undoFeedbackEndpoint: UndoFeedbackEndpoint? = null,

	@Json(name="offlineVideoEndpoint")
	val offlineVideoEndpoint: OfflineVideoEndpoint? = null
)

@JsonClass(generateAdapter = true)
data class LongBylineText(

	@Json(name="runs")
	val runs: List<RunsItem?>
)

@JsonClass(generateAdapter = true)
data class UntoggledIcon(

	@Json(name="iconType")
	val iconType: String? = null
)

@JsonClass(generateAdapter = true)
data class AccessibilityData(

	@Json(name="label")
	val label: String? = null
)

@JsonClass(generateAdapter = true)
data class Menu(

	@Json(name="menuRenderer")
	val menuRenderer: MenuRenderer? = null
)

@JsonClass(generateAdapter = true)
data class ButtonsItem(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

@JsonClass(generateAdapter = true)
data class ShortViewCountText(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

@JsonClass(generateAdapter = true)
data class UiActions(

	@Json(name="hideEnclosingContainer")
	val hideEnclosingContainer: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ItemsItem(

	@Json(name="menuServiceItemRenderer")
	val menuServiceItemRenderer: MenuServiceItemRenderer? = null,

	@Json(name="menuServiceItemDownloadRenderer")
	val menuServiceItemDownloadRenderer: MenuServiceItemDownloadRenderer? = null
)

@JsonClass(generateAdapter = true)
data class BadgesItem(

	@Json(name="metadataBadgeRenderer")
	val metadataBadgeRenderer: MetadataBadgeRenderer? = null
)

@JsonClass(generateAdapter = true)
data class ContinuationItemRenderer(

	@Json(name="button")
	val button: Button? = null,

	@Json(name="continuationEndpoint")
	val continuationEndpoint: ContinuationEndpoint,

	@Json(name="trigger")
	val trigger: String? = null
)

@JsonClass(generateAdapter = true)
data class OpenPopupAction(

	@Json(name="popupType")
	val popupType: String? = null,

	@Json(name="popup")
	val popup: Popup? = null,

	@Json(name="beReused")
	val beReused: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ContinuationEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="continuationCommand")
	val continuationCommand: ContinuationCommand
)

@JsonClass(generateAdapter = true)
data class GetReportFormEndpoint(

	@Json(name="params")
	val params: String? = null
)

@JsonClass(generateAdapter = true)
data class ActionsItem(

	@Json(name="openPopupAction")
	val openPopupAction: OpenPopupAction? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="addToPlaylistCommand")
	val addToPlaylistCommand: AddToPlaylistCommand? = null,

	@Json(name="addedVideoId")
	val addedVideoId: String? = null,

	@Json(name="action")
	val action: String? = null,

	@Json(name="replaceEnclosingAction")
	val replaceEnclosingAction: ReplaceEnclosingAction? = null,

	@Json(name="undoFeedbackAction")
	val undoFeedbackAction: UndoFeedbackAction? = null,

	@Json(name="signalAction")
	val signalAction: SignalAction? = null,

	@Json(name="removedVideoId")
	val removedVideoId: String? = null
)

@JsonClass(generateAdapter = true)
data class CompactVideoRenderer(

	@Json(name="lengthText")
	val lengthText: LengthText? = null,

	@Json(name="thumbnail")
	val thumbnail: Thumbnail,

	@Json(name="channelThumbnail")
	val channelThumbnail: ChannelThumbnail? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="title")
	val title: Title? = null,

	@Json(name="shortBylineText")
	val shortBylineText: ShortBylineText? = null,

	@Json(name="menu")
	val menu: Menu? = null,

	@Json(name="thumbnailOverlays")
	val thumbnailOverlays: List<ThumbnailOverlaysItem?>? = null,

	@Json(name="longBylineText")
	val longBylineText: LongBylineText,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="publishedTimeText")
	val publishedTimeText: PublishedTimeText? = null,

	@Json(name="viewCountText")
	val viewCountText: ViewCountText,

	@Json(name="shortViewCountText")
	val shortViewCountText: ShortViewCountText? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null,

	@Json(name="badges")
	val badges: List<BadgesItem?>? = null,

	@Json(name="ownerBadges")
	val ownerBadges: List<OwnerBadgesItem?>? = null,

	@Json(name="richThumbnail")
	val richThumbnail: RichThumbnail? = null
)

@JsonClass(generateAdapter = true)
data class BrowseEndpoint(

	@Json(name="browseId")
	val browseId: String? = null,

	@Json(name="canonicalBaseUrl")
	val canonicalBaseUrl: String? = null
)

@JsonClass(generateAdapter = true)
data class ToggledIcon(

	@Json(name="iconType")
	val iconType: String? = null
)

@JsonClass(generateAdapter = true)
data class CreatePlaylistServiceEndpoint(

	@Json(name="params")
	val params: String? = null,

	@Json(name="videoIds")
	val videoIds: List<String?>? = null
)

@JsonClass(generateAdapter = true)
data class ContinuationItem(

	@Json(name = "nextContinuationData")
	val nextContinuationData: NextContinuationData? = null

)

@JsonClass(generateAdapter = true)
data class NextContinuationData(

	val continuation: String? = null,

	val clickTrackingParams: String? = null,

	val label: Text

)


