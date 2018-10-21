package solar_system;

public abstract class SolarSystem {

	private static final String SOLAR_SYSTEM_MESSAGE = "Solar System ";

	private final int frequencyRate;
	private final String solarSystemName;

	public SolarSystem() {
		this.solarSystemName = "Alpha Centauri";
		this.frequencyRate = 3;
	}

	public void printSolarSystemInfo() {
		System.out.println(SOLAR_SYSTEM_MESSAGE + "INFO:\n" + SOLAR_SYSTEM_MESSAGE + "Name: " + solarSystemName
				+ "; Frequency Rate: " + frequencyRate);
	}

	protected abstract void printCommonInfo();

	protected abstract void increaseCountOfObjects();

}
