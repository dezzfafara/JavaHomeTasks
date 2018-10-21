package solar_system;

public class Star extends SolarSystem {

	private static int countOfStars = 0;
	private String starName;
	private long ageInYears;
	private String spectralClass;
	private String constellation;

	public Star() {
		this.starName = "";
		this.constellation = "Has NO constellation";
	}

	protected Star(long ageInYears, String spectralClass) {
		this();
		this.ageInYears = ageInYears;
		this.spectralClass = spectralClass;
	}

	protected Star(long ageInYears, String spectralClass, String constellation) {
		this();
		this.ageInYears = ageInYears;
		this.spectralClass = spectralClass;
		this.constellation = constellation;

	}

	protected void setStarName(String starName) {
		this.starName = starName;
	}

	protected String getStarName() {
		return this.starName;
	}

	protected long getAgeInYears() {
		return ageInYears;
	}

	protected String getSpectralClass() {
		return spectralClass;
	}

	protected String getConstellation() {
		return constellation;
	}

	@Override
	public void printCommonInfo() {
		System.out.println("Common information about STAR:");
		System.out.printf(
				"Age In Years: %,d; Constellation: " + constellation + "; Spectral Class: " + spectralClass + "\n",
				ageInYears);

	}

	public static int getCountOfStars() {
		return countOfStars;
	}

	@Override
	protected void increaseCountOfObjects() {
		countOfStars++;
	}

}
