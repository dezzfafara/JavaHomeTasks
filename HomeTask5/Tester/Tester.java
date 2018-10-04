package tester;

public class Tester {

	private static int countForObjects = 0;

	private String name;
	private String surname;
	private int expirienceInYears;
	private String englishLevel;
	private double salary;

	public Tester() {
		countForObjects++;
	}

	public Tester(String name, String surname) {
		this();
		this.name = name;
		this.surname = surname;

	}

	public Tester(String name, String surname, String englishLevel, int expirienceInYears) {
		this(name, surname);
		this.englishLevel = englishLevel;
		this.expirienceInYears = expirienceInYears;

	}

	public Tester(String name, String surname, String englishLevel, int expirienceInYears, double salary) {
		this(name, surname, englishLevel, expirienceInYears);
		this.salary = salary;

	}

	public void printAllInfo() {
		System.out.println("Name: " + this.name + "; Surname: " + this.surname + "; Experience in Years: "
				+ this.expirienceInYears + "; English Level: " + this.englishLevel + "; Salary: " + this.salary);
	}

// Get Salary
	public double getSalary() {
		System.out.println("Salary:");
		return this.salary;
	}

// Get 'clean' salary
	public double getSalary(double taxRate) {
		System.out.println("'Clean' salary:");
		return this.salary * taxRate;
	}

// Get 'clean' salary + bonus for experience
	public double getSalary(double taxRate, double bonusForExperience) {
		System.out.println("'Clean' salary + bonus for experience:");
		return this.salary * taxRate * Math.pow(bonusForExperience, this.expirienceInYears);
	}

	// Get 'clean' salary + bonus for experience + bonus for English level
	public double getSalary(double taxRate, double bonusForExperience, double bonusForEnglish) {
		System.out.println("'Clean' salary + bonus for experience + bonus for English level:");
		int englishBonusMultiplier = 1;
		switch (this.englishLevel) {
		case "Elementary":
			englishBonusMultiplier = 2;
			break;
		case "Intermediate":
			englishBonusMultiplier = 3;
			break;
		case "Advanced":
			englishBonusMultiplier = 4;
			break;
		default:
			englishBonusMultiplier = 1;
		}
		return this.salary * taxRate * Math.pow(bonusForExperience, this.expirienceInYears)
				* Math.pow(bonusForEnglish, englishBonusMultiplier);
	}

	// Static method for counter of objects
	public static int getCount() {
		return countForObjects;
	}

}
