package com.yash.youtube_extractor.pojo.channel.v2

import com.squareup.moshi.Json

data class YtInitialData(

//	@Json(name="metadata")
//	val metadata: Metadata? = null,
//
//	@Json(name="trackingParams")
//	val trackingParams: String? = null,

	@Json(name="contents")
	val contents: Contents? = null,

//	@Json(name="frameworkUpdates")
//	val frameworkUpdates: FrameworkUpdates? = null,
//
//	@Json(name="responseContext")
//	val responseContext: ResponseContext? = null,
//
//	@Json(name="header")
//	val header: Header? = null,
//
//	@Json(name="microformat")
//	val microformat: Microformat? = null,
//
//	@Json(name="topbar")
//	val topbar: Topbar? = null
)

data class Portrait(

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

data class EngagementPanelSectionListRenderer(

	@Json(name="identifier")
	val identifier: Identifier? = null,

	@Json(name="targetId")
	val targetId: String? = null,

	@Json(name="size")
	val size: String? = null,

	@Json(name="header")
	val header: Header? = null,

	@Json(name="content")
	val content: Content? = null
)

data class MenuServiceItemDownloadRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="serviceEndpoint")
	val serviceEndpoint: ServiceEndpoint? = null
)

data class ExampleQuery2(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class Popup(

	@Json(name="unifiedSharePanelRenderer")
	val unifiedSharePanelRenderer: UnifiedSharePanelRenderer? = null,

	@Json(name="confirmDialogRenderer")
	val confirmDialogRenderer: ConfirmDialogRenderer? = null,

	@Json(name="multiPageMenuRenderer")
	val multiPageMenuRenderer: MultiPageMenuRenderer? = null,

	@Json(name="voiceSearchDialogRenderer")
	val voiceSearchDialogRenderer: VoiceSearchDialogRenderer? = null
)

data class ShowLessButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class SubscriberCountText(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

data class Title(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null,

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="content")
	val content: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

data class WatchPlaylistEndpoint(

	@Json(name="playlistId")
	val playlistId: String? = null
)

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

data class LoggingContext(

	@Json(name="loggingDirectives")
	val loggingDirectives: LoggingDirectives? = null,

	@Json(name="vssLoggingContext")
	val vssLoggingContext: VssLoggingContext? = null
)

data class ConfirmButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class LockupMetadataViewModel(

	@Json(name="metadata")
	val metadata: Metadata? = null,

	@Json(name="title")
	val title: Title? = null
)

data class RichGridRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="targetId")
	val targetId: String? = null,

	@Json(name="contents")
	val contents: List<ContentsItem?>? = null,

	@Json(name="reflowOptions")
	val reflowOptions: ReflowOptions? = null
)

data class MicrophoneOffPromptHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ShareEntityServiceEndpoint(

	@Json(name="serializedShareEntity")
	val serializedShareEntity: String? = null,

	@Json(name="commands")
	val commands: List<CommandsItem?>? = null
)

data class CommandContext(

	@Json(name="onTap")
	val onTap: OnTap? = null
)

data class A11ySkipNavigationButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class SignalAction(

	@Json(name="signal")
	val signal: String? = null
)

data class TwoColumnBrowseResultsRenderer(

	@Json(name="tabs")
	val tabs: List<TabsItem?>? = null
)

data class ConfirmDialogRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="cancelButton")
	val cancelButton: CancelButton? = null,

	@Json(name="confirmButton")
	val confirmButton: ConfirmButton? = null,

	@Json(name="dialogMessages")
	val dialogMessages: List<DialogMessagesItem?>? = null,

	@Json(name="primaryIsCancel")
	val primaryIsCancel: Boolean? = null
)

data class LoadingHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class Image(

	@Json(name="sources")
	val sources: List<SourcesItem?>? = null
)

data class OnAddCommand(

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="getDownloadActionCommand")
	val getDownloadActionCommand: GetDownloadActionCommand? = null
)

data class OfflineVideoEndpoint(

	@Json(name="onAddCommand")
	val onAddCommand: OnAddCommand? = null,

	@Json(name="videoId")
	val videoId: String? = null
)

data class Microformat(

	@Json(name="microformatDataRenderer")
	val microformatDataRenderer: MicroformatDataRenderer? = null
)

data class MenuServiceItemRenderer(

	@Json(name="hasSeparator")
	val hasSeparator: Boolean? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="text")
	val text: Text? = null,

	@Json(name="serviceEndpoint")
	val serviceEndpoint: ServiceEndpoint? = null
)

data class EngagementPanelTitleHeaderRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="visibilityButton")
	val visibilityButton: VisibilityButton? = null,

	@Json(name="title")
	val title: Title? = null
)

data class OnTap(

	@Json(name="innertubeCommand")
	val innertubeCommand: InnertubeCommand? = null
)

data class SubscribedButtonText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class AccessibilityData(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null,

	@Json(name="label")
	val label: String? = null
)

data class DisabledSubtext(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class SubscribeButton(

	@Json(name="subscribeButtonRenderer")
	val subscribeButtonRenderer: SubscribeButtonRenderer? = null
)

data class CollectionThumbnailViewModel(

	@Json(name="primaryThumbnail")
	val primaryThumbnail: PrimaryThumbnail? = null,

	@Json(name="stackColor")
	val stackColor: StackColor? = null
)

data class DismissableDialogRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="dialogMessage")
	val dialogMessage: String? = null,

	@Json(name="title")
	val title: String? = null
)

data class ParamsItem(

	@Json(name="value")
	val value: String? = null,

	@Json(name="key")
	val key: String? = null
)

data class EngagementPanelPresentationConfigs(

	@Json(name="engagementPanelPopupPresentationConfig")
	val engagementPanelPopupPresentationConfig: EngagementPanelPopupPresentationConfig? = null
)

data class SubscribeButtonRenderer(

	@Json(name="buttonText")
	val buttonText: ButtonText? = null,

	@Json(name="subscribeAccessibility")
	val subscribeAccessibility: SubscribeAccessibility? = null,

	@Json(name="onUnsubscribeEndpoints")
	val onUnsubscribeEndpoints: List<OnUnsubscribeEndpointsItem?>? = null,

	@Json(name="subscriberCountText")
	val subscriberCountText: SubscriberCountText? = null,

	@Json(name="showPreferences")
	val showPreferences: Boolean? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="subscribedButtonText")
	val subscribedButtonText: SubscribedButtonText? = null,

	@Json(name="enabled")
	val enabled: Boolean? = null,

	@Json(name="unsubscribeButtonText")
	val unsubscribeButtonText: UnsubscribeButtonText? = null,

	@Json(name="subscribed")
	val subscribed: Boolean? = null,

	@Json(name="unsubscribeAccessibility")
	val unsubscribeAccessibility: UnsubscribeAccessibility? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="onSubscribeEndpoints")
	val onSubscribeEndpoints: List<OnSubscribeEndpointsItem?>? = null,

	@Json(name="subscribedEntityKey")
	val subscribedEntityKey: String? = null,

	@Json(name="channelId")
	val channelId: String? = null,

	@Json(name="unsubscribedButtonText")
	val unsubscribedButtonText: UnsubscribedButtonText? = null
)

data class ContinuationItemRenderer(

	@Json(name="continuationEndpoint")
	val continuationEndpoint: ContinuationEndpoint? = null,

	@Json(name="trigger")
	val trigger: String? = null
)

data class LoggingDirectives(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="clientVeSpec")
	val clientVeSpec: ClientVeSpec? = null
)

data class InnertubeCommand(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="watchPlaylistEndpoint")
	val watchPlaylistEndpoint: WatchPlaylistEndpoint? = null,

	@Json(name="watchEndpoint")
	val watchEndpoint: WatchEndpoint? = null,

	@Json(name="browseEndpoint")
	val browseEndpoint: BrowseEndpoint? = null
)

data class RichItemRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="content")
	val content: Content? = null
)

data class UntoggledIcon(

	@Json(name="iconType")
	val iconType: String? = null
)

data class ShowMoreButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class ThumbnailOverlayBadgeViewModel(

	@Json(name="thumbnailBadges")
	val thumbnailBadges: List<ThumbnailBadgesItem?>? = null,

	@Json(name="position")
	val position: String? = null
)

data class UnsubscribeAccessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

data class ClientResource(

	@Json(name="imageName")
	val imageName: String? = null
)

data class HotkeyDialog(

	@Json(name="hotkeyDialogRenderer")
	val hotkeyDialogRenderer: HotkeyDialogRenderer? = null
)

data class MetadataBadgeRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null,

	@Json(name="style")
	val style: String? = null,

	@Json(name="label")
	val label: String? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="tooltip")
	val tooltip: String? = null
)

data class DisabledHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ThumbnailOverlaysItem(

	@Json(name="thumbnailOverlayNowPlayingRenderer")
	val thumbnailOverlayNowPlayingRenderer: ThumbnailOverlayNowPlayingRenderer? = null,

	@Json(name="thumbnailOverlayToggleButtonRenderer")
	val thumbnailOverlayToggleButtonRenderer: ThumbnailOverlayToggleButtonRenderer? = null,

	@Json(name="thumbnailOverlayTimeStatusRenderer")
	val thumbnailOverlayTimeStatusRenderer: ThumbnailOverlayTimeStatusRenderer? = null
)

data class Accessibility(

	@Json(name="label")
	val label: String? = null,

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

data class Contents(

	@Json(name="twoColumnBrowseResultsRenderer")
	val twoColumnBrowseResultsRenderer: TwoColumnBrowseResultsRenderer? = null
)

data class OnSubscribeEndpointsItem(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="subscribeEndpoint")
	val subscribeEndpoint: SubscribeEndpoint? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

data class SectionsItem(

	@Json(name="hotkeyDialogSectionRenderer")
	val hotkeyDialogSectionRenderer: HotkeyDialogSectionRenderer? = null
)

data class BadgesItem(

	@Json(name="metadataBadgeRenderer")
	val metadataBadgeRenderer: MetadataBadgeRenderer? = null
)

data class VoiceSearchButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class ShortViewCountText(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

data class Metadata(

	@Json(name="channelMetadataRenderer")
	val channelMetadataRenderer: ChannelMetadataRenderer? = null,

	@Json(name="lockupMetadataViewModel")
	val lockupMetadataViewModel: LockupMetadataViewModel? = null,

	@Json(name="contentMetadataViewModel")
	val contentMetadataViewModel: ContentMetadataViewModel? = null
)

data class ToggledIcon(

	@Json(name="iconType")
	val iconType: String? = null
)

data class CommandRunsItem(

	@Json(name="startIndex")
	val startIndex: Int? = null,

	@Json(name="length")
	val length: Int? = null,

	@Json(name="onTap")
	val onTap: OnTap? = null
)

data class MutationsItem(

	@Json(name="payload")
	val payload: Payload? = null,

	@Json(name="entityKey")
	val entityKey: String? = null,

	@Json(name="type")
	val type: String? = null
)

data class FusionSearchboxRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="searchEndpoint")
	val searchEndpoint: SearchEndpoint? = null,

	@Json(name="clearButton")
	val clearButton: ClearButton? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="placeholderText")
	val placeholderText: PlaceholderText? = null,

	@Json(name="config")
	val config: Config? = null
)

data class DefaultPromoPanelRenderer(

	@Json(name="smallFormFactorBackgroundThumbnail")
	val smallFormFactorBackgroundThumbnail: SmallFormFactorBackgroundThumbnail? = null,

	@Json(name="inlinePlaybackRenderer")
	val inlinePlaybackRenderer: InlinePlaybackRenderer? = null,

	@Json(name="description")
	val description: Description? = null,

	@Json(name="largeFormFactorBackgroundThumbnail")
	val largeFormFactorBackgroundThumbnail: LargeFormFactorBackgroundThumbnail? = null,

	@Json(name="title")
	val title: Title? = null,

	@Json(name="minPanelDisplayDurationMs")
	val minPanelDisplayDurationMs: Int? = null,

	@Json(name="panelLayout")
	val panelLayout: String? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="scrimColorValues")
	val scrimColorValues: List<Int?>? = null,

	@Json(name="metadataOrder")
	val metadataOrder: String? = null,

	@Json(name="scrimRotation")
	val scrimRotation: Int? = null,

	@Json(name="minVideoPlayDurationMs")
	val minVideoPlayDurationMs: Int? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null
)

data class DismissButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class TooltipText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class CommandMetadata(

	@Json(name="webCommandMetadata")
	val webCommandMetadata: WebCommandMetadata? = null
)

data class WatchEndpoint(

	@Json(name="playlistId")
	val playlistId: String? = null,

	@Json(name="watchEndpointSupportedOnesieConfig")
	val watchEndpointSupportedOnesieConfig: WatchEndpointSupportedOnesieConfig? = null,

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="params")
	val params: String? = null,

	@Json(name="loggingContext")
	val loggingContext: LoggingContext? = null,

	@Json(name="playerParams")
	val playerParams: String? = null,

	@Json(name="startTimeSeconds")
	val startTimeSeconds: Int? = null
)

data class ChannelMetadataRenderer(

	@Json(name="keywords")
	val keywords: String? = null,

	@Json(name="channelUrl")
	val channelUrl: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="externalId")
	val externalId: String? = null,

	@Json(name="availableCountryCodes")
	val availableCountryCodes: List<String?>? = null,

	@Json(name="vanityChannelUrl")
	val vanityChannelUrl: String? = null,

	@Json(name="avatar")
	val avatar: Avatar? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="rssUrl")
	val rssUrl: String? = null,

	@Json(name="iosAppindexingLink")
	val iosAppindexingLink: String? = null,

	@Json(name="ownerUrls")
	val ownerUrls: List<String?>? = null,

	@Json(name="androidAppindexingLink")
	val androidAppindexingLink: String? = null,

	@Json(name="isFamilySafe")
	val isFamilySafe: Boolean? = null,

	@Json(name="androidDeepLink")
	val androidDeepLink: String? = null
)

data class EngagementPanel(

	@Json(name="engagementPanelSectionListRenderer")
	val engagementPanelSectionListRenderer: EngagementPanelSectionListRenderer? = null
)

data class GetDownloadActionCommand(

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="params")
	val params: String? = null
)

data class ChangeEngagementPanelVisibilityAction(

	@Json(name="targetId")
	val targetId: String? = null,

	@Json(name="visibility")
	val visibility: String? = null
)

data class SearchEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="searchEndpoint")
	val searchEndpoint: SearchEndpoint? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="query")
	val query: String? = null
)

data class ActionsItem(

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="addToPlaylistCommand")
	val addToPlaylistCommand: AddToPlaylistCommand? = null,

	@Json(name="addedVideoId")
	val addedVideoId: String? = null,

	@Json(name="action")
	val action: String? = null,

	@Json(name="removedVideoId")
	val removedVideoId: String? = null,

	@Json(name="openPopupAction")
	val openPopupAction: OpenPopupAction? = null,

	@Json(name="signalAction")
	val signalAction: SignalAction? = null
)

data class MainAppWebResponseContext(

	@Json(name="trackingParam")
	val trackingParam: String? = null,

	@Json(name="loggedOut")
	val loggedOut: Boolean? = null
)

data class HotkeyDialogRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="dismissButton")
	val dismissButton: DismissButton? = null,

	@Json(name="title")
	val title: Title? = null,

	@Json(name="sections")
	val sections: List<SectionsItem?>? = null
)

data class Html5PlaybackOnesieConfig(

	@Json(name="commonConfig")
	val commonConfig: CommonConfig? = null
)

data class PaginationThumbnailsItem(

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

data class Name(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class MetadataRowsItem(

	@Json(name="metadataParts")
	val metadataParts: List<MetadataPartsItem?>? = null
)

data class ContinuationCommand(

	@Json(name="request")
	val request: String? = null,

	@Json(name="token")
	val token: String? = null
)

data class ResponseContext(

	@Json(name="serviceTrackingParams")
	val serviceTrackingParams: List<ServiceTrackingParamsItem?>? = null,

	@Json(name="webResponseContextExtensionData")
	val webResponseContextExtensionData: WebResponseContextExtensionData? = null,

	@Json(name="maxAgeSeconds")
	val maxAgeSeconds: Int? = null,

	@Json(name="mainAppWebResponseContext")
	val mainAppWebResponseContext: MainAppWebResponseContext? = null
)

data class ThumbnailHoverOverlayViewModel(

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="style")
	val style: String? = null,

	@Json(name="text")
	val text: Text? = null
)

data class OnCreateListCommand(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="createPlaylistServiceEndpoint")
	val createPlaylistServiceEndpoint: CreatePlaylistServiceEndpoint? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

data class VoiceSearchDialogRenderer(

	@Json(name="microphoneButtonAriaLabel")
	val microphoneButtonAriaLabel: MicrophoneButtonAriaLabel? = null,

	@Json(name="promptMicrophoneLabel")
	val promptMicrophoneLabel: PromptMicrophoneLabel? = null,

	@Json(name="promptHeader")
	val promptHeader: PromptHeader? = null,

	@Json(name="connectionErrorMicrophoneLabel")
	val connectionErrorMicrophoneLabel: ConnectionErrorMicrophoneLabel? = null,

	@Json(name="disabledSubtext")
	val disabledSubtext: DisabledSubtext? = null,

	@Json(name="permissionsHeader")
	val permissionsHeader: PermissionsHeader? = null,

	@Json(name="exampleQuery1")
	val exampleQuery1: ExampleQuery1? = null,

	@Json(name="exitButton")
	val exitButton: ExitButton? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="microphoneOffPromptHeader")
	val microphoneOffPromptHeader: MicrophoneOffPromptHeader? = null,

	@Json(name="exampleQuery2")
	val exampleQuery2: ExampleQuery2? = null,

	@Json(name="connectionErrorHeader")
	val connectionErrorHeader: ConnectionErrorHeader? = null,

	@Json(name="placeholderHeader")
	val placeholderHeader: PlaceholderHeader? = null,

	@Json(name="disabledHeader")
	val disabledHeader: DisabledHeader? = null,

	@Json(name="loadingHeader")
	val loadingHeader: LoadingHeader? = null,

	@Json(name="permissionsSubtext")
	val permissionsSubtext: PermissionsSubtext? = null
)

data class UnifiedSharePanelRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="showLoadingSpinner")
	val showLoadingSpinner: Boolean? = null
)

data class CreatePlaylistServiceEndpoint(

	@Json(name="params")
	val params: String? = null,

	@Json(name="videoIds")
	val videoIds: List<String?>? = null
)

data class ExampleQuery1(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class Timestamp(

	@Json(name="seconds")
	val seconds: String? = null,

	@Json(name="nanos")
	val nanos: Int? = null
)

data class Description(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ContinuationEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="continuationCommand")
	val continuationCommand: ContinuationCommand? = null
)

data class SubscribeAccessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

data class EntityBatchUpdate(

	@Json(name="mutations")
	val mutations: List<MutationsItem?>? = null,

	@Json(name="timestamp")
	val timestamp: Timestamp? = null
)

data class ServiceEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="signalServiceEndpoint")
	val signalServiceEndpoint: SignalServiceEndpoint? = null,

	@Json(name="shareEntityServiceEndpoint")
	val shareEntityServiceEndpoint: ShareEntityServiceEndpoint? = null,

	@Json(name="offlineVideoEndpoint")
	val offlineVideoEndpoint: OfflineVideoEndpoint? = null,

	@Json(name="unsubscribeEndpoint")
	val unsubscribeEndpoint: UnsubscribeEndpoint? = null
)

data class WebCommandMetadata(

	@Json(name="rootVe")
	val rootVe: Int? = null,

	@Json(name="webPageType")
	val webPageType: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="apiUrl")
	val apiUrl: String? = null,

	@Json(name="sendPost")
	val sendPost: Boolean? = null
)

data class Command(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="signalServiceEndpoint")
	val signalServiceEndpoint: SignalServiceEndpoint? = null,

	@Json(name="changeEngagementPanelVisibilityAction")
	val changeEngagementPanelVisibilityAction: ChangeEngagementPanelVisibilityAction? = null
)

data class PlaylistEditEndpoint(

	@Json(name="playlistId")
	val playlistId: String? = null,

	@Json(name="actions")
	val actions: List<ActionsItem?>? = null
)

data class MicroformatDataRenderer(

	@Json(name="urlApplinksIos")
	val urlApplinksIos: String? = null,

	@Json(name="schemaDotOrgType")
	val schemaDotOrgType: String? = null,

	@Json(name="thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name="noindex")
	val noindex: Boolean? = null,

	@Json(name="appName")
	val appName: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="siteName")
	val siteName: String? = null,

	@Json(name="urlTwitterAndroid")
	val urlTwitterAndroid: String? = null,

	@Json(name="familySafe")
	val familySafe: Boolean? = null,

	@Json(name="iosAppStoreId")
	val iosAppStoreId: String? = null,

	@Json(name="urlApplinksWeb")
	val urlApplinksWeb: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="iosAppArguments")
	val iosAppArguments: String? = null,

	@Json(name="ogType")
	val ogType: String? = null,

	@Json(name="urlTwitterIos")
	val urlTwitterIos: String? = null,

	@Json(name="twitterCardType")
	val twitterCardType: String? = null,

	@Json(name="urlCanonical")
	val urlCanonical: String? = null,

	@Json(name="linkAlternates")
	val linkAlternates: List<LinkAlternatesItem?>? = null,

	@Json(name="urlApplinksAndroid")
	val urlApplinksAndroid: String? = null,

	@Json(name="twitterSiteHandle")
	val twitterSiteHandle: String? = null,

	@Json(name="unlisted")
	val unlisted: Boolean? = null,

	@Json(name="androidPackage")
	val androidPackage: String? = null,

	@Json(name="availableCountries")
	val availableCountries: List<String?>? = null
)

data class MultiPageMenuRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="style")
	val style: String? = null,

	@Json(name="showLoadingSpinner")
	val showLoadingSpinner: Boolean? = null
)

data class Topbar(

	@Json(name="desktopTopbarRenderer")
	val desktopTopbarRenderer: DesktopTopbarRenderer? = null
)

data class PromptMicrophoneLabel(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class CommandsItem(

	@Json(name="openPopupAction")
	val openPopupAction: OpenPopupAction? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

data class VisibilityButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class FrameworkUpdates(

	@Json(name="entityBatchUpdate")
	val entityBatchUpdate: EntityBatchUpdate? = null
)

data class ExitButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class TopbarLogoRenderer(

	@Json(name="endpoint")
	val endpoint: Endpoint? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="iconImage")
	val iconImage: IconImage? = null,

	@Json(name="tooltipText")
	val tooltipText: TooltipText? = null,

	@Json(name="overrideEntityKey")
	val overrideEntityKey: String? = null
)

data class ItemSectionRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="targetId")
	val targetId: String? = null,

	@Json(name="contents")
	val contents: List<ContentsItem?>? = null,

	@Json(name="sectionIdentifier")
	val sectionIdentifier: String? = null
)

data class BackButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class ForwardButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class ThumbnailOverlayNowPlayingRenderer(

	@Json(name="text")
	val text: Text? = null
)

data class Menu(

	@Json(name="menuRenderer")
	val menuRenderer: MenuRenderer? = null
)

data class DesktopTopbarRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="topbarButtons")
	val topbarButtons: List<TopbarButtonsItem?>? = null,

	@Json(name="a11ySkipNavigationButton")
	val a11ySkipNavigationButton: A11ySkipNavigationButton? = null,

	@Json(name="countryCode")
	val countryCode: String? = null,

	@Json(name="hotkeyDialog")
	val hotkeyDialog: HotkeyDialog? = null,

	@Json(name="forwardButton")
	val forwardButton: ForwardButton? = null,

	@Json(name="backButton")
	val backButton: BackButton? = null,

	@Json(name="voiceSearchButton")
	val voiceSearchButton: VoiceSearchButton? = null,

	@Json(name="logo")
	val logo: Logo? = null,

	@Json(name="searchbox")
	val searchbox: Searchbox? = null
)

data class Label(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ContentMetadataViewModel(

	@Json(name="delimiter")
	val delimiter: String? = null,

	@Json(name="metadataRows")
	val metadataRows: List<MetadataRowsItem?>? = null
)

data class ClearButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class UntoggledAccessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

data class PlaceholderText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class TopicChannelDetailsRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="subscribeButton")
	val subscribeButton: SubscribeButton? = null,

	@Json(name="subtitle")
	val subtitle: Subtitle? = null,

	@Json(name="avatar")
	val avatar: Avatar? = null,

	@Json(name="title")
	val title: Title? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null
)

data class RichSectionRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="content")
	val content: Content? = null
)

data class ButtonRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="size")
	val size: String? = null,

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="style")
	val style: String? = null,

	@Json(name="isDisabled")
	val isDisabled: Boolean? = null,

	@Json(name="tooltip")
	val tooltip: String? = null,

	@Json(name="serviceEndpoint")
	val serviceEndpoint: ServiceEndpoint? = null,

	@Json(name="command")
	val command: Command? = null,

	@Json(name="text")
	val text: Text? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="targetId")
	val targetId: String? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null
)

data class ContentsItem(

	@Json(name="richSectionRenderer")
	val richSectionRenderer: RichSectionRenderer? = null,

	@Json(name="itemSectionRenderer")
	val itemSectionRenderer: ItemSectionRenderer? = null,

	@Json(name="continuationItemRenderer")
	val continuationItemRenderer: ContinuationItemRenderer? = null,

	@Json(name="richItemRenderer")
	val richItemRenderer: RichItemRenderer? = null,

	@Json(name="topicChannelDetailsRenderer")
	val topicChannelDetailsRenderer: TopicChannelDetailsRenderer? = null,

	@Json(name="carouselItemRenderer")
	val carouselItemRenderer: CarouselItemRenderer? = null
)

data class ShortBylineText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class LinkAlternatesItem(

	@Json(name="hrefUrl")
	val hrefUrl: String? = null
)

data class CarouselItemsItem(

	@Json(name="defaultPromoPanelRenderer")
	val defaultPromoPanelRenderer: DefaultPromoPanelRenderer? = null
)

data class SubscribeEndpoint(

	@Json(name="channelIds")
	val channelIds: List<String?>? = null,

	@Json(name="params")
	val params: String? = null
)

data class OwnerBadgesItem(

	@Json(name="metadataBadgeRenderer")
	val metadataBadgeRenderer: MetadataBadgeRenderer? = null
)

data class GridVideoRenderer(

	@Json(name="thumbnail")
	val thumbnail: Thumbnail? = null,

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

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="publishedTimeText")
	val publishedTimeText: PublishedTimeText? = null,

	@Json(name="viewCountText")
	val viewCountText: ViewCountText? = null,

	@Json(name="ownerBadges")
	val ownerBadges: List<OwnerBadgesItem?>? = null,

	@Json(name="offlineability")
	val offlineability: Offlineability? = null,

	@Json(name="shortViewCountText")
	val shortViewCountText: ShortViewCountText? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null,

	@Json(name="badges")
	val badges: List<BadgesItem?>? = null
)

data class EngagementPanelPopupPresentationConfig(

	@Json(name="popupType")
	val popupType: String? = null
)

data class Text(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null,

	@Json(name="content")
	val content: String? = null,

	@Json(name="styleRuns")
	val styleRuns: List<StyleRunsItem?>? = null,

	@Json(name="commandRuns")
	val commandRuns: List<CommandRunsItem?>? = null,

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

data class ResponsiveContainerConfiguration(

	@Json(name="enableContentSpecificAspectRatio")
	val enableContentSpecificAspectRatio: Boolean? = null,

	@Json(name="responsiveSize")
	val responsiveSize: String? = null
)

data class BackgroundColor(

	@Json(name="lightTheme")
	val lightTheme: Int? = null,

	@Json(name="darkTheme")
	val darkTheme: Int? = null
)

data class MenuRequest(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="signalServiceEndpoint")
	val signalServiceEndpoint: SignalServiceEndpoint? = null
)

data class MetadataPartsItem(

	@Json(name="maxLines")
	val maxLines: Int? = null,

	@Json(name="text")
	val text: Text? = null
)

data class SectionListRenderer(

	@Json(name="disablePullToRefresh")
	val disablePullToRefresh: Boolean? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="contents")
	val contents: List<ContentsItem?>? = null,

	@Json(name="scrollPaneStyle")
	val scrollPaneStyle: ScrollPaneStyle? = null
)

data class NavigationEndpoint(

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="showEngagementPanelEndpoint")
	val showEngagementPanelEndpoint: ShowEngagementPanelEndpoint? = null,

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="watchEndpoint")
	val watchEndpoint: WatchEndpoint? = null,

	@Json(name="browseEndpoint")
	val browseEndpoint: BrowseEndpoint? = null,

	@Json(name="signInEndpoint")
	val signInEndpoint: SignInEndpoint? = null
)

data class Identifier(

	@Json(name="surface")
	val surface: String? = null,

	@Json(name="tag")
	val tag: String? = null
)

data class Config(

	@Json(name="webSearchboxConfig")
	val webSearchboxConfig: WebSearchboxConfig? = null
)

data class PromptHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class VssLoggingContext(

	@Json(name="serializedContextData")
	val serializedContextData: String? = null
)

data class ThumbnailOverlayTimeStatusRenderer(

	@Json(name="style")
	val style: String? = null,

	@Json(name="text")
	val text: Text? = null
)

data class PermissionsSubtext(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ThumbnailViewModel(

	@Json(name="image")
	val image: Image? = null,

	@Json(name="overlays")
	val overlays: List<OverlaysItem?>? = null,

	@Json(name="backgroundColor")
	val backgroundColor: BackgroundColor? = null
)

data class RunsItem(

	@Json(name="text")
	val text: String? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null
)

data class ItemsItem(

	@Json(name="menuServiceItemRenderer")
	val menuServiceItemRenderer: MenuServiceItemRenderer? = null,

	@Json(name="menuServiceItemDownloadRenderer")
	val menuServiceItemDownloadRenderer: MenuServiceItemDownloadRenderer? = null
)

data class TabsItem(

	@Json(name="tabRenderer")
	val tabRenderer: TabRenderer? = null
)

data class DialogMessagesItem(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ContentImage(

	@Json(name="collectionThumbnailViewModel")
	val collectionThumbnailViewModel: CollectionThumbnailViewModel? = null
)

data class YtConfigData(

	@Json(name="rootVisualElementType")
	val rootVisualElementType: Int? = null,

	@Json(name="visitorData")
	val visitorData: String? = null
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

data class Payload(

	@Json(name="subscriptionStateEntity")
	val subscriptionStateEntity: SubscriptionStateEntity? = null
)

data class OnUnsubscribeEndpointsItem(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="signalServiceEndpoint")
	val signalServiceEndpoint: SignalServiceEndpoint? = null
)

data class UnsubscribedButtonText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ScrollPaneStyle(

	@Json(name="scrollable")
	val scrollable: Boolean? = null
)

data class PublishedTimeText(

	@Json(name="simpleText")
	val simpleText: String? = null
)

data class Thumbnail(

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

data class MicrophoneButtonAriaLabel(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class OfflineabilityRenderer(

	@Json(name="offlineable")
	val offlineable: Boolean? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="infoRenderer")
	val infoRenderer: InfoRenderer? = null,

	@Json(name="formats")
	val formats: List<FormatsItem?>? = null
)

data class ViewCountText(

	@Json(name="simpleText")
	val simpleText: String? = null
)

data class TopbarMenuButtonRenderer(

	@Json(name="menuRequest")
	val menuRequest: MenuRequest? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="tooltip")
	val tooltip: String? = null,

	@Json(name="style")
	val style: String? = null
)

data class WebSearchboxConfig(

	@Json(name="hasOnscreenKeyboard")
	val hasOnscreenKeyboard: Boolean? = null,

	@Json(name="requestLanguage")
	val requestLanguage: String? = null,

	@Json(name="requestDomain")
	val requestDomain: String? = null,

	@Json(name="focusSearchbox")
	val focusSearchbox: Boolean? = null
)

data class OverlaysItem(

	@Json(name="thumbnailHoverOverlayViewModel")
	val thumbnailHoverOverlayViewModel: ThumbnailHoverOverlayViewModel? = null,

	@Json(name="thumbnailOverlayBadgeViewModel")
	val thumbnailOverlayBadgeViewModel: ThumbnailOverlayBadgeViewModel? = null
)

data class Offlineability(

	@Json(name="offlineabilityRenderer")
	val offlineabilityRenderer: OfflineabilityRenderer? = null
)

data class ShowEngagementPanelEndpoint(

	@Json(name="identifier")
	val identifier: Identifier? = null,

	@Json(name="engagementPanel")
	val engagementPanel: EngagementPanel? = null,

	@Json(name="engagementPanelPresentationConfigs")
	val engagementPanelPresentationConfigs: EngagementPanelPresentationConfigs? = null
)

data class WatchEndpointSupportedOnesieConfig(

	@Json(name="html5PlaybackOnesieConfig")
	val html5PlaybackOnesieConfig: Html5PlaybackOnesieConfig? = null
)

data class HotkeyAccessibilityLabel(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

data class PlaceholderHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class CarouselItemRenderer(

	@Json(name="paginationThumbnails")
	val paginationThumbnails: List<PaginationThumbnailsItem?>? = null,

	@Json(name="backgroundColor")
	val backgroundColor: Long? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="carouselItems")
	val carouselItems: List<CarouselItemsItem?>? = null,

	@Json(name="layoutStyle")
	val layoutStyle: String? = null,

	@Json(name="paginatorAlignment")
	val paginatorAlignment: String? = null
)

data class ConnectionErrorHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class PermissionsHeader(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class TopbarButtonsItem(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null,

	@Json(name="topbarMenuButtonRenderer")
	val topbarMenuButtonRenderer: TopbarMenuButtonRenderer? = null
)

data class InlinePlaybackEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="watchEndpoint")
	val watchEndpoint: WatchEndpoint? = null
)

data class Logo(

	@Json(name="topbarLogoRenderer")
	val topbarLogoRenderer: TopbarLogoRenderer? = null
)

data class SubscriptionStateEntity(

	@Json(name="subscribed")
	val subscribed: Boolean? = null,

	@Json(name="key")
	val key: String? = null
)

data class BrowseEndpoint(

	@Json(name="browseId")
	val browseId: String? = null,

	@Json(name="canonicalBaseUrl")
	val canonicalBaseUrl: String? = null,

	@Json(name="params")
	val params: String? = null
)

data class Icon(

	@Json(name="iconType")
	val iconType: String? = null,

	@Json(name="sources")
	val sources: List<SourcesItem?>? = null
)

data class OpenPopupAction(

	@Json(name="popupType")
	val popupType: String? = null,

	@Json(name="popup")
	val popup: Popup? = null,

	@Json(name="beReused")
	val beReused: Boolean? = null
)

data class TabRenderer(

	@Json(name="endpoint")
	val endpoint: Endpoint? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="selected")
	val selected: Boolean? = null,

	@Json(name="content")
	val content: Content? = null
)

data class SmallFormFactorBackgroundThumbnail(

	@Json(name="thumbnailLandscapePortraitRenderer")
	val thumbnailLandscapePortraitRenderer: ThumbnailLandscapePortraitRenderer? = null
)

data class ThumbnailBadgeViewModel(

	@Json(name="icon")
	val icon: Icon? = null,

	@Json(name="badgeStyle")
	val badgeStyle: String? = null,

	@Json(name="text")
	val text: String? = null,

	@Json(name="backgroundColor")
	val backgroundColor: BackgroundColor? = null
)

data class ConnectionErrorMicrophoneLabel(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class Endpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null,

	@Json(name="browseEndpoint")
	val browseEndpoint: BrowseEndpoint? = null,

	@Json(name="showEngagementPanelEndpoint")
	val showEngagementPanelEndpoint: ShowEngagementPanelEndpoint? = null
)

data class UnsubscribeEndpoint(

	@Json(name="channelIds")
	val channelIds: List<String?>? = null,

	@Json(name="params")
	val params: String? = null
)

data class SignalServiceEndpoint(

	@Json(name="signal")
	val signal: String? = null,

	@Json(name="actions")
	val actions: List<ActionsItem?>? = null
)

data class Content(

	@Json(name="richGridRenderer")
	val richGridRenderer: RichGridRenderer? = null,

	@Json(name="sectionListRenderer")
	val sectionListRenderer: SectionListRenderer? = null,

	@Json(name="richShelfRenderer")
	val richShelfRenderer: RichShelfRenderer? = null,

	@Json(name="lockupViewModel")
	val lockupViewModel: LockupViewModel? = null,

	@Json(name="gridVideoRenderer")
	val gridVideoRenderer: GridVideoRenderer? = null
)

data class Searchbox(

	@Json(name="fusionSearchboxRenderer")
	val fusionSearchboxRenderer: FusionSearchboxRenderer? = null
)

data class HotkeyDialogSectionOptionRenderer(

	@Json(name="hotkey")
	val hotkey: String? = null,

	@Json(name="label")
	val label: Label? = null,

	@Json(name="hotkeyAccessibilityLabel")
	val hotkeyAccessibilityLabel: HotkeyAccessibilityLabel? = null
)

data class HotkeyDialogSectionRenderer(

	@Json(name="options")
	val options: List<OptionsItem?>? = null,

	@Json(name="title")
	val title: Title? = null
)

data class UnsubscribeButtonText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class StackColor(

	@Json(name="lightTheme")
	val lightTheme: Int? = null,

	@Json(name="darkTheme")
	val darkTheme: Int? = null
)

data class CancelButton(

	@Json(name="buttonRenderer")
	val buttonRenderer: ButtonRenderer? = null
)

data class ToggledServiceEndpoint(

	@Json(name="commandMetadata")
	val commandMetadata: CommandMetadata? = null,

	@Json(name="playlistEditEndpoint")
	val playlistEditEndpoint: PlaylistEditEndpoint? = null,

	@Json(name="clickTrackingParams")
	val clickTrackingParams: String? = null
)

data class AddToPlaylistCommand(

	@Json(name="onCreateListCommand")
	val onCreateListCommand: OnCreateListCommand? = null,

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="openMiniplayer")
	val openMiniplayer: Boolean? = null,

	@Json(name="listType")
	val listType: String? = null,

	@Json(name="videoIds")
	val videoIds: List<String?>? = null
)

data class InfoRenderer(

	@Json(name="dismissableDialogRenderer")
	val dismissableDialogRenderer: DismissableDialogRenderer? = null
)

data class RichShelfRenderer(

	@Json(name="isExpanded")
	val isExpanded: Boolean? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="endpoint")
	val endpoint: Endpoint? = null,

	@Json(name="showLessButton")
	val showLessButton: ShowLessButton? = null,

	@Json(name="showMoreButton")
	val showMoreButton: ShowMoreButton? = null,

	@Json(name="isTopDividerHidden")
	val isTopDividerHidden: Boolean? = null,

	@Json(name="contents")
	val contents: List<ContentsItem?>? = null,

	@Json(name="responsiveContainerConfiguration")
	val responsiveContainerConfiguration: ResponsiveContainerConfiguration? = null,

	@Json(name="title")
	val title: Title? = null,

	@Json(name="isBottomDividerHidden")
	val isBottomDividerHidden: Boolean? = null
)

data class LockupViewModel(

	@Json(name="metadata")
	val metadata: Metadata? = null,

	@Json(name="rendererContext")
	val rendererContext: RendererContext? = null,

	@Json(name="contentId")
	val contentId: String? = null,

	@Json(name="contentImage")
	val contentImage: ContentImage? = null,

	@Json(name="contentType")
	val contentType: String? = null
)

data class RendererContext(

	@Json(name="commandContext")
	val commandContext: CommandContext? = null,

	@Json(name="loggingContext")
	val loggingContext: LoggingContext? = null
)

data class InlinePlaybackRenderer(

	@Json(name="inlinePlaybackRenderer")
	val inlinePlaybackRenderer: InlinePlaybackRenderer? = null,

	@Json(name="lengthText")
	val lengthText: LengthText? = null,

	@Json(name="inlinePlaybackEndpoint")
	val inlinePlaybackEndpoint: InlinePlaybackEndpoint? = null,

	@Json(name="thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="videoId")
	val videoId: String? = null,

	@Json(name="navigationEndpoint")
	val navigationEndpoint: NavigationEndpoint? = null
)

data class PrimaryThumbnail(

	@Json(name="thumbnailViewModel")
	val thumbnailViewModel: ThumbnailViewModel? = null
)

data class OptionsItem(

	@Json(name="hotkeyDialogSectionOptionRenderer")
	val hotkeyDialogSectionOptionRenderer: HotkeyDialogSectionOptionRenderer? = null
)

data class SignInEndpoint(

	@Json(name="idamTag")
	val idamTag: String? = null
)

data class ReflowOptions(

	@Json(name="minimumRowsOfVideosBetweenSections")
	val minimumRowsOfVideosBetweenSections: Int? = null,

	@Json(name="minimumRowsOfVideosAtStart")
	val minimumRowsOfVideosAtStart: Int? = null
)

data class ThumbnailLandscapePortraitRenderer(

	@Json(name="portrait")
	val portrait: Portrait? = null,

	@Json(name="landscape")
	val landscape: Landscape? = null
)

data class Header(

	@Json(name="carouselHeaderRenderer")
	val carouselHeaderRenderer: CarouselHeaderRenderer? = null,

	@Json(name="engagementPanelTitleHeaderRenderer")
	val engagementPanelTitleHeaderRenderer: EngagementPanelTitleHeaderRenderer? = null
)

data class Landscape(

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

data class ThumbnailBadgesItem(

	@Json(name="thumbnailBadgeViewModel")
	val thumbnailBadgeViewModel: ThumbnailBadgeViewModel? = null
)

data class FormatsItem(

	@Json(name="name")
	val name: Name? = null,

	@Json(name="formatType")
	val formatType: String? = null
)

data class IconImage(

	@Json(name="iconType")
	val iconType: String? = null
)

data class StyleRunsItem(

	@Json(name="startIndex")
	val startIndex: Int? = null,

	@Json(name="length")
	val length: Int? = null,

	@Json(name="weightLabel")
	val weightLabel: String? = null
)

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

data class Avatar(

	@Json(name="thumbnails")
	val thumbnails: List<ThumbnailsItem?>? = null
)

data class ToggledAccessibility(

	@Json(name="accessibilityData")
	val accessibilityData: AccessibilityData? = null
)

data class Subtitle(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

data class ThumbnailsItem(

	@Json(name="width")
	val width: Int? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="height")
	val height: Int? = null
)

data class MenuRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null,

	@Json(name="items")
	val items: List<ItemsItem?>? = null
)

data class ButtonText(

	@Json(name="runs")
	val runs: List<RunsItem?>? = null
)

data class ClientVeSpec(

	@Json(name="uiType")
	val uiType: Int? = null,

	@Json(name="veCounter")
	val veCounter: Int? = null
)

data class CommonConfig(

	@Json(name="url")
	val url: String? = null
)

data class ServiceTrackingParamsItem(

	@Json(name="service")
	val service: String? = null,

	@Json(name="params")
	val params: List<ParamsItem?>? = null
)

data class LengthText(

	@Json(name="simpleText")
	val simpleText: String? = null,

	@Json(name="accessibility")
	val accessibility: Accessibility? = null
)

data class CarouselHeaderRenderer(

	@Json(name="trackingParams")
	val trackingParams: String? = null,

	@Json(name="contents")
	val contents: List<ContentsItem?>? = null
)

data class LargeFormFactorBackgroundThumbnail(

	@Json(name="thumbnailLandscapePortraitRenderer")
	val thumbnailLandscapePortraitRenderer: ThumbnailLandscapePortraitRenderer? = null
)

data class WebResponseContextExtensionData(

	@Json(name="hasDecorated")
	val hasDecorated: Boolean? = null,

	@Json(name="ytConfigData")
	val ytConfigData: YtConfigData? = null
)
