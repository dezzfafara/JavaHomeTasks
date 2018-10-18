package package_main;

import tester.*;

public class Task8_2 {

	private static final String MESSAGE_FOR_EXPIRIENCE_IN = "Expirience In";

	public static void main(String[] args) {
		// Error. Constructor is protected -> visible only in package 'tester' and for child classes of class 'Tester' in 'tester' and other packages.
		// Tester firstTester = new Tester("Ivan", "Ivanov");
		
		// Error. Constructor is 'friendly' -> visible only in package 'tester'.
		// Tester secondTester = new Tester("Petr", "Petrov", "Advanced", 3.5);
		
		
		Tester thirdTester = new Tester("Fedor", "Fedorov", "Elementary", 1.8, 1100.33);

		// Error. Setters and getters are 'friendly' - are visible only in package 'tester'.
		
		/*thirdTester.setName("Igor");
		System.out.println("Name: " + firstTester.getName());

		thirdTester.setSurname("Potapov");
		System.out.println("Surname: " + firstTester.getSurname());

		thirdTester.setEnglishLevel("Intermidiate");
		System.out.println("English Level: " + firstTester.getEnglishLevel());

		thirdTester.setExpirienceInYears(1.5);
		System.out.println(MESSAGE_FOR_EXPIRIENCE_IN + " Years: " + firstTester.getExpirienceInYears());

		thirdTester.setSalary(950.66);
		System.out.println("Salary: " + firstTester.getSalary()); */

		// Error. Method is public -> is visible only in class Tester.
		// System.out.println("Double salary: " + secondTester.getDoubleSalary());

		// Error. Method is 'friendly' -> is visible only in package 'tester'.
		// System.out.println(MESSAGE_FOR_EXPIRIENCE_IN + " Months: " + thirdTester.getExpirienceInMonths());

		// Error. Method is protected -> visible only in package 'tester' and for child classes of class 'Tester' in 'tester' and other packages.
		// thirdTester.printNameAndSurname();

		thirdTester.printAllInfo();

	}
}