package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class PlaylistItem {

	@Json(name = "compactStationRenderer")
	private CompactStationRenderer compactStationRenderer;

	@Json(name = "gridPlaylistRenderer")
	private GridPlaylistRenderer gridPlaylistRenderer;

	public void setCompactStationRenderer(CompactStationRenderer compactStationRenderer){
		this.compactStationRenderer = compactStationRenderer;
	}

	public CompactStationRenderer getCompactStationRenderer(){
		return compactStationRenderer;
	}

	public void setGridPlaylistRenderer(GridPlaylistRenderer gridPlaylistRenderer){
		this.gridPlaylistRenderer = gridPlaylistRenderer;
	}

	public GridPlaylistRenderer getGridPlaylistRenderer(){
		return gridPlaylistRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"compactStationRenderer = '" + compactStationRenderer + '\'' + 
			",gridPlaylistRenderer = '" + gridPlaylistRenderer + '\'' + 
			"}";
		}
}