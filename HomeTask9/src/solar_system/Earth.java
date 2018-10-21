package solar_system;

public class Earth extends Planet {

	private final static int QUANTITY_OF_PARAMETRS = 2;
	private static final String MESSAGE_FOR_MIN_TEMPERATURE = "; Minimal Temperature Of Surface: ";
	private static final String MESSAGE_FOR_MAX_TEMPERATURE = "; Maximal Temperature Of Surface: ";
	private static final String MESSAGE_FOR_NAME = "Name: ";

	private double minTemperatureOfSurface;
	private double maxTemperatureOfSurface;

	public Earth(String name, double minTemperatureOfSurface, double maxTemperatureOfSurface) {
		super.increaseCountOfObjects();
		super.setPlanetName(name);
		this.minTemperatureOfSurface = minTemperatureOfSurface;
		this.maxTemperatureOfSurface = maxTemperatureOfSurface;

	}

	public Earth(String name, double minTemperatureOfSurface, double maxTemperatureOfSurface, int numberOfSatellites,
			double diameterInKilometers, boolean hasOxygen) {
		super(numberOfSatellites, diameterInKilometers, hasOxygen);
		super.increaseCountOfObjects();
		super.setPlanetName(name);
		this.minTemperatureOfSurface = minTemperatureOfSurface;
		this.maxTemperatureOfSurface = maxTemperatureOfSurface;

	}

	public String getName() {
		return super.getPlanetName();
	}

	@Override
	protected void printSpecificPlanetInfo() {
		System.out.println("Specific information about Planet EARTH:\n" + MESSAGE_FOR_NAME + super.getPlanetName()
				+ MESSAGE_FOR_MIN_TEMPERATURE + minTemperatureOfSurface + MESSAGE_FOR_MAX_TEMPERATURE
				+ maxTemperatureOfSurface);
	}

	public void printAllPlanetEarthInfo() {
		super.printCommonInfo();
		printSpecificPlanetInfo();

	}

	public double getAverageTemperature() {
		return Math.round((minTemperatureOfSurface + maxTemperatureOfSurface) / QUANTITY_OF_PARAMETRS * 100.0) / 100.0;
	}

	public int hashCode() {
		return (int) (31 * minTemperatureOfSurface + 33 * maxTemperatureOfSurface
				+ ((null == super.getPlanetName()) ? 0 : super.getPlanetName().hashCode()));
	}

	public String toString() {
		return getClass().getName() + "@ " + MESSAGE_FOR_NAME + super.getPlanetName() + MESSAGE_FOR_MIN_TEMPERATURE
				+ minTemperatureOfSurface + MESSAGE_FOR_MAX_TEMPERATURE + maxTemperatureOfSurface
				+ "; Number of Satellites: " + super.getNumberOfSatellites() + "; Diameter In Kilometers: "
				+ super.getDiameterInKilometers() + "; Has Oxygen: " + super.isHasOxygen();
	}

}
