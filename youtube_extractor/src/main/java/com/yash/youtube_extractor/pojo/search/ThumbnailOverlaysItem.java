package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ThumbnailOverlaysItem{

	@SerializedName("thumbnailOverlayNowPlayingRenderer")
	private ThumbnailOverlayNowPlayingRenderer thumbnailOverlayNowPlayingRenderer;

	@SerializedName("thumbnailOverlayToggleButtonRenderer")
	private ThumbnailOverlayToggleButtonRenderer thumbnailOverlayToggleButtonRenderer;

	@SerializedName("thumbnailOverlayTimeStatusRenderer")
	private ThumbnailOverlayTimeStatusRenderer thumbnailOverlayTimeStatusRenderer;

	public void setThumbnailOverlayNowPlayingRenderer(ThumbnailOverlayNowPlayingRenderer thumbnailOverlayNowPlayingRenderer){
		this.thumbnailOverlayNowPlayingRenderer = thumbnailOverlayNowPlayingRenderer;
	}

	public ThumbnailOverlayNowPlayingRenderer getThumbnailOverlayNowPlayingRenderer(){
		return thumbnailOverlayNowPlayingRenderer;
	}

	public void setThumbnailOverlayToggleButtonRenderer(ThumbnailOverlayToggleButtonRenderer thumbnailOverlayToggleButtonRenderer){
		this.thumbnailOverlayToggleButtonRenderer = thumbnailOverlayToggleButtonRenderer;
	}

	public ThumbnailOverlayToggleButtonRenderer getThumbnailOverlayToggleButtonRenderer(){
		return thumbnailOverlayToggleButtonRenderer;
	}

	public void setThumbnailOverlayTimeStatusRenderer(ThumbnailOverlayTimeStatusRenderer thumbnailOverlayTimeStatusRenderer){
		this.thumbnailOverlayTimeStatusRenderer = thumbnailOverlayTimeStatusRenderer;
	}

	public ThumbnailOverlayTimeStatusRenderer getThumbnailOverlayTimeStatusRenderer(){
		return thumbnailOverlayTimeStatusRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlaysItem{" + 
			"thumbnailOverlayNowPlayingRenderer = '" + thumbnailOverlayNowPlayingRenderer + '\'' + 
			",thumbnailOverlayToggleButtonRenderer = '" + thumbnailOverlayToggleButtonRenderer + '\'' + 
			",thumbnailOverlayTimeStatusRenderer = '" + thumbnailOverlayTimeStatusRenderer + '\'' + 
			"}";
		}
}