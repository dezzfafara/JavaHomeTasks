package person;

public class Person {
	private String name;
	private String surname;
	private int age;
	private long phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void printAllInformation() {
		System.out.println(
				"Name: " + this.name + "; Surname: " + this.surname + "; Age: " + this.age + "; Phone: " + this.phone);
	}

	public void printName() {
		System.out.println("Name: " + this.name + "; Surname: " + this.surname);
	}

	public boolean isAdult() {
		if (this.age >= 18) {
			return true;
		} else {
			return false;
		}
	}

}
