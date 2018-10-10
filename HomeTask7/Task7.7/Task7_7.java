package task7_7;

import java.util.Scanner;

public class Task7_7 {
	public static void main(String[] args) {

		final String message = "with all elements different";

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));
		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}
		stringContainer.handleStringsWithUniqueSymbols();

		System.out.println("Quantity of strings " + message + " : " + stringContainer.getSizeOfList());

		System.out.print((stringContainer.getSizeOfList() > 0)
				? ("First string " + message + " : " + stringContainer.getElementFromList(0))
				: "No strings " + message);
		input.close();

	}

}