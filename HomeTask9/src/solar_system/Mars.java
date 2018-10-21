package solar_system;

public class Mars extends Planet {

	private static final String MESSAGE_FOR_NAME = "Name: ";
	private final static String MESSAGE_FOR_TILT = "; Axial Tilt In Degrees: ";
	private final static String MESSAGE_FOR_RADIUS = "; Polar Radius In Kilometers: ";

	private double axialTiltInDegrees;
	private double polarRadiusInKilometers;

	public Mars(String name, double axialTiltInDegrees, double polarRadiusInKilometers) {
		super.setPlanetName(name);
		super.increaseCountOfObjects();
		this.axialTiltInDegrees = axialTiltInDegrees;
		this.polarRadiusInKilometers = polarRadiusInKilometers;

	}

	public Mars(String name, double axialTiltInDegrees, double polarRadiusInKilometers, int numberOfSatellites,
			double diameterInKilometers, boolean hasOxygen) {
		super(numberOfSatellites, diameterInKilometers, hasOxygen);
		super.increaseCountOfObjects();
		super.setPlanetName(name);
		this.axialTiltInDegrees = axialTiltInDegrees;
		this.polarRadiusInKilometers = polarRadiusInKilometers;

	}

	@Override
	protected void printSpecificPlanetInfo() {
		System.out.println("Specific information about Planet MARS:\n" + MESSAGE_FOR_NAME + super.getPlanetName()
				+ MESSAGE_FOR_TILT + axialTiltInDegrees + MESSAGE_FOR_RADIUS + polarRadiusInKilometers);
	}

	public void printAllPlanetMarsInfo() {
		super.printCommonInfo();
		printSpecificPlanetInfo();
	}

	public int hashCode() {
		return (int) (31 * axialTiltInDegrees + 33 * polarRadiusInKilometers
				+ ((null == super.getPlanetName()) ? 0 : super.getPlanetName().hashCode()));
	}

	public String toString() {
		return getClass().getName() + "@ " + MESSAGE_FOR_NAME + super.getPlanetName() + MESSAGE_FOR_TILT
				+ axialTiltInDegrees + MESSAGE_FOR_RADIUS + polarRadiusInKilometers + "; Number of Satellites: "
				+ super.getNumberOfSatellites() + "; Diameter In Kilometers: " + super.getDiameterInKilometers()
				+ "; Has Oxygen: " + super.isHasOxygen();
	}
}
