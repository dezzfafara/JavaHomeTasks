package com.booking;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookingTests {
	private final static String NO_RESULTS_MESSAGE = "NO RESULTS FOUND";
	private WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private CurrentHotelPage currentHotelPage;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		currentHotelPage = new CurrentHotelPage(driver);
		driver.manage().window().maximize();
	}

	@Parameters({ "startUrl" })
	@BeforeMethod
	public void goToMainPage(String startUrl) {
		driver.get(startUrl);
	}

	@Parameters({ "destination", "daysFrom", "daysTill", "roomsQuantity", "adultsQuantity", "childrenQuantity" })
	@Test
	public void testBookingCase1(String destination, int daysTill, int daysFrom, int roomsQuantity, int adultsQuantity,
			int childrenQuantity) {
		homePage.initSearch(driver, destination, daysTill, daysFrom, roomsQuantity, adultsQuantity, childrenQuantity);
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
	}

	@Parameters({ "destination", "daysFrom", "daysTill", "roomsQuantity", "adultsQuantity", "childrenQuantity",
			"scoreToCompareWith" })
	@Test
	public void testBookingCase2(String destination, int daysTill, int daysFrom, int roomsQuantity, int adultsQuantity,
			int childrenQuantity, double scoreToCompareWith) {
		homePage.initSearch(driver, destination, daysTill, daysFrom, roomsQuantity, adultsQuantity, childrenQuantity);
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		searchResultsPage.selectTopViewedHotels();
		assertFalse(searchResultsPage.hasSearchResults(), NO_RESULTS_MESSAGE);
		searchResultsPage.selectFirstHotel();
		currentHotelPage.switchToCurrentTab(driver);
		assertThat(currentHotelPage.getParsedReviewScore(), greaterThanOrEqualTo(scoreToCompareWith));
	}

	@AfterMethod
	public void closeTabs() {
		closeNotUsedTabs();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	private void closeNotUsedTabs() {
		String currentTab = driver.getWindowHandle();
		driver.getWindowHandles().stream().filter(t -> !currentTab.equals(t)).forEach(t -> {
			driver.switchTo().window(t);
			driver.close();
		});
		driver.switchTo().window(currentTab);
	}
}