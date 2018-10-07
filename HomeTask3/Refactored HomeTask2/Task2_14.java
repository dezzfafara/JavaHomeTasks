package task2_14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Task2_14 {
	public static void main(String[] args) {

		ArrayList<Integer> myArrayList = createArrayList(10, 1, 99);
		System.out.println("ORIGINAL ARRAYLIST:");
		printArrayList(myArrayList);
		ArrayList<Integer> myArrayList2 = addToElement(myArrayList, 5);
		System.out.println("ARRAYLIST + some value:");
		printArrayList(myArrayList2);
		ArrayList<Integer> myArrayList3 = deleteElements(myArrayList2);
		System.out.println("Size of ArrayList with deleted elements: " + getSize(myArrayList3));
		ArrayList<Integer> myArrayList4 = clearArrayList(myArrayList2);
		System.out.println("Size of cleaned ArrayList: " + getSize(myArrayList4));

	}

	private static ArrayList<Integer> createArrayList(int size, int x, int y) {
		int i = 0;
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		while (i < size) {
			tempArrayList.add(x + (int) (Math.random() * (y - x)));
			i++;

		}
		return tempArrayList;
	}

	private static void printArrayList(ArrayList<Integer> tempArrayList) {
		for (int temp : tempArrayList) {
			System.out.print("<" + temp + ">");
		}
		System.out.println();
	}

	private static ArrayList<Integer> addToElement(ArrayList<Integer> tempArrayList, int value) {
		for (ListIterator<Integer> iter = tempArrayList.listIterator(); iter.hasNext();) {
			Integer iTemp = iter.next();
			iter.set(iTemp + value);

		}
		return tempArrayList;
	}

	private static int getSize(ArrayList<Integer> tempArrayList) {
		return tempArrayList.size();
	}

	private static ArrayList<Integer> deleteElements(ArrayList<Integer> tempArrayList) {
		for (Iterator<Integer> iter = tempArrayList.iterator(); iter.hasNext();) {
			iter.next();
			iter.remove();
		}
		return tempArrayList;
	}

	private static ArrayList<Integer> clearArrayList(ArrayList<Integer> tempArrayList) {
		tempArrayList.clear();
		return tempArrayList;
	}

}
