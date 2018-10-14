package task8_8;

import java.util.Scanner;

public class Task8_8 {

	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter original string:");
		textHandler.setStringToClean(input.nextLine());
		System.out.println("Enter start border symbol:");

		String startBorderSymbol = input.nextLine();

		System.out.println("Enter end border symbol:");

		String endBorderSymbol = input.nextLine();
		textHandler.deleteSymbols(startBorderSymbol, endBorderSymbol);

		System.out.println(textHandler.getStringToClean());
		input.close();

	}
}
