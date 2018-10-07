package task2_9;

import java.util.Scanner;

public class Task2_9 {

	public static void main(String[] args) {
		int x = 0;
		int y = 100;
		int max;
		int min;
		int maxIndex;
		int minIndex;
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
		maxIndex = minIndex = i;
		for (i = 1; i < myArray.length; i++) {
			if (myArray[i] < min) {
				min = myArray[i];
				minIndex = i;
			}

			if (myArray[i] > max) {
				maxIndex = i;
				max = myArray[i];
			}
		}

		System.out.println("INDEX OF MIN: " + minIndex);
		System.out.println("INDEX OF MAX: " + maxIndex);

		input.close();

	}

}
