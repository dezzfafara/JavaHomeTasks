package task3_5;

public class Task3_5 {
	public static void main(String[] args) {
		printSumm(1, 5, 8);
		printDiff(3, 8);
		System.out.println("Method getSumm(): " + getSumm(2, 1, 7));
		System.out.println("Method getDiff(): " + getDiff(8, 20));

		int[] myIntArray = { -8, 33, -44, 123, 88, 0, -6 };
		printArray(myIntArray);
		printArrayLength(myIntArray);
		double[] myDoubleArray = { -0.333, 25.66, 38.38, -2.247, 0.0, 25.587 };
		System.out.println("Summ of elements of Double Array: " + getDoubleArraySumm(myDoubleArray));
		float[] myFloatArray = { -2.356f, 0.58f, 245.66f, -58.3f, 666.66f, 0.3587f, 58.5f, 256.147f, -0.45f, 1.47f };
		System.out.println("ORIGINAL FLOAT ARRAY:");
		printFloatArray(myFloatArray);
		float[] modifiedFloatArray = replaceThirdElement(myFloatArray);
		System.out.println("MODIFIED FLOAT ARRAY:");
		printFloatArray(modifiedFloatArray);
	}

	private static int getDiff(int a, int b) {
		return a - b;
	}

	private static long getSumm(int a, int b, int c) {
		return a + b + c;
	}

	private static void printSumm(int a, int b, int c) {
		System.out.println("SUMM = " + (a + b + c));
	}

	private static void printDiff(int a, int b) {
		System.out.println("DIFF = " + (a - b));
	}

	private static void printArray(int[] tempArray) {
		for (int temp : tempArray) {
			System.out.print("[" + temp + "]");
		}
		System.out.print("\n");

	}

	private static void printArrayLength(int[] tempArray) {
		System.out.print("Array's length: " + tempArray.length + "\n");

	}

	private static double getDoubleArraySumm(double[] tempDoubleArray) {
		double summ = 0.0;
		for (int i = 0; i < tempDoubleArray.length; i++) {
			summ += tempDoubleArray[i];
		}
		return summ;
	}

	private static float[] replaceThirdElement(float[] tempFloatArray) {
		for (int i = 2; i < tempFloatArray.length; i++) {
			if ((i + 1) % 3 == 0) {
				tempFloatArray[i] = -1;
			}
		}
		return tempFloatArray;
	}

	private static void printFloatArray(float[] tempFloatArray) {
		for (float temp : tempFloatArray) {
			System.out.print("[" + temp + "]");
		}
		System.out.println();
	}

}
