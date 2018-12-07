package com.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrentHotelPage {

	@FindBy(xpath = ".//div[@class='bui-review-score c-score bui-review-score--end']"
			+ "//div[@class='bui-review-score__badge']")
	private WebElement reviewScore;

	public CurrentHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public double getParsedReviewScore(WebDriver driver) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(reviewScore));
		return Double.parseDouble(reviewScore.getText().trim());
	}

}
