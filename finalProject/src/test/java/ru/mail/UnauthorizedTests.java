package ru.mail;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.DriverManager;
import factory.DriverManagerFactory;
import factory.DriverManagerFactory.DriverType;
import helper.PageHelper;
import ru.mail.pages.MainPage;
import ru.mail.pages.ResultsPage;
import ru.mail.pages.WeatherPage;

public class UnauthorizedTests {
	private final static int STRINGS_EQUALITY_VALUE = 0;
	private final static String MAIN_PAGE_URL = "https://mail.ru";
	private DriverManager driverManager;
	private WebDriver driver;
	private MainPage mainPage;
	private ResultsPage resultsPage;
	private WeatherPage weatherPage;
	private PageHelper pageHelper;
	private final static Logger logger = Logger.getLogger(UnauthorizedTests.class);

	public UnauthorizedTests() {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		pageHelper = new PageHelper(driver);
		mainPage = new MainPage(driver);
		resultsPage = new ResultsPage(driver);
		weatherPage = new WeatherPage(driver);
	}

	@Given("^I am on main application page$")
	public void goToMainPage() {
		driver.manage().window().maximize();
		driver.get(MAIN_PAGE_URL);
	}

	@When("^I input \"([^\"]*)\" in search field and press search button$")
	public void testInitSearch(String searchValue) {
		mainPage.initSearch(searchValue);
		pageHelper.captureScreen(logger);
	}

	@Then("^I see results of search are displayed$")
	public void testIsResultsDisplayed() {
		pageHelper.customLogger(logger, resultsPage.isElementPresent(), "Search is successfull...",
				"Search is unsuccessfull...");
		assertTrue(resultsPage.isElementPresent());
		pageHelper.captureScreen(logger);
	}

	@When("^I click enable feed link$")
	public void testEnableFeed() {
		mainPage.switchFeed();
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that feed is enabled$")
	public void testFeedisEnabled() {
		pageHelper.customLogger(logger, mainPage.isFeedPresent(), "Feed is present...", "Feed is NOT present...");
		assertTrue(mainPage.isFeedPresent());
		pageHelper.captureScreen(logger);
	}

	@Then("^I click disable feed link$")
	public void testDisableFeed() {
		mainPage.switchFeed();
		pageHelper.captureScreen(logger);
	}

	@And("^I see that feed is disabled$")
	public void testFeedIsDisabled() {
		pageHelper.customLogger(logger, !mainPage.isFeedPresent(), "Feed is NOT present...", "Feed is present...");
		assertFalse(mainPage.isFeedPresent());
		pageHelper.captureScreen(logger);
	}

	@When("^I move to weather page$")
	public void testMoveToWeatherPage() {
		mainPage.moveToWeatherPage();
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that weather block is present and current URL is \"([^\"]*)\"$")
	public void testIsWeatherPageOpened(String weatherPageUrl) {
		pageHelper.customLogger(logger, weatherPage.isElementPresent(), "Weather is present...",
				"Weather is NOT present...");
		assertTrue(weatherPage.isElementPresent());
		pageHelper.captureScreen(logger);
		assertThat(weatherPageUrl.compareTo(weatherPage.getCurrentPageUrl(driver)),
				comparesEqualTo(STRINGS_EQUALITY_VALUE));
		pageHelper.captureScreen(logger);
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
