package task_14;

public class Task14 {
	public static void main(String[] args) {
		Massive massive = new Massive(); // Set array size = 3 to verify all exceptions
		massive.initArray();
		massive.printArray();
		massive.setElementByIndex(3, 369);
		massive.setElementByIndex(2, 998);
		massive.printArray();
		massive.printElementByIndex(3);
		massive.printElementByIndex(2);
		massive.divideElementOfArray(3, 2);
		massive.divideElementOfArray(2, 0);
		massive.divideElementOfArray(2, 2);
		massive.printArray();
		massive.fillArrayFromFile();
		massive.printArray();
		// skipFinallyBlockMethod(index, divider):
		// (!0, 0||!0) - endless loop
		// (0, 0) - System.exit(1)
		// (0, !0) - boolean flag in finally block
		massive.skipFinallyBlockMethod(0, 1);
		System.out.println("AFTER FINALLY BLOCK IS EXECUTED...");
	}
}