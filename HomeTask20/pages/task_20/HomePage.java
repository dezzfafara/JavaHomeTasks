package task_20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private final static String DOMAIN = "@inbox.ru";

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

	public void inboxLogin(String login, String password) {
		loginField.clear();
		loginField.sendKeys(login);
		passwordField.clear();
		passwordField.sendKeys(password);
		new Select(domainList).selectByVisibleText(DOMAIN);
		submitButton.click();
	}
}
