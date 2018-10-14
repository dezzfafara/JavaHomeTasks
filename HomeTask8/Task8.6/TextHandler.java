package task8_6;

public class TextHandler {

	private String originalString;
	private String resultString;
	private String[] arrayOfWords;
	private String symbolForCompare;

	public TextHandler() {
		this.originalString = "";
		this.resultString = "";
	}

	public void setSymbolForCompare(String symbolForCompare) {
		this.symbolForCompare = symbolForCompare;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public void fillArrayOfWords() {
		this.arrayOfWords = this.originalString.split(" ");
	}

	private boolean wordChecker(String wordToCheck) {
		for (int i = 0; i < wordToCheck.length(); i++) {
			if (wordToCheck.charAt(i) == this.symbolForCompare.charAt(0)) {
				return true;
			}
		}
		return false;
	}

	public String wordsHandler(int positionToSet) {
		for (int i = 0; i < this.arrayOfWords.length; i++) {
			if (this.wordChecker(this.arrayOfWords[i])) {
				this.arrayOfWords[i] = this.arrayOfWords[i].replaceAll(symbolForCompare, "");
			} else {
				this.arrayOfWords[i] = this.arrayOfWords[i].substring(0, positionToSet) + this.symbolForCompare
						+ this.arrayOfWords[i].substring(positionToSet, this.arrayOfWords[i].length());
			}
			this.resultString += arrayOfWords[i] + " ";
		}
		return this.resultString;
	}

}
