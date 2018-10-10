package task7_8;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringContainer {

	private StringBuilder[] myStringArray;
	private ArrayList<StringBuilder> listOfDigitalStrings;
	private ArrayList<StringBuilder> listOfDigitalPalindromes;
	private String digitalPattern;

	public StringContainer() {
		this.listOfDigitalStrings = new ArrayList<StringBuilder>();
		listOfDigitalPalindromes = new ArrayList<StringBuilder>();
		this.digitalPattern = "^[0-9]+$";
	}

	public StringContainer(int sizeOfArray) {
		this();
		myStringArray = new StringBuilder[sizeOfArray];
	}

	public void setElementOfStringArray(int index, String value) {
		myStringArray[index] = new StringBuilder(value);
	}

	public int getLengthOfArray() {
		return myStringArray.length;
	}

	private boolean patternMatcher(StringBuilder stringToMatch) {
		Pattern pattern = Pattern.compile(this.digitalPattern);
		Matcher matcher = pattern.matcher(stringToMatch);
		return matcher.matches();
	}

	public void fillListOfDigitalStrings() {
		for (StringBuilder elementOfArray : myStringArray) {
			if (this.patternMatcher(elementOfArray) && elementOfArray.length() >= 2) {
				listOfDigitalStrings.add(elementOfArray);
			}
		}
	}

	private boolean verifyPalindrome(StringBuilder stringToVerify) {
		StringBuilder reversedString = new StringBuilder(stringToVerify);
		reversedString.reverse();

		return (reversedString.toString().equals(stringToVerify.toString()));
	}

	public void fillListOfDigitalPalindromes() {
		for (StringBuilder elementOfList : listOfDigitalStrings) {
			if (this.verifyPalindrome(elementOfList)) {
				this.listOfDigitalPalindromes.add(elementOfList);
			}
		}
	}

	public ArrayList<StringBuilder> getListOfDigitalPalindromes() {
		return listOfDigitalPalindromes;
	}

	public int getSizeOfDigitalPalindromesList() {
		return this.listOfDigitalPalindromes.size();
	}

	public StringBuilder getElementOfList(int index) {
		return listOfDigitalPalindromes.get(index);
	}

}
