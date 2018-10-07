package task2_2;

import java.util.Scanner;

public class Task2_2 {

	public static void main(String[] args) {

		int[] myIntArray = createArray(1, 99);
		printArray(myIntArray);
		System.out.println("Multiplication = " + getMultiply(myIntArray));

	}

	private static int[] createArray(int x, int y) {
		int size;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		int myArray[] = new int[size];
		int i = 0;
		while (i < myArray.length) {
			myArray[i] = x + (int) (Math.random() * (y - x));
			i++;
		}
		input.close();
		return myArray;
	}

	private static void printArray(int[] tempArray) {
		System.out.println("ARRAY:");
		for (int temp : tempArray) {
			System.out.print("[" + temp + "]");
		}
		System.out.println();
	}

	private static long getMultiply(int[] tempArray) {
		long mult = 1;
		for (int temp : tempArray) {
			mult *= temp;
		}
		return mult;
	}

}
