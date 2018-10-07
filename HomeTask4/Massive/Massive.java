package massive;

public class Massive {

	private int[] myIntArray;

	public Massive() {

	}

	public Massive(int size, int startOfInterval, int endOfInterval) {
		myIntArray = new int[size];

		for (int i = 0; i < myIntArray.length; i++) {
			myIntArray[i] = (int) (startOfInterval + (Math.random() * (endOfInterval - startOfInterval)));
		}
	}

	public int[] getMyIntArray() {
		return myIntArray;
	}

	public void printMassiveAsLine(int[] tempArray) {
		for (int temp : tempArray) {
			System.out.print("[" + temp + "]");
		}
		System.out.println();
	}

	public void printReverseMassiveAsLine(int[] tempArray) {
		for (int i = tempArray.length - 1; i >= 0; i--) {
			System.out.print("[" + tempArray[i] + "]");
		}
		System.out.println();
	}

	public long getSumOfElements(int[] tempArray) {
		long summ = 0;
		for (int temp : tempArray) {
			summ += temp;
		}
		return summ;
	}

	public int[] multiptyBy3(int[] tempArray) {
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] *= 3;
		}
		return tempArray;
	}

}
