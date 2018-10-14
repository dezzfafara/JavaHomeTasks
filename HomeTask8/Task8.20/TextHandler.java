package task8_20;

public class TextHandler {
	private String originalString;
	private String punctuationPattern;

	public TextHandler() {
		this.originalString = "";
		this.punctuationPattern = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~`";
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	private boolean isPunctuationMark(char symbolToVerify) {
		for (int i = 0; i < this.punctuationPattern.length(); i++) {
			if (symbolToVerify == this.punctuationPattern.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public int getpunctuationQuantity() {
		int count = 0;
		for (int i = 0; i < this.originalString.length(); i++) {
			if (this.isPunctuationMark(this.originalString.charAt(i))) {
				count++;
			}
		}
		return count;
	}

}
