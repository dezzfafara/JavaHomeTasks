package task8_5;

public class TextHandler {

	private String originalString;
	private String resultString;
	private String[] arrayOfWords;

	public TextHandler() {
		this.originalString = "";
		this.resultString = "";
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public String getResultString(String substringToVerify, String substringToAdd) {
		for (String elementOfArray : this.arrayOfWords) {
			if (elementOfArray.endsWith(substringToVerify)) {
				this.resultString += elementOfArray + " " + substringToAdd + " ";
			} else {
				this.resultString += elementOfArray + " ";
			}
		}
		return this.resultString;
	}

	public void fillArrayOfWords() {
		this.arrayOfWords = this.originalString.split(" ");
	}

}
