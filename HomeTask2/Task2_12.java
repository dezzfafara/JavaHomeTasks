package task2_12;

import java.util.Scanner;

public class Task2_12 {

	public static void main(String[] args) {
		int x = 1;
		int y = 100;
		int size;
		int step = 2;
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
		int temp;
		for (i = 0; i < step; i++) {
			temp = myArray[myArray.length - 1];
			for (int j = myArray.length - 1; j > 0; j--) {
				myArray[j] = myArray[j - 1];
			}
			myArray[0] = temp;
		}
		System.out.println("MODIFIED ARRAY:");
		for (int tempElement : myArray) {
			System.out.print("[" + tempElement + "]");
		}
		input.close();

	}

}
