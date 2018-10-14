package task8_21;

public class TextHandler {
	private String originalString;
	private String digitsPattern;

	public TextHandler() {
		this.originalString = "";
		this.digitsPattern = "0123456789";
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	private boolean isDigit(char symbolToVerify) {
		for (int i = 0; i < this.digitsPattern.length(); i++) {
			if (symbolToVerify == this.digitsPattern.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public long getSummOfDidgits() {
		long summOfDigits = 0;
		for (int i = 0; i < this.originalString.length(); i++) {
			if (this.isDigit(this.originalString.charAt(i))) {
				summOfDigits += Character.getNumericValue(this.originalString.charAt(i));
			}
		}
		return summOfDigits;
	}
}
