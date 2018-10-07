package task3_4;

import java.util.Scanner;

public class Task3_4 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double a;
		System.out.println("Enter number:");
		a = input.nextDouble();
		System.out.println("a^3 = " + cube(a));
		input.close();

	}

	private static double cube(double a) {
		return Math.pow(a, 3);
	}

}
