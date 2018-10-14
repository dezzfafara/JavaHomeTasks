package task8_4;

import java.util.Scanner;

public class Task8_4 {
	public static void main(String[] args) {

		StringConnector stringConnector = new StringConnector();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter original string:");
		stringConnector.setStringToInsertInto(input.nextLine());

		System.out.println("Enter index of position:");
		int index = Integer.parseInt(input.nextLine());
		System.out.println("Enter string to insert:");
		String stringToInsert = input.nextLine();

		if (stringConnector.positionChecker(index)) {
			stringConnector.insertIntoString(index, stringToInsert);
			System.out.println("Modified string: " + stringConnector.getStringToInsertInto());
		} else {
			System.out.println("Index is more than length of the string");
		}

		input.close();

	}

}
