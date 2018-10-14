package task8_20;

import java.util.Scanner;

public class Task8_20 {
	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalString(input.nextLine());

		System.out.println("Quantity of pucntuation marks: " + textHandler.getpunctuationQuantity());

		input.close();
	}
}
