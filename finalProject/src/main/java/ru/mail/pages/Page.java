package ru.mail.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	private final static int WAIT_PERIOD = 10;
	private final static int POLLING = 100;
	private final static int DURATION = 10;
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected FluentWait<WebDriver> fluentWait;

	public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, WAIT_PERIOD);
		fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(POLLING))
				.withTimeout(Duration.ofSeconds(DURATION)).ignoring(NoSuchElementException.class);
	}

	public abstract boolean isElementPresent();

	protected void clearAndFill(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}
