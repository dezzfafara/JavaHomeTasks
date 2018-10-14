package task8_21;

import java.util.Scanner;

public class Task8_21 {
	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalString(input.nextLine());

		System.out.println("Summ of all digit symbols: " + textHandler.getSummOfDidgits());

		input.close();
	}
}
