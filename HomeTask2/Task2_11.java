package task2_11;

import java.util.Scanner;

public class Task2_11 {

	public static void main(String[] args) {
		int x = 1;
		int y = 10;
		int size;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		System.out.println("ORIGINAL ARRAY:");

		double myArray[] = new double[size];
		int i = 0;
		while (i < myArray.length) {
			myArray[i] = x + Math.round((Math.random() * (y - x)));
			System.out.print("[" + myArray[i] + "]");
			i++;
		}
		System.out.println();

		i = 0;

		for (i = 1; i < myArray.length; i++) {
			if (i < myArray.length - 1) {
				myArray[i] = (myArray[i - 1] + myArray[i + 1]) / 2;
				System.out.println("After one step:");
				for (double temp : myArray) {
					System.out.print("[" + temp + "]");
				}
				System.out.println();
			}
		}

		input.close();

	}

}
