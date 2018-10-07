package task2_1;

import java.util.Scanner;

public class Task2_1 {

	public static void main(String[] args) {
		int[] myIntArray = createArray();
		printArray(myIntArray, true);
		printArray(myIntArray, false);

	}

	private static int[] createArray() {
		int size;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array:");
		size = input.nextInt();
		int myArray[] = new int[size];
		int i = 0;

		while (i < myArray.length) {
			System.out.println("Enter " + (i + 1) + " element of array:");
			myArray[i] = input.nextInt();
			i++;
		}
		input.close();
		return myArray;
	}

	private static void printArray(int[] tempArray, boolean isReverse) {
		System.out.println();
		if (isReverse) {
			for (int i = tempArray.length - 1; i >= 0; i--) {
				System.out.print("[" + tempArray[i] + "]");
			}
		} else {
			for (int temp : tempArray) {
				System.out.print("[" + temp + "]");
			}
		}

	}

}
