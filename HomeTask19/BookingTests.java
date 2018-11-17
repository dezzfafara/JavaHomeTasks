package task_19;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.testng.Assert.assertFalse;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookingTests {
	private final static String NO_RESULTS_MESSAGE = "NO RESULTS FOUND!";
	private WebDriver driver;
	private WebDriverWait wait;

	@DataProvider(name = "searchValues")
	private Object[][] searchValuesDataProvider() {
		return new Object[][] {
				{ "Moscow", new Integer(3), new Integer(10), new Integer(1), new Integer(2), new Integer(0) },
				{ "Paris", new Integer(3), new Integer(10), new Integer(2), new Integer(4), new Integer(2) } };
	}

	@DataProvider(name = "reserveValues")
	private Object[][] searchReserveDataProvider() {
		return new Object[][] {
				{ "Moscow", new Integer(3), new Integer(10), new Integer(1), new Integer(2), new Integer(0),
						"4242424242424243" },
				{ "Paris", new Integer(3), new Integer(10), new Integer(2), new Integer(4), new Integer(2),
						"4242424242424242" } };
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openSite() {
		driver.get("https://booking.com/");
	}

	@Test(dataProvider = "searchValues", priority = 1)
	public void testBooking1(String destination, int dateFrom, int dateTill, int quantityOfRooms, int quantityOfAdults,
			int quantityOfChildren) {
		initSearch(destination, dateFrom, dateTill, quantityOfRooms, quantityOfAdults, quantityOfChildren);
		int limitToVerify = selectLowestPrice(true);
		assertFalse(getSearchResults(), "NO RESULTS FOUND!");
		selectTopViewedHotel();
		assertThat(getPrice(dateFrom, dateTill), is(lessThanOrEqualTo(limitToVerify)));
	}

	@Test(dataProvider = "searchValues", priority = 2)
	public void testBooking2(String destination, int dateFrom, int dateTill, int quantityOfRooms, int quantityOfAdults,
			int quantityOfChildren) {
		initSearch(destination, dateFrom, dateTill, quantityOfRooms, quantityOfAdults, quantityOfChildren);
		int limitToVerify = selectLowestPrice(false);
		assertFalse(getSearchResults(), NO_RESULTS_MESSAGE);
		selectTheCheapestHotel();
		assertThat(getPrice(dateFrom, dateTill), is(greaterThanOrEqualTo(limitToVerify)));
	}

	@Test(dataProvider = "reserveValues", priority = 3)
	public void testBooking3(String destination, int dateFrom, int dateTill, int quantityOfRooms, int quantityOfAdults,
			int quantityOfChildren, String card) {
		initSearch(destination, dateFrom, dateTill, quantityOfRooms, quantityOfAdults, quantityOfChildren);
		selectLowestPrice(false);
		assertFalse(getSearchResults(), NO_RESULTS_MESSAGE);
		selectFirstHotel();
		switchToCurrentTab();
		reserve(card);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public void closeTab() {
		driver.close();
		switchToCurrentTab();
	}

	private boolean getSearchResults() {
		return explicitWaitElements(
				".//div[contains(@class, 'sr_item sr_item_new sr_item_default sr_property_block  sr_flex_layout')]")
						.isEmpty();
	}

	private int getPrice(int dateFrom, int dateTill) {
		return handlePrice(getWebElement(".//span[contains(text(), 'BYN')]")) / (dateTill - dateFrom);
	}

	private WebElement explicitWaitElement(String xpath) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	private List<WebElement> explicitWaitElements(String xpath) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	private void reserve(String card) {
		new Select(getWebElement(".//select[@class='hprt-nos-select']")).selectByIndex(1);
		explicitWaitElement(".//button[contains(text(),'reserve')]").click();
		explicitWaitElement(".//input[@id='bp_travel_purpose_leasure']").click();
		new Select(getWebElement(".//select[@class='bp_input_select bp_form__field__input']")).selectByValue("mr");
		clearAndFill(getWebElement(".//input[@id='firstname']"), "John");
		clearAndFill(getWebElement(".//input[@id='lastname']"), "Smith");
		clearAndFill(getWebElement(".//input[@id='email']"), "testmail@mail.com");
		clearAndFill(getWebElement(".//input[@id='email_confirm']"), "testmail@mail.com");
		getWebElement(".//input[@name='notstayer']").click();
		getWebElement(".//button[@name='book']").click();
		new Select(getWebElement(".//select[@id='cc1']")).selectByValue("by");
		getWebElement(".//input[@id='phone']").sendKeys("291234567");
		new Select(getWebElement(".//select[@id='cc_type']")).selectByValue("Visa");
		clearAndFill(getWebElement(".//input[@id='cc_number']"), card);
		new Select(getWebElement(".//select[@id='ccYear']")).selectByIndex(1);
		findAndUseSkippingException(".//input[@id='cc_cvc']", "123");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertFalse(getListOfWebElements(".//p[contains(text(), 'Please fill in a valid card number')]").isEmpty(),
				"NO ERROR MESSAGE!");
	}

	private void initSearch(String destination, int dateFrom, int dateTill, int quantityOfRooms, int quantityOfAdults,
			int quantityOfChildren) {
		selectDestination(destination);
		selectDate(dateFrom, dateTill);
		clickSearchOptionsField();
		if (getListOfWebElements(".//button[@class='bui-button bui-button--secondary bui-stepper__add-button']")
				.isEmpty()) {
			selectSearchOptionsWithSelects(quantityOfRooms, quantityOfAdults, quantityOfChildren);
		} else {
			selectSearchOptionsWithoutSelects(quantityOfRooms, quantityOfAdults, quantityOfChildren);
		}
		clickSearchButton();
	}

	private void clearAndFill(WebElement webElement, String valueToSend) {
		webElement.clear();
		webElement.sendKeys(valueToSend);
	}

	private void findAndUseSkippingException(String xpath) {
		try {
			getWebElement(xpath).click();

		} catch (NoSuchElementException e) {
			System.out.println("ELEMENT NOT FOUND!");
		}
	}

	private void findAndUseSkippingException(String xpath, String valueToSend) {
		try {
			WebElement webElement = getWebElement(xpath);
			webElement.clear();
			webElement.sendKeys(valueToSend);

		} catch (NoSuchElementException e) {
			System.out.println("ELEMENT NOT FOUND!");
		}
	}

	private void waitForSortEnding() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sr-usp-overlay__loading']")));
	}

	private void selectTopViewedHotel() {
		waitForSortEnding();
		WebElement sort;
		findAndUseSkippingException(".//button[@id='sortbar_dropdown_button']");
		sort = getWebElement(".//a[@data-category='bayesian_review_score']");
		sort.click();
		selectFirstHotel();
		switchToCurrentTab();
	}

	private void selectTheCheapestHotel() {
		waitForSortEnding();
		WebElement cheapestPrice = getWebElement(".//li//a[@class='sort_option ' and @data-category='price']");
		cheapestPrice.click();
		selectFirstHotel();
		switchToCurrentTab();
	}

	private void selectFirstHotel() {
		waitForSortEnding();
		getWebElement("(.//a[@class='hotel_name_link url'])[1]").click();
	}

	private void selectDestination(String destination) {
		WebElement searchField = getWebElement(".//input[@id='ss']");
		searchField.clear();
		searchField.sendKeys(destination);
	}

	private void selectDate(int dateFrom, int dateTill) {
		WebElement calendar = getWebElement(".//button[@aria-label='Open calendar']");
		calendar.click();
		WebElement date = getWebElement(".//td[@data-date='" + getDate(dateFrom) + "']");
		date.click();
		date = getWebElement(".//td[@data-date='" + getDate(dateTill) + "']");
		date.click();
	}

	private void switchToCurrentTab() {
		ArrayList<String> tabList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabList.get(tabList.size() - 1));
	}

	private void clickSearchButton() {
		WebElement button = getWebElement(".//span[text()='Search']");
		button.click();
	}

	private int selectLowestPrice(boolean isLowest) {
		List<WebElement> listOfPrices = getListOfWebElements(
				".//div[@id='filter_price']//a[contains(@data-id, 'pri-')]");
		List<WebElement> listOfLimits = driver
				.findElements(By.xpath(".//div[@id='filter_price']//a[contains(@data-id, 'pri-')]//span[1]"));
		if (isLowest) {
			listOfPrices.get(0).click();
			return Integer.parseInt(getParsedLimit(listOfLimits.get(0)));
		} else {
			listOfPrices.get(listOfPrices.size() - 1).click();
			return Integer.parseInt(getParsedLimit(listOfLimits.get(listOfLimits.size() - 1)));
		}
	}

	private String getParsedLimit(WebElement elementToParse) {
		String[] arrayOfLimits = elementToParse.getText().split("[^0-9]+");
		return arrayOfLimits[arrayOfLimits.length - 1];
	}

	private List<WebElement> getListOfWebElements(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	private void selectSearchOptionsWithSelects(int quantityOfRooms, int quantityOfAdults, int quantityOfChildren) {
		WebElement option = getWebElement(
				".//select[@id='no_rooms']//option[@value='" + String.valueOf(quantityOfRooms) + "']");
		option.click();
		WebElement select = getWebElement(".//select[@name='group_adults']");
		select.click();
		option = getWebElement(
				".//select[@name='group_adults']//option[@value='" + String.valueOf(quantityOfAdults) + "']");
		option.click();
		select = getWebElement(".//select[@name='group_children']");
		select.click();
		option = getWebElement(
				".//select[@name='group_children']//option[@value='" + String.valueOf(quantityOfChildren) + "']");
		option.click();
	}

	private void selectSearchOptionsWithoutSelects(int quantityOfRooms, int quantityOfAdults, int quantityOfChildren) {
		List<WebElement> plusButtons = getListOfWebElements(
				".//button[@class='bui-button bui-button--secondary bui-stepper__add-button']");
		List<WebElement> plusValues = getListOfWebElements(".//span[@class='bui-stepper__display']");

		multipleClick(plusButtons.get(0), quantityOfRooms - parseValue(plusValues.get(0)));
		multipleClick(plusButtons.get(1), quantityOfAdults - parseValue(plusValues.get(1)));
		multipleClick(plusButtons.get(2), quantityOfChildren - parseValue(plusValues.get(2)));
	}

	private void clickSearchOptionsField() {
		WebElement select = getWebElement(".//label[@id='xp__guests__toggle']");
		select.click();
	}

	private int parseValue(WebElement elementToParse) {
		return Integer.parseInt(elementToParse.getText());
	}

	private void multipleClick(WebElement elementToClick, int clicks) {
		for (int i = 0; i < clicks; i++) {
			elementToClick.click();
		}
	}

	private WebElement getWebElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	private String getDate(int increment) {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).plusDays(increment).toString();
	}

	private int handlePrice(WebElement elementToHandle) {
		return Integer.parseInt(elementToHandle.getText().replaceAll("[^0-9]", ""));
	}
}
