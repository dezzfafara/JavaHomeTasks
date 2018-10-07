package task2_14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Task2_14 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of ArrayList:");
		int size = input.nextInt();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		int i = 0;
		while (i < size) {
			myList.add(0 + (int) (Math.random() * 47));
			i++;

		}

		for (int temp : myList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		for (ListIterator<Integer> iter = myList.listIterator(); iter.hasNext();) {
			Integer iTemp = iter.next();
			iter.set(iTemp + 5);

		}
		System.out.println("Elements of Arraylist + 5");

		for (int temp : myList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		for (Iterator<Integer> iter = myList.iterator(); iter.hasNext();) {
			iter.next();
			iter.remove();
		}
		if (myList.size() == 0) {
			System.out.println("Size of ArrayList: " + myList.size());
		}

		System.out.println();
		i = 0;
		while (i < size) {
			myList.add(0 + (int) (Math.random() * 47));
			i++;

		}

		System.out.println("NEW Elements of Arraylist:");
		for (int temp : myList) {
			System.out.print(temp + " ");
		}
		System.out.println();
		myList.clear();

		if (myList.size() == 0) {
			System.out.println("Size of ArrayList: " + myList.size());
		}

		input.close();
	}

}
