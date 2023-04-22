package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

public class ContinuationCommand{

	@Json(name = "request")
	private String request;

	@Json(name = "token")
	private String token;

	public String getRequest() {
		return request;
	}

	public String getToken() {
		return token;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ContinuationCommand{" +
				"request='" + request + '\'' +
				", token='" + token + '\'' +
				'}';
	}
}