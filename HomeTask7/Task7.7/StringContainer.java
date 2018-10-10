package task7_7;

import java.util.ArrayList;

public class StringContainer {

	private String[] myStringArray;
	private ArrayList<String> myArrayList;

	public StringContainer() {
		myArrayList = new ArrayList<String>();
	}

	public StringContainer(int sizeOfArray) {
		this();
		myStringArray = new String[sizeOfArray];
	}

	private boolean verifyStringForUniqueSymbols(String elementOfStringArray) {
		boolean isUnique = true;
		for (int i = 0; i < elementOfStringArray.length(); i++) {
			for (int j = 0; j < elementOfStringArray.length(); j++) {
				if (i != j && elementOfStringArray.charAt(i) == elementOfStringArray.charAt(j)) {
					isUnique = false;
					break;
				}
			}
			if (!isUnique) {
				break;
			}

		}
		return isUnique;
	}

	public void handleStringsWithUniqueSymbols() {
		for (int i = 0; i < myStringArray.length; i++) {
			if (verifyStringForUniqueSymbols(myStringArray[i])) {
				myArrayList.add(myStringArray[i]);
			}
		}

	}

	public String getElementFromList(int index) {
		return myArrayList.get(index);
	}

	public void setElementOfStringArray(int index, String value) {
		myStringArray[index] = value;
	}

	public int getLengthOfArray() {
		return myStringArray.length;
	}

	public int getSizeOfList() {
		return myArrayList.size();
	}

}
