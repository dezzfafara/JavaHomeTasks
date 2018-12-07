package core.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {
	private static WebDriver driver;

	private WebDriverProvider() {
	}

	public static WebDriver getDriverInstance() {
		if (null == driver) {
			driver = new ChromeDriver();
		}
		return driver;
	}
}
