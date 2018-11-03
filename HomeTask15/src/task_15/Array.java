package task_15;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Array {
	private int[] array;

	public int[] initArray(int size) {
		array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		return array;
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
}
