package ru.mail;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposeLetterTest {

	private final static String MAIN_URL = "https://mail.ru";
	private WebDriver driver;
	private HomePage homePage;
	private InboxPage inboxPage;
	private ComposeLetterPage composeLetterPage;

	public ComposeLetterTest() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		inboxPage = new InboxPage(driver);
		composeLetterPage = new ComposeLetterPage(driver);
	}

	@Given("^I Am On main page$")
	public void goToMainPage() {
		driver.manage().window().maximize();
		driver.get(MAIN_URL);
	}

	@When("^I Login With valid login \"([^\"]*)\" and password \"([^\"]*)\" and select correct domain \"([^\"]*)\"$")
	public void login(String login, String passsword, String domain) {
		homePage.inboxLogin(login, passsword, domain);
	}

	@Then("^I See Logout link$")
	public void isLoginSuccessfull() {
		assertTrue(inboxPage.logoutLinkIsDisplayed());
	}

	@Then("^I Compose letter with parameters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void composeLetter(String subject, String messageText, String recepient1, String recepient2,
			String recepient3) {
		composeLetterPage.clickComposeButton(driver);
		assertTrue(composeLetterPage.sendGroupLetter(driver, subject, messageText, recepient1, recepient2, recepient3),
				"EMAIL WAS NOT SENT...");
	}

	@And("^I Close Browser$")
	public void tearDown() {
		driver.quit();
	}

}
