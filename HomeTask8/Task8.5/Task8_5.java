package task8_5;

import java.util.Scanner;

public class Task8_5 {

	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalString(input.nextLine());
		textHandler.fillArrayOfWords();
		System.out.println("Enter substring to verify:");
		String substringToVerify = input.nextLine();
		System.out.println("Enter substring to add:");
		String substringToAdd = input.nextLine();

		System.out.println("Modified string: " + textHandler.getResultString(substringToVerify, substringToAdd));

		input.close();

	}

}
