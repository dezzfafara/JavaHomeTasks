package task8_17;

public class TextHandler {

	private String originalString;
	private String[] arrayOfSubstrings;

	public TextHandler() {
		this.originalString = "";
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public void fillArrayOfSubstrings() {
		this.arrayOfSubstrings = this.originalString.split("[a-zA-Z]+");
	}

	public String getTheLongestSubstring() {
		int maximalLength = 0;
		int maximalLengthIndex = 0;

		for (int i = 0; i < this.arrayOfSubstrings.length; i++) {
			if (this.arrayOfSubstrings[i].length() > maximalLength) {
				maximalLength = this.arrayOfSubstrings[i].length();
				maximalLengthIndex = i;
			}
		}
		return this.arrayOfSubstrings[maximalLengthIndex];
	}

}
