package task8_8;

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

	public void deleteSymbols(String startBorderSymbol, String endBorderSymbol) {
		this.stringToClean = Pattern.compile("\\" + startBorderSymbol + "[^\\" + startBorderSymbol + "]+\\" + endBorderSymbol)
				.matcher(this.stringToClean).replaceAll(startBorderSymbol + endBorderSymbol);
	}

}
