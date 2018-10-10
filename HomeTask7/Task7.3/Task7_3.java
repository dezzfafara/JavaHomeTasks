package task7_3;

import java.util.Scanner;

public class Task7_3 {
	public static void main(String[] args) {

		final String message = "String(s) with length %s than average: \n";

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));
		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}
		stringContainer.countAverageLengthOfStrings();

		System.out.println("Average length of string: " + stringContainer.getAverageLengthOfString());

		System.out.printf(message, "more");
		stringContainer.printStrings(true);
		System.out.printf(message, "less");
		stringContainer.printStrings(false);
		input.close();

	}

}
