package com.booking;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	private final static int WAIT_PERIOD = 10;
	private final static int POLLING = 300;
	private final static int DURATION = 10;
	private WebDriverWait wait;
	private FluentWait<WebDriver> fluentWait;

	@FindBy(xpath = ".//a[@class='hotel_name_link url']")
	private List<WebElement> searchResults;

	@FindBy(xpath = ".//button[@id='sortbar_dropdown_button']")
	private List<WebElement> moreSortOptions;

	@FindBy(xpath = ".//a[@data-category='bayesian_review_score']")
	private WebElement topViewed;

	@FindBy(xpath = ".//div[@class='sr-usp-overlay__loading']")
	private List<WebElement> sortingBanners;

	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, WAIT_PERIOD);
		fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(POLLING))
				.withTimeout(Duration.ofSeconds(DURATION)).ignoring(NoSuchElementException.class);
	}

	public boolean hasSearchResults() {
		return wait.until(ExpectedConditions.visibilityOfAllElements(searchResults)).isEmpty();
	}

	public void selectTopViewedHotels() {
		if (!(moreSortOptions).isEmpty()) {
			moreSortOptions.get(0).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(topViewed)).click();
	}

	public void selectFirstHotel() {
		fluentWait.until(firstHotelAfterSorting).click();
	}

	private Function<WebDriver, WebElement> firstHotelAfterSorting = new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			return (sortingBanners.isEmpty()) ? searchResults.get(0) : null;
		}
	};

}
