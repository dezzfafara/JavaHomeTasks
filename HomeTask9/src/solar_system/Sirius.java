package solar_system;

public class Sirius extends Star {

	private double orbitalPeriodInYears;
	private double demiAxis;

	public Sirius() {
		super();
		super.increaseCountOfObjects();
	}

	public Sirius(String starName, int age, String spectralClass) {
		super(age, spectralClass);
		super.setStarName(starName);
		super.increaseCountOfObjects();
	}

	public Sirius(String starName, int age, String spectralClass, String constellation) {
		super(age, spectralClass, constellation);
		super.setStarName(starName);
		super.increaseCountOfObjects();
	}

	public String getStarName() {
		return super.getStarName();
	}

	public double getOrbitalPeriodInYears() {
		return orbitalPeriodInYears;
	}

	public void setOrbitalPeriodInYears(double orbitalPeriodInYears) {
		this.orbitalPeriodInYears = orbitalPeriodInYears;
	}

	public double getDemiAxis() {
		return demiAxis;
	}

	public void setDemiAxis(double demiAxis) {
		this.demiAxis = demiAxis;
	}

	public int hashCode() {
		return (int) (31 * orbitalPeriodInYears + 33 * demiAxis
				+ ((null == super.getStarName()) ? 0 : super.getStarName().hashCode()));
	}

	public String toString() {
		return getClass().getName() + "@ " + "Name: " + super.getStarName() + "; Orbital Period In Years: "
				+ orbitalPeriodInYears + "; demiAxis: " + demiAxis + "; Age In Years: " + super.getAgeInYears()
				+ "; Spectral Class: " + super.getSpectralClass() + "; Constellation: " + super.getConstellation();
	}

}
