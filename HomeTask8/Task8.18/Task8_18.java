package task8_18;

import java.util.Scanner;

public class Task8_18 {
	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalText(input.nextLine());

		textHandler.fillArrayOfWords();

		textHandler.fillCounterOfConsonants();

		textHandler.printCounterOfConsonants();

		input.close();
	}

}
