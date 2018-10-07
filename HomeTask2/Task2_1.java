package task2_1;

import java.util.Scanner;

public class Task2_1 {

	public static void main(String[] args) {
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

		i = 0;

		while (i < myArray.length) {
			System.out.print("[" + myArray[i] + "]");
			i++;
		}
		System.out.println();
		i = myArray.length - 1;

		while (i >= 0) {
			System.out.print("[" + myArray[i] + "]");
			i--;
		}

		input.close();

	}

}
