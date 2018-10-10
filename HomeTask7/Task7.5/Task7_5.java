package task7_5;

import java.util.Scanner;

public class Task7_5 {
	public static void main(String[] args) {

		final String message = "Quantity of ";

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));
		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}

		stringContainer.fillListOfLatins();
		stringContainer.fillListOfVowelsEqualConsonants();

		System.out.println(message + "Latin words: " + stringContainer.getSizeOfLatinsList());
		stringContainer.printList(stringContainer.getListOfLatins());

		System.out.println(message + "words with equal ammount of vowels and consonants: "
				+ stringContainer.getSizeOfVowelsEqualConsonantsList());

		stringContainer.printList(stringContainer.getListOfVowelsEqualConsonants());

		input.close();

	}

}