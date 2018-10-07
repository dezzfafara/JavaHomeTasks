package task2_8;

import java.util.Scanner;

public class Task2_8 {

	public static void main(String[] args) {
		int x = 0;
		int y = 100;
		int max;
		int min;
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
		max = min = myArray[0];
		for (i = 1; i < myArray.length; i++) {
			if (myArray[i] < min) {
				min = myArray[i];
			}

			if (myArray[i] > max) {
				max = myArray[i];
			}
		}

		System.out.println("MIN: " + min);
		System.out.println("MAX: " + max);

		input.close();

	}

}
