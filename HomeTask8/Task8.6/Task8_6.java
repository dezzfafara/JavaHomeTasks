package task8_6;

import java.util.Scanner;

public class Task8_6 {

	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();
		textHandler.setSymbolForCompare("x");

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalString(input.nextLine());
		System.out.println("Enter symbol to search:");
		textHandler.setSymbolForCompare(input.nextLine());
		textHandler.fillArrayOfWords();
		System.out.println("Enter position to insert after:");
		System.out.println("Modified string: " + textHandler.wordsHandler(Integer.parseInt(input.nextLine())));

		input.close();

	}

}
