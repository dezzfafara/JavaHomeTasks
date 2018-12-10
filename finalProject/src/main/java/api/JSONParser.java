package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {
	private JSONObject json;
	private String objectName;
	private String parameterName;
	private int indexOfParameter;

	public JSONParser() {
		objectName = "response";
		parameterName = "body";
		indexOfParameter = 1;
	}

	public void setJsonObject(String response) {
		this.json = new JSONObject(response);
	}

	public String getParameterValue(String parameter) {
		return String.valueOf(json.getBigDecimal(parameter));
	}

	public String getParameterAndItsValue(String parameter) {
		json = new JSONObject(json.getJSONObject(objectName).toString());
		return String.valueOf(json.getBigDecimal(parameter));
	}

	public String getParameterValue() {

		JSONArray jArray = json.getJSONArray(objectName);
		json = new JSONObject(jArray.getJSONObject(indexOfParameter).toString());
		return json.getString(parameterName);
	}

	public boolean responseMatcher(String valueToMatch, String matchPattern) {
		Pattern pattern = Pattern.compile(matchPattern);
		Matcher matcher = pattern.matcher(valueToMatch);
		return matcher.matches();
	}
}