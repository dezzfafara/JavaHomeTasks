package massive;

public class MyMassiveMain {
	public static void main(String[] args) {

		Massive massive = new Massive(3, 1, 10);
		int[] myArray = massive.getMyIntArray();

		massive.printMassiveAsLine(myArray);
		massive.printReverseMassiveAsLine(myArray);
		System.out.println("SUMM OF ELEMENTS: " + massive.getSumOfElements(myArray));

		int[] myArray2 = massive.multiptyBy3(myArray);
		massive.printMassiveAsLine(myArray2);
		massive.printReverseMassiveAsLine(myArray2);

	}
}
