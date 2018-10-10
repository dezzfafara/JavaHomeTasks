package task7_2;

public class StringContainer {

	private String[] myStringArray;

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

	private void replaceElements(int index) {

		String tempString = myStringArray[index];
		myStringArray[index] = myStringArray[index + 1];
		myStringArray[index + 1] = tempString;
	}

	public void sortStringArray(boolean isAscending) {

		for (int i = 0; i < myStringArray.length; i++) {
			for (int j = 0; j < myStringArray.length - 1; j++) {
				if (isAscending) {
					if (myStringArray[j].length() > myStringArray[j + 1].length()) {
						this.replaceElements(j);
					}
				} else {
					if (myStringArray[j].length() < myStringArray[j + 1].length()) {
						this.replaceElements(j);
					}
				}
			}
		}
	}

	public void printStringArray() {
		for (String elementOfArray : myStringArray) {
			System.out.println("[" + elementOfArray + "]");
		}
	}
}
