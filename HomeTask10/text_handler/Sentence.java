package text_handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sentence implements ITextElementHandler {
	private final static String SPLIT_PATTERN = " ";
	private String[] arrayOfWords;
	private String stringOfParagraphs;

	Sentence() {
		stringOfParagraphs = "";
	}

	@Override
	public void handleTextElement(String tempTextElement) {
		stringOfParagraphs += tempTextElement + " ";
	}

	void stringToArrayOfWords() {
		arrayOfWords = stringOfParagraphs.split(SPLIT_PATTERN);
	}

	String[] getArrayOfWords() {
		return this.arrayOfWords;
	}

	void setWord(int index, String word) {
		arrayOfWords[index] = word;
	}

	private boolean endOfParagraph(String stringToVerify) {
		Pattern pattern = Pattern.compile(".*[\\r\\n]$");
		Matcher matcher = pattern.matcher(stringToVerify);
		return matcher.matches();
	}

	void modifyStringOfParagraphs() {
		stringOfParagraphs = "";
		for (String word : arrayOfWords) {
			stringOfParagraphs += word;
			if (!endOfParagraph(word)) {
				stringOfParagraphs += " ";
			}
		}
	}

	String getStringOfParagraphs() {
		return stringOfParagraphs;
	}
}
