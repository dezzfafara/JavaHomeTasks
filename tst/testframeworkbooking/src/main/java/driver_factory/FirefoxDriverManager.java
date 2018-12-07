package driver_factory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDriverManager extends DriverManager {
	@Override
	public void createDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en-us");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		options.addArguments("test-type");
		driver = new FirefoxDriver(options);
	}
}
