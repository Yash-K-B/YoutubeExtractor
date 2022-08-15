package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;

public class SignalServiceEndpoint{

	@Json(name="signal")
	private String signal;

	@Json(name="actions")
	private List<ActionsItem> actions;

	public void setSignal(String signal){
		this.signal = signal;
	}

	public String getSignal(){
		return signal;
	}

	public void setActions(List<ActionsItem> actions){
		this.actions = actions;
	}

	public List<ActionsItem> getActions(){
		return actions;
	}

	@Override
 	public String toString(){
		return 
			"SignalServiceEndpoint{" + 
			"signal = '" + signal + '\'' + 
			",actions = '" + actions + '\'' + 
			"}";
		}
}