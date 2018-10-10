package task7_4;

import java.util.Scanner;

public class Task7_4 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter length of String array:");
		StringContainer stringContainer = new StringContainer(Integer.parseInt(input.nextLine()));
		for (int i = 0; i < stringContainer.getLengthOfArray(); i++) {
			System.out.println("Enter element of String array:");
			stringContainer.setElementOfStringArray(i, input.nextLine());
		}

		stringContainer.fillCountlistOfUniqueSymbols();

		System.out
				.println(
						"First string with minimal quantity of unique symbols: \""
								+ stringContainer.getElementOfStringArray(
										stringContainer.findIndexOfFirstStringWithMinimalCountOfUniqueSymbols())
								+ "\"");

		input.close();
	}

}