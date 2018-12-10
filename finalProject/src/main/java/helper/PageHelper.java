package helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class PageHelper {

	private final static String SCREENSHOTS_PATH = "./target/screenshots/";
	private WebDriver augmentedDriver;

	public PageHelper(WebDriver driver) {
		this.augmentedDriver = new Augmenter().augment(driver);
	}

	public void captureScreen(Logger logger) {
		try {
			File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(SCREENSHOTS_PATH + source.getName()));
		} catch (IOException e) {
			logger.error("Screenshot is not captured... " + e);
		}
	}

	public void customLogger(Logger logger, boolean condition, String infoMessage, String errorMessage) {
		if (condition) {
			logger.info(infoMessage);
		} else {
			logger.error(errorMessage);
		}
	}
}
