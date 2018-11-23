package ru.mail;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MoveToSpamTest {

	private final static String MAIN_URL = "https://mail.ru";
	private WebDriver driver;
	private HomePage homePage;
	private InboxPage inboxPage;
	private SpamPage spamPage;

	public MoveToSpamTest() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		inboxPage = new InboxPage(driver);
		spamPage = new SpamPage(driver);
	}

	@Given("^I am on main page$")
	public void goToMainPage() {
		driver.manage().window().maximize();
		driver.get(MAIN_URL);
	}

	@When("^I login with valid login \"([^\"]*)\" and password \"([^\"]*)\" and select correct domain \"([^\"]*)\"$")
	public void login(String login, String passsword, String domain) {
		homePage.inboxLogin(login, passsword, domain);
	}

	@Then("^I see logout link$")
	public void isLoginSuccessfull() {
		assertTrue(inboxPage.logoutLinkIsDisplayed());
	}

	@Then("^I move \"([^\"]*)\" email to spam$")
	public void moveToSpam(int index) {
		inboxPage.moveLetterToSpamByIndex(driver, index);
		inboxPage.switchToSpam();
		assertTrue(spamPage.doesContainSubject(driver, inboxPage.getSubjectText()),
				"NO SUCH SUBJECT FOUND IN SPAM FOLDER...");
	}

	@And("^I close browser$")
	public void tearDown() {
		driver.quit();
	}
}
