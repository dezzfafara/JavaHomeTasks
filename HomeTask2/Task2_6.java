package task2_6;

import java.util.Scanner;

public class Task2_6 {

	public static void main(String[] args) {
		int x = 0;
		int y = 31;
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
		for (i = 0; i < myArray.length; i += 2) {
			if ((i + 1) < myArray.length) {
				temp = myArray[i];
				myArray[i] = myArray[i + 1];
				myArray[i + 1] = temp;

			}
		}

		System.out.println("MODIFIED ARRAY:");
		for (int iTemp : myArray) {
			System.out.print("[" + iTemp + "]");
		}

		input.close();

	}

}
