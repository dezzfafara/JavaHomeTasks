package task3_2;

import java.util.Scanner;

public class Task3_2 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a;
		System.out.println("Enter number:");
		a = input.nextInt();
		String result = (isEven(a)) ? "Number is EVEN" : "Number is ODD";
		System.out.println(result);
		input.close();

	}

	private static boolean isEven(int a) {
		if (a % 2 == 0)
			return true;
		return false;
	}

}
