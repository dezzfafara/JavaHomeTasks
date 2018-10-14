package task8_18;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {

	private String originalText;
	String[] arrayOfWords;
	HashMap<Character, Integer> counterOfConsonants;

	public TextHandler() {
		originalText = "";
		counterOfConsonants = new HashMap<Character, Integer>();
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public void fillArrayOfWords() {
		this.arrayOfWords = this.originalText.split(" ");
	}

	private boolean isConsonant(char symbolToAnalyse) {
		Pattern pattern = Pattern.compile("(?i:[BCDFGHJKLMNPQRSTVWXYZ])");
		Matcher matcher = pattern.matcher(Character.toString(symbolToAnalyse));
		return (matcher.matches() ? true : false);

	}

	public void fillCounterOfConsonants() {
		boolean isUnique = true;
		for (String word : this.arrayOfWords) {
			for (int i = 0; i < word.length(); i++) {
				isUnique = true;
				if (this.isConsonant(word.charAt(i))) {
					for (int j = i; j < word.length(); j++) {
						if (i != j && word.charAt(j) == word.charAt(i)) {
							isUnique = false;
							break;
						}
					}
					if (isUnique) {
						if (!this.counterOfConsonants.containsKey(word.charAt(i))) {
							this.counterOfConsonants.put(word.charAt(i), 1);
						} else {
							this.counterOfConsonants.put(word.charAt(i),
									this.counterOfConsonants.get(word.charAt(i)) + 1);
						}
					}
				}
			}
		}

	}

	public void printCounterOfConsonants() {
		for (char symbol : this.counterOfConsonants.keySet()) {
			if (this.counterOfConsonants.get(symbol) <= 2) {
				System.out.println(
						"Symbol \"" + symbol + "\" meets in " + this.counterOfConsonants.get(symbol) + " word(s)");
			}
		}
	}

}
