package task3_3;

import java.util.Scanner;

public class Task3_3 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		long a;
		System.out.println("Enter number:");
		a = input.nextLong();
		System.out.println("a^2 = " + square(a));
		input.close();

	}

	private static long square(long a) {
		return a * a;
	}

}
