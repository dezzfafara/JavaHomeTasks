package task_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Massive {
	private static final int ASSURED_ARRAY_SIZE = 10;
	private static final String STANDARD_SIZE_MESSAGE = " ARRAY WILL BE INITIALIZED WITH STANDARD SIZE = ";
	private static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "INPUTED INDEX IS OUT OF BOUNDS!";
	private static final String CATCH_BLOCK_MESSAGE = "CATCH BLOCK...";
	private static final String FILE_PATH = "source.txt";
	private static final int START_OF_RANGE = 1;
	private static final int END_OF_RANGE = 1000;
	private int[] intArray;

	public void printArray() {
		IntStream.of(intArray).forEach(element -> System.out.print("[" + element + "] "));
		System.out.println();
	}

	private void fillArray() {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = START_OF_RANGE + (int) (Math.random() * (END_OF_RANGE - START_OF_RANGE));
		}
	}

	public void initArray() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array:");
		try {
			intArray = new int[Integer.parseInt(input.nextLine())];
		} catch (NegativeArraySizeException e) {
			System.out.println("ARRAY SIZE CAN'T BE NEGATIVE!" + STANDARD_SIZE_MESSAGE + ASSURED_ARRAY_SIZE);
		} catch (NumberFormatException e) {
			System.out.println("NOT AN INTEGER VALUE WAS INPUTED!" + STANDARD_SIZE_MESSAGE + ASSURED_ARRAY_SIZE);
		} finally {
			if (intArray == null) {
				intArray = new int[ASSURED_ARRAY_SIZE];
			}
			fillArray();
			System.out.println("CLOSING INPUT STREAM...");
			input.close();
		}
	}

	public void printElementByIndex(int index) {
		try {
			System.out.println("Element with index " + index + ": " + intArray[index]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(INDEX_OUT_OF_BOUNDS_MESSAGE);
		} finally {
			System.out.println("SERVICE INFORMATION: SIZE OF ARRAY: " + intArray.length);
		}
	}

	public void setElementByIndex(int index, int element) {
		try {
			intArray[index] = element;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(INDEX_OUT_OF_BOUNDS_MESSAGE);
		}
	}

	public void divideElementOfArray(int index, int divider) {
		try {
			intArray[index] /= divider;
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR! " + e);
		}
	}

	// Set FILE_PATH = "source1.txt" for NumberFormatException
	// Set FILE_PATH = "source2.txt" for ArrayIndexOutOfBoundsException
	// Set FILE_PATH = "source3.txt" for IOException
	public void fillArrayFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			int i = 0;
			try {
				while ((line = reader.readLine()) != null) {
					intArray[i] = Integer.parseInt(line);
					i++;
				}
			} catch (NumberFormatException e) {
				System.out.println("WRONG LINE FORMAT !!!" + e);
			}
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR !!! " + e);
		}
	}

	public void skipFinallyBlockMethod(int index, int divider) {
		boolean skipFinally = false;
		int[] tempArray = { 10 };
		try {
			System.out.println("TRY BLOCK...");
			tempArray[index] /= divider;
			skipFinally = true;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(CATCH_BLOCK_MESSAGE);
			while (true) {
			}
		} catch (ArithmeticException e) {
			System.out.println(CATCH_BLOCK_MESSAGE);
			System.exit(1);
		} finally {
			if (!skipFinally) {
				System.out.println("FINALLY BLOCK...");
			}
		}
	}
}
