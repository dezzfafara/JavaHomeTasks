package com.booking;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import core.builder.TripData;
import core.database.DBConnector;
import core.helpers.PageHelper;
import core.helpers.ParsersRunner;
import driver_factory.DriverManager;
import driver_factory.DriverManagerFactory;
import driver_factory.DriverManagerFactory.DriverType;
import model.ConnectionParameters;

public class BookingTests {
	private final static String NO_RESULTS_MESSAGE = "NO RESULTS FOUND";
	private WebDriver driver;
	private DriverManager driverManager;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private CurrentHotelPage currentHotelPage;
	private TripData tripData;
	private DBConnector dbConnector;
	private PageHelper pageHelper;
	private ConnectionParameters connectionParameters;
	private ParsersRunner parsersRunner;
	private final static Logger log = Logger.getLogger(BookingTests.class);

	@BeforeTest
	public void setUp()
			throws SQLException, XMLStreamException, SAXException, IOException, ParserConfigurationException {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		homePage = new HomePage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		currentHotelPage = new CurrentHotelPage(driver);
		dbConnector = new DBConnector();
		pageHelper = new PageHelper();
		parsersRunner = new ParsersRunner();
		connectionParameters = parsersRunner.initDOMParser().get(0);
		// connectionParameters = parsersRunner.initSAXParser().get(0);
		// connectionParameters = parsersRunner.initStaxParser().get(0);
		tripData = dbConnector.getTripData(connectionParameters.getUrl(), connectionParameters.getLogin(),
				connectionParameters.getPassword(), connectionParameters.getQuery());
		driver.manage().window().maximize();

	}

	@Parameters({ "startUrl" })
	@BeforeMethod
	public void goToMainPage(String startUrl) {

		driver.get(startUrl);
	}

	@Test(enabled = true)
	public void testBookingCase1() {
		homePage.initSearch(driver, tripData.getDestination(), tripData.getDaysFrom(), tripData.getDaysTill(),
				tripData.getRooms(), tripData.getAdults(), tripData.getChildren());
		log.info("Trip parameters for Test Case №1 inputed...");
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		log.error(NO_RESULTS_MESSAGE);
		log.info("Test Case №1 passed...");
	}

	@Parameters({ "scoreToCompareWith" })
	@Test(enabled = true)
	public void testBookingCase2(double scoreToCompareWith) {
		homePage.initSearch(driver, tripData.getDestination(), tripData.getDaysFrom(), tripData.getDaysTill(),
				tripData.getRooms(), tripData.getAdults(), tripData.getChildren());
		log.info("Trip parameters for Test Case №2 inputed...");
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		searchResultsPage.selectTopViewedHotels();
		log.info("Top viewed hotel selected...");
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		searchResultsPage.selectFirstHotel();
		log.info("First hotel selected...");
		pageHelper.switchToCurrentTab(driver);
		assertThat(currentHotelPage.getParsedReviewScore(driver), greaterThanOrEqualTo(scoreToCompareWith));
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