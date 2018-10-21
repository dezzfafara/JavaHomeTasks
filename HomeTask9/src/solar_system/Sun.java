package solar_system;

public class Sun extends Star {

	private static final String MESSAGE_FOR_PERCENTAGE = "; Percentage Of ";

	private double percentageOfHydrogen;
	private double percentageOfHelium;

	public Sun() {
		super();
		super.increaseCountOfObjects();
	}

	public Sun(String starName, long ageInYears, String spectralClass) {
		super(ageInYears, spectralClass);
		super.setStarName(starName);
		super.increaseCountOfObjects();
	}

	public Sun(String starName, long ageInYears, String spectralClass, String constellation) {
		super(ageInYears, spectralClass, constellation);
		super.setStarName(starName);
		super.increaseCountOfObjects();
	}

	public String getStarName() {
		return super.getStarName();
	}

	public double getPercentageOfHydrogen() {
		return percentageOfHydrogen;
	}

	public void setPercentageOfHydrogen(double percentageOfHydrogen) {
		this.percentageOfHydrogen = percentageOfHydrogen;
	}

	public double getPercentageOfHelium() {
		return percentageOfHelium;
	}

	public void setPercentageOfHelium(double percentageOfHelium) {
		this.percentageOfHelium = percentageOfHelium;
	}

	public int hashCode() {
		return (int) (31 * percentageOfHydrogen + 33 * percentageOfHelium
				+ ((null == super.getStarName()) ? 0 : super.getStarName().hashCode()));
	}

	public String toString() {
		return getClass().getName() + "@ " + "Name: " + super.getStarName() + MESSAGE_FOR_PERCENTAGE + "Hydrogen: "
				+ percentageOfHydrogen + MESSAGE_FOR_PERCENTAGE + "Helium: " + percentageOfHelium + "; Age In Years: "
				+ super.getAgeInYears() + "; Spectral Class: " + super.getSpectralClass() + "; Constellation: "
				+ super.getConstellation();
	}

}
