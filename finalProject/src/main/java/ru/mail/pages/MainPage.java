package ru.mail.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public final class MainPage extends Page {
	@FindBy(xpath = ".//a[@id='PH_regLink']")
	protected WebElement registerLink;

	@FindBy(xpath = ".//input[@id='mailbox:login']")
	private WebElement loginField;

	@FindBy(xpath = ".//input[@id='mailbox:password']")
	private WebElement passwordField;

	@FindBy(xpath = ".//select[@id='mailbox:domain']")
	private WebElement domainSelect;

	@FindBy(xpath = ".//input[@class='o-control' and @type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = ".//div[@id='mailbox:error']")
	private WebElement errorMessage;

	@FindBy(xpath = ".//input[@id='q']")
	private WebElement searchField;

	@FindBy(xpath = ".//input[@id='search:submit']")
	private WebElement searchButton;

	@FindBy(xpath = ".//a[@id='footer:feed-switch']")
	private WebElement feedSwitcher;

	@FindBy(xpath = ".//section[contains(@class, 'feed')]")
	private List<WebElement> feedContainer;

	@FindBy(xpath = ".//p[@class='i-font-md i-link-deco']")
	private WebElement weatherLink;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void login(String login, String password, String domain) {
		clearAndFill(loginField, login);
		clearAndFill(passwordField, password);
		new Select(domainSelect).selectByVisibleText(domain);
		submitButton.click();
	}

	public boolean isElementPresent() {
		return wait.until(ExpectedConditions.visibilityOf(registerLink)).isDisplayed();
	}

	public boolean isErrorPresent() {
		return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
	}

	public void initSearch(String searchValue) {
		clearAndFill(searchField, searchValue);
		searchButton.click();
	}

	public void switchFeed() {
		wait.until(ExpectedConditions.visibilityOf(feedSwitcher)).click();
	}

	public boolean isFeedPresent() {
		return !feedContainer.isEmpty();
	}

	public void moveToWeatherPage() {
		weatherLink.click();
	}
}
