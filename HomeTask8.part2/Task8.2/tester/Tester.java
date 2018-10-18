package tester;

public class Tester {

	private static final int SALARY_MULTIPLIER = 2;
	private static final int MONTHS_IN_YEAR = 12;
	private static final String STRING_FOR_NAME = "Name: ";
	private static final String STRING_FOR_SURNAME = "; Surname; ";

	public String name;
	public String surname;
	protected double expirienceInYears;
	String englishLevel;
	private double salary;

	Tester() {

	}

	protected Tester(String name, String surname) {
		this.name = name;
		this.surname = surname;

	}

	Tester(String name, String surname, String englishLevel, double expirienceInYears) {
		this(name, surname);
		this.englishLevel = englishLevel;
		this.expirienceInYears = expirienceInYears;

	}

	public Tester(String name, String surname, String englishLevel, double expirienceInYears, double salary) {
		this(name, surname, englishLevel, expirienceInYears);
		this.salary = salary;

	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	double getExpirienceInYears() {
		return expirienceInYears;
	}

	void setExpirienceInYears(double expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	private double getDoubleSalary() {
		return salary * SALARY_MULTIPLIER;
	}

	double getExpirienceInMonths() {
		return expirienceInYears * MONTHS_IN_YEAR;
	}

	protected void printNameAndSurname() {
		System.out.println(STRING_FOR_NAME + name + STRING_FOR_SURNAME + surname);
	}

	public void printAllInfo() {
		System.out.println(STRING_FOR_NAME + name + STRING_FOR_SURNAME + surname + "; Experience in Years: "
				+ expirienceInYears + "; English Level: " + englishLevel + "; Salary: " + salary);
	}

}