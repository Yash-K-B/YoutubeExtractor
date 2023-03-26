package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class ThumbnailOverlaysItem{

	@Json(name="thumbnailOverlayNowPlayingRenderer")
	private ThumbnailOverlayNowPlayingRenderer thumbnailOverlayNowPlayingRenderer;

	@Json(name="thumbnailOverlayTimeStatusRenderer")
	private ThumbnailOverlayTimeStatusRenderer thumbnailOverlayTimeStatusRenderer;

	@Json(name="thumbnailOverlayResumePlaybackRenderer")
	private ThumbnailOverlayResumePlaybackRenderer thumbnailOverlayResumePlaybackRenderer;

	@Json(name="thumbnailOverlayPlaybackStatusRenderer")
	private ThumbnailOverlayPlaybackStatusRenderer thumbnailOverlayPlaybackStatusRenderer;

	public void setThumbnailOverlayNowPlayingRenderer(ThumbnailOverlayNowPlayingRenderer thumbnailOverlayNowPlayingRenderer){
		this.thumbnailOverlayNowPlayingRenderer = thumbnailOverlayNowPlayingRenderer;
	}

	public ThumbnailOverlayNowPlayingRenderer getThumbnailOverlayNowPlayingRenderer(){
		return thumbnailOverlayNowPlayingRenderer;
	}

	public void setThumbnailOverlayTimeStatusRenderer(ThumbnailOverlayTimeStatusRenderer thumbnailOverlayTimeStatusRenderer){
		this.thumbnailOverlayTimeStatusRenderer = thumbnailOverlayTimeStatusRenderer;
	}

	public ThumbnailOverlayTimeStatusRenderer getThumbnailOverlayTimeStatusRenderer(){
		return thumbnailOverlayTimeStatusRenderer;
	}

	public void setThumbnailOverlayResumePlaybackRenderer(ThumbnailOverlayResumePlaybackRenderer thumbnailOverlayResumePlaybackRenderer){
		this.thumbnailOverlayResumePlaybackRenderer = thumbnailOverlayResumePlaybackRenderer;
	}

	public ThumbnailOverlayResumePlaybackRenderer getThumbnailOverlayResumePlaybackRenderer(){
		return thumbnailOverlayResumePlaybackRenderer;
	}

	public void setThumbnailOverlayPlaybackStatusRenderer(ThumbnailOverlayPlaybackStatusRenderer thumbnailOverlayPlaybackStatusRenderer){
		this.thumbnailOverlayPlaybackStatusRenderer = thumbnailOverlayPlaybackStatusRenderer;
	}

	public ThumbnailOverlayPlaybackStatusRenderer getThumbnailOverlayPlaybackStatusRenderer(){
		return thumbnailOverlayPlaybackStatusRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlaysItem{" + 
			"thumbnailOverlayNowPlayingRenderer = '" + thumbnailOverlayNowPlayingRenderer + '\'' + 
			",thumbnailOverlayTimeStatusRenderer = '" + thumbnailOverlayTimeStatusRenderer + '\'' + 
			",thumbnailOverlayResumePlaybackRenderer = '" + thumbnailOverlayResumePlaybackRenderer + '\'' + 
			",thumbnailOverlayPlaybackStatusRenderer = '" + thumbnailOverlayPlaybackStatusRenderer + '\'' + 
			"}";
		}
}