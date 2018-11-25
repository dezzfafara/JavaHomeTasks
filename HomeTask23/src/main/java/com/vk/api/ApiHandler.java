package com.vk.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ApiHandler {
	private final static int leftLimit = 1;
	private final static int rightLimit = 999999999;
	private final static String BASE_API_PATH = "https://api.vk.com/method/";
	private final static String PARAMETER_NAME = "response";
	private int statusCode;
	private StringBuilder JSONResponse;
	private HttpClient client;
	private URIBuilder builder;
	private HttpGet getRequest;
	private HttpResponse response;
	private JSONParser jsonParser;
	private String messageId = "";

	public ApiHandler() {
		this.client = HttpClientBuilder.create().build();
		this.statusCode = 0;
		this.JSONResponse = new StringBuilder();
		this.jsonParser = new JSONParser();
	}

	public void sendMessage(String... requestParameters)
			throws URISyntaxException, ClientProtocolException, IOException {
		sendRequest(requestParameters);
		jsonParser.setJsonObject(JSONResponse.toString());
		messageId = jsonParser.getParameterValue(PARAMETER_NAME);
	}

	public void editMessage(String... requestParameters)
			throws ClientProtocolException, URISyntaxException, IOException {
		sendRequest(requestParameters);
		jsonParser.setJsonObject(JSONResponse.toString());
	}

	public String getMessageId() {
		return this.messageId;
	}

	public String getMessageText(String... requestParameters)
			throws ClientProtocolException, URISyntaxException, IOException {
		sendRequest(requestParameters);
		jsonParser.setJsonObject(JSONResponse.toString());
		return jsonParser.getParameterValue();
	}

	private void sendRequest(String... requestParameters)
			throws URISyntaxException, ClientProtocolException, IOException {
		builder = new URIBuilder(BASE_API_PATH + requestParameters[0]);
		setParameters(builder, requestParameters);
		getRequest = new HttpGet(builder.build());
		response = client.execute(getRequest);
		setStatusCodeAndResponse(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity()));
	}

	public void deleteMessage(String... requestParameters)
			throws ClientProtocolException, URISyntaxException, IOException {
		sendRequest(requestParameters);
		jsonParser.setJsonObject(JSONResponse.toString());
	}

	public boolean isSuccessfullResponse(String pattern) {
		return jsonParser.responseMatcher(jsonParser.getParameterValue(PARAMETER_NAME), pattern);
	}

	public int getDigitResponseValue() {
		return Integer.parseInt(jsonParser.getParameterValue(PARAMETER_NAME));
	}

	public int getDigitResponseValue(String parameter) {
		return Integer.parseInt(jsonParser.getParameterAndItsValue(parameter));
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public String getJSONResponse() {
		return this.JSONResponse.toString();
	}

	private void setParameters(URIBuilder builder, String... parameters) {
		HashMap<String, String> requestParameters = new HashMap<String, String>();
		for (int i = 1; i < parameters.length - 1; i += 2) {
			requestParameters.put(parameters[i], parameters[i + 1]);
		}
		for (Map.Entry<String, String> parameter : requestParameters.entrySet()) {
			builder.setParameter(parameter.getKey(), parameter.getValue());
		}
	}

	private void setStatusCodeAndResponse(int statusCode, String JSONResponse) {
		this.statusCode = statusCode;
		this.JSONResponse.setLength(0);
		this.JSONResponse.append(JSONResponse);
	}

	public String randomGenerator() {
		return String.valueOf(leftLimit + (int) (Math.random() * (rightLimit - leftLimit)));
	}

}