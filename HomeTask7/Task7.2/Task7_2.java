package task7_2;

import java.util.Scanner;

public class Task7_2 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));
		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}
		// pass 'true' for ASCENDING SORTING or 'false' for DESCENDING SORTING
		stringContainer.sortStringArray(true);
		System.out.println("\nASCENDING SORTING: ");
		stringContainer.printStringArray();

		stringContainer.sortStringArray(false);

		System.out.println("\nDESCENDING SORTING: ");

		stringContainer.printStringArray();
		input.close();

	}

}
