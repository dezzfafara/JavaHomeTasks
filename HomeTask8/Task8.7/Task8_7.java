package task8_7;

import java.util.Scanner;

public class Task8_7 {

	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setStringToClean(input.nextLine());

		textHandler.modifyString();

		System.out.println(textHandler.getStringToClean());
		input.close();

	}
}
