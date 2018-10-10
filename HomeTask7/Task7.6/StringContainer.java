package task7_6;

import java.util.ArrayList;

public class StringContainer {

	private String[] myStringArray;
	private ArrayList<String> listOfAscendingStrings;

	public StringContainer() {
		this.listOfAscendingStrings = new ArrayList<String>();
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

	public void printList(ArrayList<String> listToPrint) {
		for (String element : listToPrint) {
			System.out.println("\"" + element + "\"");
		}
	}

	private boolean verifyStringForAscendingSymbols(String stringToVerify) {
		if (stringToVerify.length() <= 1) {
			return false;
		} else {
			for (int i = 0; i < stringToVerify.length() - 1; i++) {

				if (stringToVerify.charAt(i) >= stringToVerify.charAt(i + 1)) {
					return false;
				}
			}
		}
		return true;
	}

	public void fillListOfAscendingWords() {
		for (String elementOfStringArray : this.myStringArray) {
			if (this.verifyStringForAscendingSymbols(elementOfStringArray)) {
				this.listOfAscendingStrings.add(elementOfStringArray);
			}
		}
	}

	public int getListSize() {
		return this.listOfAscendingStrings.size();
	}

	public String getElementOfList(int index) {
		return this.listOfAscendingStrings.get(index);
	}
}
