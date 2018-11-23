package ru.mail;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MoveFromSpamTest {

	private final static String MAIN_URL = "https://mail.ru";
	private WebDriver driver;
	private HomePage homePage;
	private InboxPage inboxPage;
	private SpamPage spamPage;

	public MoveFromSpamTest() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		inboxPage = new InboxPage(driver);
		spamPage = new SpamPage(driver);
	}

	@Given("^I Am on main page$")
	public void goToMainPage() {
		driver.manage().window().maximize();
		driver.get(MAIN_URL);
	}

	@When("^I Login with valid login \"([^\"]*)\" and password \"([^\"]*)\" and select correct domain \"([^\"]*)\"$")
	public void login(String login, String passsword, String domain) {
		homePage.inboxLogin(login, passsword, domain);
	}

	@Then("^I See logout link$")
	public void isLoginSuccessfull() {
		assertTrue(inboxPage.logoutLinkIsDisplayed());
	}

	@Then("^I Move \"([^\"]*)\" email from spam$")
	public void moveFromSpam(int index) {
		inboxPage.switchToSpam();
		assertFalse(spamPage.hasSpamLetters(driver), "NO SPAM...");
		spamPage.moveToInboxByIndex(driver, index);
		spamPage.switchToInbox(driver);
		assertTrue(inboxPage.doesContainSubject(spamPage.getSubjectText()), "NO SUCH LETTER...");
	}

	@And("^I Close browser$")
	public void tearDown() {
		driver.quit();
	}

}
