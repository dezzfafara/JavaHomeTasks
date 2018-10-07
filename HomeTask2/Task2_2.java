package task2_2;

import java.util.Scanner;

public class Task2_2 {

	public static void main(String[] args) {
		int x = 1;
		int y = 51;
		long mult = 1;
		int size;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		int myArray[] = new int[size];
		int i = 0;
		while (i < myArray.length) {
			myArray[i] = x + (int) (Math.random() * (y - x));
			System.out.print("[" + myArray[i] + "]");
			mult *= myArray[i];
			i++;
		}

		System.out.println();
		System.out.println("Multiplication = " + mult);

		input.close();

	}

}
