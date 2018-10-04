package tester;

public class TesterMainClass {
	static final int SIZE = 4;

	public static void main(String[] args) {

		Tester[] arrayOfTesters = new Tester[SIZE];

		arrayOfTesters[0] = new Tester();
		arrayOfTesters[1] = new Tester("Ivan", "Popov");
		arrayOfTesters[2] = new Tester("Stepan", "Petrov", "Advanced", 5);
		arrayOfTesters[3] = new Tester("Petr", "Fedorov", "Elementary", 3, 567.24);

		printArrayOfTesters(arrayOfTesters);

		// Invocation of static method
		System.out.println("Quantity of objects of class \"Tester\": " + Tester.getCount());

		System.out.println(arrayOfTesters[3].getSalary());
		System.out.println(arrayOfTesters[3].getSalary(0.8));
		System.out.println(arrayOfTesters[3].getSalary(0.8, 1.1));
		System.out.println(arrayOfTesters[3].getSalary(0.8, 1.1, 1.05));

	}

	private static void printArrayOfTesters(Tester[] tempArrayOfTesters) {
		for (Tester tempElementOfTesterArray : tempArrayOfTesters) {
			tempElementOfTesterArray.printAllInfo();
		}
	}

}
