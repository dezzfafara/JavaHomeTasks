package com.booking;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import core.database.DBConnector;
import core.database.TripData;
import core.helpers.PageHelper;
import core.helpers.ParsersRunner;
import core.helpers.WebDriverProvider;
import model.ConnectionParameters;

public class BookingTests {
	private final static String NO_RESULTS_MESSAGE = "NO RESULTS FOUND";
	private WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private CurrentHotelPage currentHotelPage;
	private TripData tripData;
	private DBConnector dbConnector;
	private PageHelper pageHelper;
	private ConnectionParameters connectionParameters;
	private ParsersRunner parsersRunner;

	@BeforeTest
	public void setUp()
			throws SQLException, XMLStreamException, SAXException, IOException, ParserConfigurationException {
		driver = WebDriverProvider.getDriverInstance();
		homePage = new HomePage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		currentHotelPage = new CurrentHotelPage(driver);
		dbConnector = new DBConnector();
		pageHelper = new PageHelper();
		parsersRunner = new ParsersRunner();
		// connectionParameters = parsersRunner.initDOMParser().get(0);
		// connectionParameters = parsersRunner.initSAXParser().get(0);
		connectionParameters = parsersRunner.initStaxParser().get(0);
		System.out.println(connectionParameters.getQuery());
		System.out.println(connectionParameters.getLogin());
		tripData = dbConnector.getTripData(connectionParameters.getUrl(), connectionParameters.getLogin(),
				connectionParameters.getPassword(), connectionParameters.getQuery());
		driver.manage().window().maximize();
	}

	@Parameters({ "startUrl" })
	@BeforeMethod
	public void goToMainPage(String startUrl) {
		driver.get(startUrl);
	}

	@Test
	public void testBookingCase1() {
		homePage.initSearch(driver, tripData.getDestination(), tripData.getDaysFrom(), tripData.getDaysTill(),
				tripData.getRooms(), tripData.getAdults(), tripData.getChildren());
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
	}

	@Parameters({ "scoreToCompareWith" })
	@Test
	public void testBookingCase2(double scoreToCompareWith) {
		homePage.initSearch(driver, tripData.getDestination(), tripData.getDaysFrom(), tripData.getDaysTill(),
				tripData.getRooms(), tripData.getAdults(), tripData.getChildren());
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		searchResultsPage.selectTopViewedHotels();
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		searchResultsPage.selectFirstHotel();
		pageHelper.switchToCurrentTab(driver);
		assertThat(currentHotelPage.getParsedReviewScore(), greaterThanOrEqualTo(scoreToCompareWith));
	}

	@AfterMethod
	public void closeTabs() {
		pageHelper.closeNotUsedTabs(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}