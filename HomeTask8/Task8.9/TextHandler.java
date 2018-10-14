package task8_9;

import java.util.HashMap;

public class TextHandler {

	private String originalText;
	String[] arrayOfWords;
	HashMap<String, Integer> counterOfWords;

	public TextHandler() {
		originalText = "";
		counterOfWords = new HashMap<String, Integer>();
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public void fillArrayOfWords() {
		this.arrayOfWords = this.originalText.split(" ");
	}

	public void fillCounterOfWords() {
		for (String word : this.arrayOfWords) {
			if (!this.counterOfWords.containsKey(word)) {
				this.counterOfWords.put(word, 0);
			}

			this.counterOfWords.put(word, this.counterOfWords.get(word) + 1);
		}
	}

	public void printCounterOfWords() {
		for (String word : this.counterOfWords.keySet()) {
			System.out.println("Word \"" + word + "\" repeats " + this.counterOfWords.get(word) + " time(s)");
		}
	}
}
