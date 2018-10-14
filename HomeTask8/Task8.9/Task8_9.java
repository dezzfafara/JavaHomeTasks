package task8_9;

import java.util.Scanner;

public class Task8_9 {
	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalText(input.nextLine());

		textHandler.fillArrayOfWords();

		textHandler.fillCounterOfWords();

		textHandler.printCounterOfWords();

		input.close();

	}
}