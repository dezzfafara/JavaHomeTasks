package ru.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	@FindBy(xpath = ".//input[@id='mailbox:login']")
	private WebElement loginField;

	@FindBy(xpath = ".//input[@id='mailbox:password']")
	private WebElement passwordField;

	@FindBy(xpath = ".//select[@id='mailbox:domain']")
	private WebElement domainList;

	@FindBy(xpath = ".//input[@class='o-control']")
	private WebElement submitButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void inboxLogin(String login, String password,  String domain) {
		clearAndInput(loginField, login);
		clearAndInput(passwordField, password);
		new Select(domainList).selectByVisibleText(domain);
		submitButton.click();
	}

	private void clearAndInput(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}