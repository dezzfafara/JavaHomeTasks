package task7_6;

import java.util.Scanner;

public class Task7_6 {
	public static void main(String[] args) {

		final String message = "string with ascending symbols ";

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));
		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}

		stringContainer.fillListOfAscendingWords();

		System.out.println(
				(stringContainer.getListSize() >= 2) ? "Second " + message + ":" + stringContainer.getElementOfList(1)
						: ((stringContainer.getListSize() == 1
								? "The only " + message + ":" + stringContainer.getElementOfList(0)
								: "No " + message)));

		input.close();

	}

}