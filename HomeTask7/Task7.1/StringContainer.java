package task7_1;

public class StringContainer {

	private String[] myStringArray;
	private String shortestString;
	private String longestString;
	private int shortestStringLength;
	private int longestStringLength;

	public StringContainer() {
		this.shortestString = "";
		this.longestString = "";
		this.shortestStringLength = 0;
		this.longestStringLength = 0;
	}

	public StringContainer(int sizeOfArray) {
		this();
		myStringArray = new String[sizeOfArray];
	}

	public String getShortestString() {
		return shortestString;
	}

	public String getLongestString() {
		return longestString;
	}

	public int getShortestStringLength() {
		return shortestStringLength;
	}

	public int getLongestStringLength() {
		return longestStringLength;
	}

	public void setElementOfStringArray(int index, String value) {
		myStringArray[index] = value;
	}

	public void handleStrings() {
		int minimalLength = myStringArray[0].length();
		int maximalLength = myStringArray[myStringArray.length - 1].length();
		int shortestIndex = 0;
		int longestIndex = 0;
		for (int i = 1; i < myStringArray.length; i++) {
			if (myStringArray[i].length() < minimalLength) {
				minimalLength = myStringArray[i].length();
				shortestIndex = i;
				this.shortestString = myStringArray[i];
			}
		}

		for (int i = myStringArray.length - 2; i >= 0; i--) {
			if (myStringArray[i].length() > maximalLength) {
				maximalLength = myStringArray[i].length();
				longestIndex = i;
				this.longestString = myStringArray[i];
			}
		}

		this.shortestStringLength = minimalLength;
		this.longestStringLength = maximalLength;
		this.shortestString = myStringArray[shortestIndex];
		this.longestString = myStringArray[longestIndex];
	}

	public int getLengthOfArray() {
		return myStringArray.length;
	}
}
