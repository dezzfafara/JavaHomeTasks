package universe;

import solar_system.*;

public class MasterOfTheUniverse {
	private static final String MESSAGE_FOR_PERSENTAGE = "; Percentage Of ";
	private static final String MESSAGE_FOR_NAME = "Star Name: ";
	private static final String PERCENT_SYMBOL = " %";
	private static final String MESSAGE_FOR_QUANTITY = "Quantity of ";
	private static final String MESSAGE_FOR_HASH = "\nHash of";
	private static final String MESSAGE_FOR_EARTH = " EARTH";
	private static final String MESSAGE_FOR_MARS = " MARS";
	private static final String MESSAGE_FOR_SUN = " SUN";
	private static final String MESSAGE_FOR_SIRIUS = " SIRIUS";

	public static void main(String[] args) {

		System.out.println("\n=============" + MESSAGE_FOR_EARTH + " METHODS ================\n");

		Earth earth = new Earth("EARTH", -90.3, 58.15, 1, 12576.0, true);
		earth.printSolarSystemInfo();
		earth.printAllPlanetEarthInfo();
		System.out.println("Average temperature on " + earth.getName() + ": " + earth.getAverageTemperature());

		System.out.println("\n=============" + MESSAGE_FOR_MARS + " METHODS ================\n");
		Mars mars = new Mars("MARS", 25.1919, 3396.2, 2, 6779.4, false);
		mars.printSolarSystemInfo();
		mars.printAllPlanetMarsInfo();

		System.out.println("\n=============" + MESSAGE_FOR_SUN + " METHODS ================\n");
		Sun sun = new Sun("SUN", 2300000, "G2V");
		sun.printSolarSystemInfo();
		sun.setPercentageOfHydrogen(73.46);
		sun.setPercentageOfHelium(24.85);
		sun.printCommonInfo();
		System.out.println(MESSAGE_FOR_NAME + sun.getStarName() + MESSAGE_FOR_PERSENTAGE + "Hydrogen: "
				+ sun.getPercentageOfHydrogen() + PERCENT_SYMBOL + MESSAGE_FOR_PERSENTAGE + "Helium: "
				+ sun.getPercentageOfHelium() + PERCENT_SYMBOL);

		System.out.println("\n=============" + MESSAGE_FOR_SIRIUS + " METHODS ================\n");
		Sirius sirius = new Sirius("SIRIUS", 1700000, "A1Vm/DA2", "Canis Major");
		sirius.printCommonInfo();
		sirius.setOrbitalPeriodInYears(50.9);
		sirius.setDemiAxis(7.56);
		System.out.println(MESSAGE_FOR_NAME + sirius.getStarName() + "; Orbital Period In Years: "
				+ sirius.getOrbitalPeriodInYears() + "; Demi Axis: " + sirius.getDemiAxis());

		System.out.println("\n\n" + MESSAGE_FOR_QUANTITY + "Planets: " + Planet.getCountOfPlanets());
		System.out.println(MESSAGE_FOR_QUANTITY + "Stars: " + Star.getCountOfStars());

		System.out.println(MESSAGE_FOR_HASH + MESSAGE_FOR_EARTH + ": " + earth.hashCode());
		System.out.println(earth.toString());

		System.out.println(MESSAGE_FOR_HASH + MESSAGE_FOR_MARS + ": " + mars.hashCode());
		System.out.println(mars.toString());

		System.out.println(MESSAGE_FOR_HASH + MESSAGE_FOR_SUN + ": " + sun.hashCode());
		System.out.println(sun.toString());

		System.out.println(MESSAGE_FOR_HASH + MESSAGE_FOR_SIRIUS + ": " + sirius.hashCode());
		System.out.println(sirius.toString());

	}

}
