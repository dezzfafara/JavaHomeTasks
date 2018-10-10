package task7_4;

import java.util.ArrayList;

public class StringContainer {

	private String[] myStringArray;
	private ArrayList<Integer> countlistOfUniqueSymbols;

	public StringContainer() {
		countlistOfUniqueSymbols = new ArrayList<Integer>();
	}

	public StringContainer(int sizeOfArray) {
		this();
		myStringArray = new String[sizeOfArray];
	}

	private int getCountOfUniqueSymbols(String elementOfStringArray) {
		int countOfuniqueSymbols = 0;
		boolean isUnique;
		for (int i = 0; i < elementOfStringArray.length(); i++) {
			isUnique = true;
			for (int j = 0; j < elementOfStringArray.length(); j++) {
				if (i != j && elementOfStringArray.charAt(i) == elementOfStringArray.charAt(j)) {
					isUnique = false;
					break;
				}

			}
			if (isUnique) {
				countOfuniqueSymbols++;
			}
		}
		return countOfuniqueSymbols;
	}

	public void fillCountlistOfUniqueSymbols() {
		for (String elementOfArray : myStringArray) {
			this.countlistOfUniqueSymbols.add(this.getCountOfUniqueSymbols(elementOfArray));
		}
	}

	private int getMinimalQuantityOfUniqueSymbols() {
		int minimalCount = this.getCommonLengthOfUniqueSymbols();
		for (int elementOfList : this.countlistOfUniqueSymbols) {
			if (elementOfList > 0) {
				if (elementOfList < minimalCount) {
					minimalCount = elementOfList;
				}
			}
		}
		return minimalCount;
	}

	public int findIndexOfFirstStringWithMinimalCountOfUniqueSymbols() {
		int minimalQuantity = this.getMinimalQuantityOfUniqueSymbols();
		for (int i = 0; i < this.countlistOfUniqueSymbols.size(); i++) {
			if (countlistOfUniqueSymbols.get(i) == minimalQuantity) {
				return i;
			}
		}
		return 0;
	}

	public void printList() {
		for (int temp : countlistOfUniqueSymbols) {
			System.out.println(temp);
		}
	}

	private int getCommonLengthOfUniqueSymbols() {
		int commonLength = 0;
		for (int elementOfList : countlistOfUniqueSymbols) {
			commonLength += elementOfList;
		}
		return commonLength;
	}

	public void setElementOfStringArray(int index, String value) {
		myStringArray[index] = value;
	}

	public int getLengthOfArray() {
		return myStringArray.length;
	}

	public String getElementOfStringArray(int index) {
		return myStringArray[index];
	}

}
