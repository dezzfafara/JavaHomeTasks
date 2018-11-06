package task_16;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Array {
	private int[] array;

	public int[] initArray(int[] array) {
		this.array = array;
		return this.array;
	}

	public int[] clearArray() {
		array = null;
		return array;
	}

	public int[] getArray() {
		return this.array;
	}

	public int getElementByIndex(int index) {
		return array[index];
	}

	public int getArrayLength() {
		return array.length;
	}

	public boolean doesContainElement(int valueToVerify) {
		return IntStream.of(array).anyMatch(element -> element == valueToVerify);
	}

	public String arrayToString() {
		return Arrays.toString(Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new));
	}

	public int[] shellSortArray() {
		int tempElement;
		int i;
		int j;
		int step;
		for (step = array.length / 2; step > 0; step /= 2) {
			for (i = step; i < array.length; i++) {
				tempElement = array[i];
				for (j = i; j >= step; j -= step) {
					if (tempElement < array[j - step]) {
						array[j] = array[j - step];
					} else {
						break;
					}
				}
				array[j] = tempElement;
			}
		}
		return array;
	}

	public boolean isAscending(int[] arrayToVerify) {
		boolean isAscending = true;
		for (int i = 0; i < arrayToVerify.length - 1; i++) {
			if (arrayToVerify[i] >= arrayToVerify[i + 1]) {
				isAscending = false;
				break;
			}
		}
		return isAscending;
	}

	public int[] reverseArray(int[] arrayToReverse) {
		int tempElement;
		for (int i = 0; i < arrayToReverse.length / 2; i++) {
			tempElement = arrayToReverse[i];
			arrayToReverse[i] = arrayToReverse[arrayToReverse.length - 1 - i];
			arrayToReverse[arrayToReverse.length - 1 - i] = tempElement;
		}
		return arrayToReverse;
	}

	public Integer[] intArrayToIntegerArray(int[] arrayToConvert) {
		return Arrays.stream(arrayToConvert).boxed().toArray(Integer[]::new);
	}
}
