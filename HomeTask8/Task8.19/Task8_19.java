package task8_19;

import java.util.Scanner;

public class Task8_19 {
	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalString(input.nextLine());

		textHandler.fillArrayOfWords();

		System.out.println("String with alphabetical words starting with big letter:\n" + textHandler.firstLetterToUpperCase());

		input.close();
	}
}
