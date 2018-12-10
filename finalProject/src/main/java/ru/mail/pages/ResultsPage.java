package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class ResultsPage extends Page {
	@FindBy(xpath = ".//div[@id='icard']")
	private WebElement resultBlock;

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isElementPresent() {
		return wait.until(ExpectedConditions.visibilityOf(resultBlock)).isDisplayed();
	}

}
