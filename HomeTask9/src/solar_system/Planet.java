package solar_system;

public class Planet extends SolarSystem {

	private static int countOfPlanets = 0;
	private String planetName;
	private double diameterInKilometers;
	private int numberOfSatellites;
	private boolean hasOxygen;

	public Planet() {
		this.planetName = "";
		this.hasOxygen = false;
	}

	protected Planet(int numberOfSatellites, double diameterInKilometers) {
		this();
		this.numberOfSatellites = numberOfSatellites;
		this.diameterInKilometers = diameterInKilometers;
	}

	protected Planet(int numberOfSatellites, double diameterInKilometers, boolean hasOxygen) {
		this(numberOfSatellites, diameterInKilometers);
		if (this.hasOxygen != hasOxygen) {
			this.hasOxygen = hasOxygen;
		}
	}

	protected double getDiameterInKilometers() {
		return diameterInKilometers;
	}

	protected int getNumberOfSatellites() {
		return numberOfSatellites;
	}

	protected boolean isHasOxygen() {
		return hasOxygen;
	}

	protected void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	protected String getPlanetName() {
		return planetName;
	}

	@Override
	protected void printCommonInfo() {
		System.out.println("Common Information about PLANET:");
		System.out.println("Diameter In Kilometers: " + diameterInKilometers + "; Number Of Satellites: "
				+ numberOfSatellites + "; Has Oxygen: " + hasOxygen + ".");
	}

	protected void printSpecificPlanetInfo() {
		System.out.println("PLANET SHOULD BE SPECIFIED !!!");
	}

	public static int getCountOfPlanets() {
		return countOfPlanets;
	}

	@Override
	protected void increaseCountOfObjects() {
		countOfPlanets++;
	}

}
