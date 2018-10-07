package task2_4;

import java.util.Scanner;

public class Task2_4 {

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
			if (myArray[i] == 0) {
				count++;
			}
			i++;
		}

		System.out.println();

		String result = (count > 0) ? ("Quantity of zero elements: " + count) : "No zero elements in array";
		System.out.println(result);

		input.close();

	}

}
