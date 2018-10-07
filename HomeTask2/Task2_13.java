package task2_13;

import java.util.Scanner;

public class Task2_13 {

	public static void main(String[] args) {
		int x = 1;
		int y = 100;
		int size1;
		int size2;
		int max;
		int min;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter quantity of lines:");
		size1 = input.nextInt();

		System.out.println("Enter quantity of columns:");
		size2 = input.nextInt();

		System.out.println("ORIGINAL ARRAY:");

		int myArray[][] = new int[size1][size2];
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[i].length; j++) {
				myArray[i][j] = x + (int) (Math.random() * y);
				System.out.print("[" + myArray[i][j] + "]");
			}
			System.out.println();
		}

		max = min = myArray[0][0];
		System.out.println("\nREVERSED ARRAY:");
		for (int i = myArray.length - 1; i >= 0; i--) {
			for (int j = myArray[i].length - 1; j >= 0; j--) {
				System.out.print("[" + myArray[i][j] + "]");
				if (myArray[i][j] < min) {
					min = myArray[i][j];
				}

				if (myArray[i][j] > max) {
					max = myArray[i][j];
				}
			}
			System.out.println();

		}
		System.out.println("\nMIN = " + min + "; MAX = " + max);

		input.close();

	}

}
