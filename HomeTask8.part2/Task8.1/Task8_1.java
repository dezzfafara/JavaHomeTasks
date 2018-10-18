package task8_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Task8_1 {

	private static final String MESSAGE_FOR_EXPIRIENCE_IN = "Expirience In";

	private static final String NAME_OF_PRIVATE_CLASS = "private task8_1.Tester()";

	private static int indexOfPrivateConstructor = 0;

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			ClassNotFoundException, NoSuchMethodException, SecurityException {
		Tester firstTester = new Tester("Ivan", "Ivanov");
		Tester secondTester = new Tester("Petr", "Petrov", "Advanced", 3.5);
		Tester thirdTester = new Tester("Fedor", "Fedorov", "Elementary", 1.8, 1100.33);

		firstTester.setName("Igor");
		System.out.println("Name: " + firstTester.getName());

		firstTester.setSurname("Potapov");
		System.out.println("Surname: " + firstTester.getSurname());

		firstTester.setEnglishLevel("Intermidiate");
		System.out.println("English Level: " + firstTester.getEnglishLevel());

		firstTester.setExpirienceInYears(1.5);
		System.out.println(MESSAGE_FOR_EXPIRIENCE_IN + " Years: " + firstTester.getExpirienceInYears());

		firstTester.setSalary(950.66);
		System.out.println("Salary: " + firstTester.getSalary());

		// Error. Method is public -> is visible only in class Tester.
		// System.out.println("Double salary: " + secondTester.getDoubleSalary());

		System.out.println(MESSAGE_FOR_EXPIRIENCE_IN + " Months: " + secondTester.getExpirienceInMonths());

		thirdTester.printNameAndSurname();

		thirdTester.printAllInfo();

		// privateTester1 object is initialized with reference to the object
		Tester privateTester1 = Tester.getObjectByPrivateConstructor();

		// and we can use methods of class tester
		privateTester1.setName("Private1");
		System.out.println(privateTester1.getName());

		// If we declare new instance, it is initialized with the same reference
		Tester privateTester2 = Tester.getObjectByPrivateConstructor();
		privateTester2.setName("Private2");

		// and even if we execute method for first instance of Tester class, we get the
		// result with changes from second instance. That's the main idea of Singleton
		// approach.
		System.out.println(privateTester1.getName()); // Output: "Private2"

		// Creation of object of class "Class", that gives us an ability to use methods
		// of class "Class", forName() gets the class by it's name
		Class<?> reflectedClass = Class.forName(Tester.class.getName());

		// creation of array of constructors of class "Tester",
		// getDeclaredConstructors() method receives all, even protected and private
		// constructors
		Constructor<?>[] constructors = reflectedClass.getDeclaredConstructors();

		// for information I print names of all constructors, it's still a question how
		// they are ordered
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i].toString());

			if (constructors[i].toString().equals(NAME_OF_PRIVATE_CLASS)) {
				indexOfPrivateConstructor = i;
			}
		}

		// setAccessible(true) "opens" constructor for using out of class
		constructors[indexOfPrivateConstructor].setAccessible(true);

		// newInstance() method creates an object using selected constructor
		Tester reflectedTester = (Tester) constructors[indexOfPrivateConstructor].newInstance();

		// after we can restrict using of constructor again
		constructors[indexOfPrivateConstructor].setAccessible(false);

		reflectedTester.setName("Reflected Name");

		System.out.println(reflectedTester.getName());

	}
}
