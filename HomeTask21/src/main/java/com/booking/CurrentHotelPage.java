package com.booking;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrentHotelPage {

	@FindBy(xpath = ".//div[@class='bui-review-score c-score bui-review-score--end']"
			+ "//div[@class='bui-review-score__badge']")
	private WebElement reviewScore;

	public CurrentHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public double getParsedReviewScore() {
		return Double.parseDouble(reviewScore.getText().trim());
	}

	public void switchToCurrentTab(WebDriver driver) {
		ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsList.get(tabsList.size() - 1));
	}

}
