package task8_19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {

	private String originalString;
	private String resultString;
	private String[] arrayOfWords;

	public TextHandler() {
		this.originalString = "";
		this.resultString = "";
	}

	public String getResultString() {
		return resultString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public void fillArrayOfWords() {
		this.arrayOfWords = this.originalString.split(" ");
	}

	private boolean isAlphabetical(String wordToVerify) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(wordToVerify);
		return matcher.matches();
	}

	public String firstLetterToUpperCase() {
		for (String word : this.arrayOfWords) {
			if (this.isAlphabetical(word)) {
				word = Character.toUpperCase(word.charAt(0)) + word.substring(1, word.length());
			}
			this.resultString += word + " ";
		}
		return this.resultString;
	}

}