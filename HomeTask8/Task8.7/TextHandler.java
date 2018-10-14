package task8_7;

import java.util.regex.Pattern;

public class TextHandler {

	private String stringToClean;

	public TextHandler() {
		this.stringToClean = "";
	}

	public void setStringToClean(String stringToClean) {
		this.stringToClean = stringToClean;
	}

	public String getStringToClean() {
		return this.stringToClean;
	}

	public void modifyString() {
		this.deleteSymbols();
		this.replaceSpaces();
	}

	private void deleteSymbols() {
		this.stringToClean = Pattern.compile("(?u)[^\\pL ]").matcher(this.stringToClean).replaceAll("");
	}

	private void replaceSpaces() {
		this.stringToClean = Pattern.compile("[\\s ]+").matcher(this.stringToClean).replaceAll(" ");
	}

}

//
//StringBuilder sb = new StringBuilder("Hi there, are you there?");
//		System.out.println(Pattern.compile("there").matcher(sb).replaceAll("niru"));