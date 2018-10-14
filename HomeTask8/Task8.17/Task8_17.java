package task8_17;

import java.util.Scanner;

public class Task8_17 {

	public static void main(String[] args) {
		TextHandler textHandler = new TextHandler();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		textHandler.setOriginalString(input.nextLine());

		textHandler.fillArrayOfSubstrings();

		System.out.println("First longest substring without letters: \"" + textHandler.getTheLongestSubstring() + "\"");

		input.close();
	}
}
