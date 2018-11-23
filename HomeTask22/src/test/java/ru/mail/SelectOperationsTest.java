package ru.mail;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectOperationsTest {

	private final static String MAIN_URL = "https://mail.ru";
	private WebDriver driver;
	private HomePage homePage;
	private InboxPage inboxPage;

	public SelectOperationsTest() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		inboxPage = new InboxPage(driver);
	}

	@Given("^I Am On Main page$")
	public void goToMainPage() {
		driver.manage().window().maximize();
		driver.get(MAIN_URL);
	}

	@When("^I Login With Valid login \"([^\"]*)\" and password \"([^\"]*)\" and select correct domain \"([^\"]*)\"$")
	public void login(String login, String passsword, String domain) {
		homePage.inboxLogin(login, passsword, domain);
	}

	@Then("^I See Logout Link$")
	public void isLoginSuccessfull() {
		assertTrue(inboxPage.logoutLinkIsDisplayed());
	}

	@Then("^I select \"([^\"]*)\" letters$")
	public void testSelectDeselectLetters(int quantityOfLetters) {
		inboxPage.selectLetters(driver, quantityOfLetters);
		assertTrue(inboxPage.isSelectionCorrect(driver, quantityOfLetters), "SELECTION IS INCORRECT...");
		inboxPage.deselectAll();
	}

	@And("^I CLose Browser$")
	public void tearDown() {
		driver.quit();
	}

}
