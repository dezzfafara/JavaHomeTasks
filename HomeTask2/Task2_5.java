package task2_5;

import java.util.Scanner;

public class Task2_5 {

	public static void main(String[] args) {
		int x = 0;
		int y = 5;
		int count = 0;
		int size;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		int myArray[] = new int[size];
		int i = 0;
		while (i < myArray.length) {
			myArray[i] = x + (int) (Math.random() * (y - x));
			System.out.print("[" + myArray[i] + "]");
			i++;
		}
		System.out.println();

		i = 0;
		for (i = 0; i < myArray.length; i++) {
			if (myArray[i] == 0) {
				System.out.print("Zero index: " + i + "; ");
				count++;
			}
		}

		System.out.println();

		if (count == 0) {
			System.out.println("No zero elements in array");
		}

		input.close();

	}

}
