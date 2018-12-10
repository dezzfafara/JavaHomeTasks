package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class WeatherPage extends Page {
	@FindBy(xpath = ".//div[@class='information block js-city_one']")
	private WebElement weatherBlock;

	public WeatherPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isElementPresent() {
		return wait.until(ExpectedConditions.visibilityOf(weatherBlock)).isDisplayed();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

}
