package task2_3;

import java.util.Scanner;

public class Task2_3 {

	public static void main(String[] args) {
		int x = 1;
		int y = 51;
		int step = 3;
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

		System.out.println("\nFirst option");
		i = step - 1;

		for (i = step - 1; i < myArray.length; i++) {
			if ((i + 1) % step == 0) {
				myArray[i] *= 2;
			}
		}

		for (int temp : myArray) {
			System.out.print("[" + temp + "]");
		}

		System.out.println("\nSecond option (values of array from first option are used)");

		i = step - 1;

		for (i = step - 1; i < myArray.length; i += step) {
			{
				myArray[i] *= 2;
			}
		}

		for (int temp : myArray) {
			System.out.print("[" + temp + "]");
		}

		input.close();

	}

}
