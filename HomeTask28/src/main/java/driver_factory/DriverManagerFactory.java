package driver_factory;

public class DriverManagerFactory {
	public enum DriverType {
		CHROME, FIREFOX;
	}

	public static DriverManager getManager(DriverType type) {

		switch (type) {
		case CHROME:
			return new ChromeDriverManager();
		case FIREFOX:
			return new FirefoxDriverManager();
		default:
			return new ChromeDriverManager();
		}
	}
}
