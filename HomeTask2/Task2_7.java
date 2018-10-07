package task2_7;

import java.util.Scanner;

public class Task2_7 {

	public static void main(String[] args) {
		int x = 0;
		int y = 100;
		int temp;
		int size;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		System.out.println("ORIGINAL ARRAY:");

		int myArray[] = new int[size];
		int i = 0;
		while (i < myArray.length) {
			myArray[i] = x + (int) (Math.random() * (y - x));
			System.out.print("[" + myArray[i] + "]");
			i++;
		}
		System.out.println();

		i = 0;
		for (i = 0; i < (myArray.length / 2); i++) {
			if (myArray[myArray.length - 1 - i] != myArray[i]) {
				temp = myArray[i];
				myArray[i] = myArray[myArray.length - 1 - i];
				myArray[myArray.length - 1 - i] = temp;
			}

		}

		System.out.println("MODIFIED ARRAY:");
		for (int iTemp : myArray) {
			System.out.print("[" + iTemp + "]");
		}

		input.close();

	}

}