package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ThumbnailOverlaysItem{

	@Json(name = "thumbnailOverlayNowPlayingRenderer")
	private ThumbnailOverlayNowPlayingRenderer thumbnailOverlayNowPlayingRenderer;

	@Json(name = "thumbnailOverlayHoverTextRenderer")
	private ThumbnailOverlayHoverTextRenderer thumbnailOverlayHoverTextRenderer;

	@Json(name = "thumbnailOverlaySidePanelRenderer")
	private ThumbnailOverlaySidePanelRenderer thumbnailOverlaySidePanelRenderer;

	public void setThumbnailOverlayNowPlayingRenderer(ThumbnailOverlayNowPlayingRenderer thumbnailOverlayNowPlayingRenderer){
		this.thumbnailOverlayNowPlayingRenderer = thumbnailOverlayNowPlayingRenderer;
	}

	public ThumbnailOverlayNowPlayingRenderer getThumbnailOverlayNowPlayingRenderer(){
		return thumbnailOverlayNowPlayingRenderer;
	}

	public void setThumbnailOverlayHoverTextRenderer(ThumbnailOverlayHoverTextRenderer thumbnailOverlayHoverTextRenderer){
		this.thumbnailOverlayHoverTextRenderer = thumbnailOverlayHoverTextRenderer;
	}

	public ThumbnailOverlayHoverTextRenderer getThumbnailOverlayHoverTextRenderer(){
		return thumbnailOverlayHoverTextRenderer;
	}

	public void setThumbnailOverlaySidePanelRenderer(ThumbnailOverlaySidePanelRenderer thumbnailOverlaySidePanelRenderer){
		this.thumbnailOverlaySidePanelRenderer = thumbnailOverlaySidePanelRenderer;
	}

	public ThumbnailOverlaySidePanelRenderer getThumbnailOverlaySidePanelRenderer(){
		return thumbnailOverlaySidePanelRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlaysItem{" + 
			"thumbnailOverlayNowPlayingRenderer = '" + thumbnailOverlayNowPlayingRenderer + '\'' + 
			",thumbnailOverlayHoverTextRenderer = '" + thumbnailOverlayHoverTextRenderer + '\'' + 
			",thumbnailOverlaySidePanelRenderer = '" + thumbnailOverlaySidePanelRenderer + '\'' + 
			"}";
		}
}