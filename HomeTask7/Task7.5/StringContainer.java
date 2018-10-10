package task7_5;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringContainer {

	private String[] myStringArray;
	private ArrayList<String> listOfLatins;
	private ArrayList<String> listOfVowelsEqualConsonants;
	private String latinPattern;
	private String vowelsPattern;

	public StringContainer() {
		this.latinPattern = "^[a-zA-Z]+$";
		this.vowelsPattern = "[aeiouyAEIOUY]";
		this.listOfLatins = new ArrayList<String>();
		this.listOfVowelsEqualConsonants = new ArrayList<String>();
	}

	public StringContainer(int sizeOfArray) {
		this();
		myStringArray = new String[sizeOfArray];
	}

	public void setElementOfStringArray(int index, String value) {
		myStringArray[index] = value;
	}

	public int getLengthOfArray() {
		return myStringArray.length;
	}

	private boolean verifyPatternCompatibilty(String patternToVerify, String valueToVerify) {
		Pattern pattern = Pattern.compile(patternToVerify);
		Matcher matcher = pattern.matcher(valueToVerify);
		return matcher.matches();
	}

	public void fillListOfLatins() {
		for (String elementOfArray : myStringArray) {
			if (this.verifyPatternCompatibilty(this.latinPattern, elementOfArray)) {
				this.listOfLatins.add(elementOfArray);
			}
		}
	}

	public void fillListOfVowelsEqualConsonants() {
		int vowelsCount = 0;
		int consonantsCount = 0;
		for (String element : listOfLatins) {
			String[] arrayOfLetters = element.split("");
			for (int i = 0; i < arrayOfLetters.length; i++) {
				if (this.verifyPatternCompatibilty(this.vowelsPattern, arrayOfLetters[i])) {
					vowelsCount++;
				} else {
					consonantsCount++;
				}

			}
			if (vowelsCount == consonantsCount) {
				listOfVowelsEqualConsonants.add(element);
			}
			vowelsCount = consonantsCount = 0;
		}
	}

	public int getSizeOfLatinsList() {
		return listOfLatins.size();
	}

	public int getSizeOfVowelsEqualConsonantsList() {
		return listOfVowelsEqualConsonants.size();
	}

	public void printList(ArrayList<String> listToPrint) {
		for (String element : listToPrint) {
			System.out.println("\"" + element + "\"");
		}
	}

	public ArrayList<String> getListOfLatins() {
		return listOfLatins;
	}

	public ArrayList<String> getListOfVowelsEqualConsonants() {
		return listOfVowelsEqualConsonants;
	}

}
