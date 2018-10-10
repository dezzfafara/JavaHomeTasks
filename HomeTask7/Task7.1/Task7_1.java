package task7_1;

import java.util.Scanner;

public class Task7_1 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));

		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}
		stringContainer.handleStrings();
		System.out.println("Shortest String: \"" + stringContainer.getShortestString() + "\"; length:  "
				+ stringContainer.getShortestStringLength());
		System.out.println("Longest String: \"" + stringContainer.getLongestString() + "\"; length:  "
				+ stringContainer.getLongestStringLength());
		input.close();

	}

}
