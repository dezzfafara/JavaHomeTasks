package task7_3;

public class StringContainer {

	private String[] myStringArray;

	private int averageLengthOfString;

	public int getAverageLengthOfString() {
		return averageLengthOfString;
	}

	public StringContainer() {

	}

	public StringContainer(int sizeOfArray) {
		myStringArray = new String[sizeOfArray];
	}

	public void setElementOfStringArray(int index, String value) {
		myStringArray[index] = value;
	}

	public int getLengthOfArray() {
		return myStringArray.length;
	}

	public void countAverageLengthOfStrings() {
		int lengthOfAllStrings = 0;
		for (String elementOfArray : myStringArray) {
			lengthOfAllStrings += elementOfArray.length();
		}

		this.averageLengthOfString = (int) Math.round((double) lengthOfAllStrings / myStringArray.length);
	}

	private void printStringWithLength(int index) {
		System.out.println(myStringArray[index] + "; length: " + myStringArray[index].length());
	}

	public void printStrings(boolean isMoreThanAverage) {
		{
			for (int i = 0; i < myStringArray.length; i++) {
				if (isMoreThanAverage) {
					if (myStringArray[i].length() > this.averageLengthOfString) {
						this.printStringWithLength(i);
					}
				} else {
					if (myStringArray[i].length() < this.averageLengthOfString) {
						this.printStringWithLength(i);
					}
				}
			}
		}

	}
}
