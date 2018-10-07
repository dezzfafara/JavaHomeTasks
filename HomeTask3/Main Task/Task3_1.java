package task3_1;

import java.util.Scanner;

public class Task3_1 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a;
		int b;
		System.out.println("Enter first number:");
		a = input.nextInt();
		System.out.println("Enter second number:");
		b = input.nextInt();

		System.out.println("MIN is: " + findMinimal(a, b));
		input.close();

	}

	private static int findMinimal(int a, int b) {
		if (a < b)
			return a;
		return b;
	}

}
