package task_17;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookingTests {
	private static final int QUANTITY_OF_ROOMS = 2;
	private static final int QUANTITY_OF_ADULTS = 3;
	private static final int QUANTITY_OF_CHILDREN = 1;
	private WebDriver driver;

	@DataProvider(name = "testBookingData")
	private static Object[][] testBookingDataProvider() {
		return new Object[][] { { "Moscow", getDate(10) }, { "London", getDate(15) }, { "Paris", getDate(20) } };
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openSite() {
		driver.get("https://booking.com/");
	}

	@Test(dataProvider = "testBookingData")
	public void testBooking(String destination, String stringDate) {
		WebElement searchField = getWebElement(".//input[@id='ss']", driver);
		searchField.clear();
		searchField.sendKeys(destination);
		WebElement calendar = getWebElement(".//button[@aria-label='Open calendar']", driver);
		calendar.click();
		WebElement date = getWebElement(".//td[@data-date='" + getDate() + "']", driver);
		date.click();
		date = getWebElement(".//td[@data-date='" + stringDate + "']", driver);
		date.click();
		WebElement guests = getWebElement(".//label[@id='xp__guests__toggle']", driver);
		guests.click();
		List<WebElement> plusButtons = driver
				.findElements(By.xpath(".//button[@class='bui-button bui-button--secondary bui-stepper__add-button']"));
		if (!plusButtons.isEmpty()) {
			for (WebElement button : plusButtons) {
				button.click();
			}
		} else {
			WebElement select = getWebElement(".//select[@id='no_rooms']", driver);
			select.click();
			WebElement option = getWebElement(
					".//select[@id='no_rooms']//option[@value='" + String.valueOf(QUANTITY_OF_ROOMS) + "']", driver);
			option.click();
			select = getWebElement(".//select[@name='group_adults']", driver);
			select.click();
			option = getWebElement(
					".//select[@name='group_adults']//option[@value='" + String.valueOf(QUANTITY_OF_ADULTS) + "']",
					driver);
			option.click();
			select = getWebElement(".//select[@name='group_children']", driver);
			select.click();
			option = getWebElement(
					".//select[@name='group_children']//option[@value='" + String.valueOf(QUANTITY_OF_CHILDREN) + "']",
					driver);
			option.click();
		}

		WebElement button = getWebElement(".//span[text()='Search']", driver);
		button.click();
		List<WebElement> searchResults = driver.findElements(By.xpath(
				".//div[contains(@class,'sr_item sr_item_new sr_item_default sr_property_block  sr_flex_layout')]"));
		System.out.println(searchResults.size());
		assertFalse(searchResults.isEmpty(), "NO RESULTS FOUND!");
		WebElement sort;
		try {
			sort = getWebElement(".//button[@id='sortbar_dropdown_button']", driver);
			sort.click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("ELEMENT NOT FOUND!");
		}
		sort = getWebElement(".//a[@data-category='bayesian_review_score']", driver);
		sort.click();
		sleep(7);
		WebElement firstLink = getWebElement("(.//a[@class='hotel_name_link url'])[1]", driver);
		firstLink.click();
		ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabList.get(tabList.size() - 1));
		WebElement rate = getWebElement(
				".//div[@class='bui-review-score c-score bui-review-score--end']//div[@class='bui-review-score__badge']",
				driver);
		String sRate = rate.getText();
		sRate.trim();
		double fRate = Double.parseDouble(sRate);
		System.out.println(fRate);
		assertTrue(fRate >= 9.0, "HOTEL'S RAITING IS LOWER THAN 9!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	private static WebElement getWebElement(String xpath, WebDriver driver) {
		return driver.findElement(By.xpath(xpath));
	}

	private static String getDate(int increment) {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).plusDays(increment).toString();
	}

	private static String getDate() {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).toString();
	}

	private static void sleep(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
