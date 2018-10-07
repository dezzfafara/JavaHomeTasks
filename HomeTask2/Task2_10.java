package task2_10;

import java.util.Scanner;

public class Task2_10 {

	public static void main(String[] args) {
		int x = 0;
		int y = 100;
		int max;
		int size;
		boolean isAscending = true;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		int myArray[] = new int[size];
		int i = 0;
		while (i < myArray.length) {
			System.out.println("ENTER " + (i + 1) + " ELEMENT OF ARRAY");
			myArray[i] = input.nextInt();
			i++;
		}
		System.out.println();

		for (int temp : myArray) {
			System.out.print("[" + temp + "]");
		}

		i = 0;
		max = myArray[0];

		for (i = 1; i < myArray.length; i++) {
			if (myArray[i] > max) {
				max = myArray[i];
			} else {
				isAscending = false;
				break;
			}

		}
		System.out.println();
		String result = (isAscending) ? "ARRAY IS ASCENDING" : "ARRAY IS NOT ASCENDING";
		System.out.println(result);

		input.close();

	}

}
