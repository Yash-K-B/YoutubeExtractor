package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SignalServiceEndpoint{

	@SerializedName("signal")
	private String signal;

	@SerializedName("actions")
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