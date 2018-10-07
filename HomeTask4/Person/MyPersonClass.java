package person;

public class MyPersonClass {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Ivan");
		person.setSurname("Petrov");
		person.setAge(17);
		person.setPhone(375291234567L);
		System.out.println("USING GETTERS");
		System.out.println("Name: " + person.getName() + "; Surname: " + person.getSurname() + "; Age: "
				+ person.getAge() + "; Phone: " + person.getPhone());
		System.out.println("USING printName() and printAllInformation()");
		person.printName();
		person.printAllInformation();
		System.out.println(person.isAdult() ? "PERSON IS ADULT" : "PERSON IS NOT ADULT");

	}

}
