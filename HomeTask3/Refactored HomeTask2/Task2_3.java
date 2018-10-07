package task2_3;

import java.util.Scanner;

public class Task2_3 {

	public static void main(String[] args) {

		int[] myIntArray = createArray(1, 99);
		System.out.println("ORIGINAL ARRAY");
		printArray(myIntArray);
		int[] myModifiedIntArray = multiplyThirdElement(myIntArray);
		printArray(myModifiedIntArray);

	}

	private static int[] createArray(int x, int y) {
		int size;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter size of array:");
		size = input.nextInt();

		int myArray[] = new int[size];
		int i = 0;
		while (i < myArray.length) {
			myArray[i] = x + (int) (Math.random() * (y - x));
			i++;
		}
//		input.close();
		return myArray;
	}

	private static void printArray(int[] tempArray) {
		for (int temp : tempArray) {
			System.out.print("[" + temp + "]");
		}
		System.out.println();
	}

	private static int[] multiplyThirdElement(int[] tempArray) {
		int step = 3;
		int choise;
		int i;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter option (1 or 2):");
			choise = input.nextInt();

			switch (choise) {
			case 1:
				i = step - 1;
				for (i = step - 1; i < tempArray.length; i++) {
					if ((i + 1) % step == 0) {
						tempArray[i] *= 2;
					}
				}
				break;
			case 2:
				i = step - 1;
				for (i = step - 1; i < tempArray.length; i += step) {
					tempArray[i] *= 2;
				}
				break;
			default:
				System.out.println("WRONG CHOISE");
				break;
			}
			if (choise == 1 || choise == 2)
				break;
		} while (true);
		input.close();
		return tempArray;
	}

}
