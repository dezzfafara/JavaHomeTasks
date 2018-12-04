package com.booking;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private Select currentSelect;

	@FindBy(xpath = ".//input[@id='ss']")
	private WebElement destinationField;

	@FindBy(xpath = ".//button[@aria-label='Open calendar']")
	private WebElement dateField;

	@FindBy(xpath = ".//span[@class='xp__guests__count']")
	private WebElement parametersField;

	@FindBy(xpath = ".//div[@class='u-clearfix']//select")
	private List<WebElement> selects;

	@FindBy(xpath = ".//button[@class='bui-button bui-button--secondary bui-stepper__add-button']")
	private List<WebElement> plusButtons;

	@FindBy(xpath = ".//span[@data-bui-ref='input-stepper-value']")
	private List<WebElement> valuesBetweenButtons;

	@FindBy(xpath = ".//button[@class='sb-searchbox__button  ']")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void initSearch(WebDriver driver, String destination, int daysFrom, int daysTill, int... parameters) {
		setDestination(destination);
		setDate(driver, daysFrom, daysTill);
		parametersField.click();
		if (plusButtons.isEmpty()) {
			setSearchOptionsWithSelects(parameters);
		} else {
			setSearchOptionsWithButtons(parameters);
		}
		searchButton.click();
	}

	private void setDestination(String destination) {
		destinationField.clear();
		destinationField.sendKeys(destination);
	}

	private void setDate(WebDriver driver, int daysFrom, int daysTill) {
		dateField.click();
		driver.findElement(By.xpath(".//td[@data-date='" + getDateInStringFormat(daysFrom) + "']")).click();
		driver.findElement(By.xpath(".//td[@data-date='" + getDateInStringFormat(daysTill) + "']")).click();
	}

	private String getDateInStringFormat(int daysIncrement) {
		return LocalDate.from(new Date().toInstant().atZone(ZoneId.of("Europe/Moscow"))).plusDays(daysIncrement)
				.toString();
	}

	private void setSearchOptionsWithSelects(int... parameters) {
		for (int i = 0; i < selects.size(); i++) {
			if (i < parameters.length) {
				currentSelect = new Select(selects.get(i));
				currentSelect.selectByValue(String.valueOf(parameters[i]));
			}
		}
	}

	private void setSearchOptionsWithButtons(int... parameters) {
		for (int i = 0; i < plusButtons.size(); i++) {
			if (i < parameters.length) {
				while (parseValueOfElement(valuesBetweenButtons.get(i)) < parameters[i]) {
					plusButtons.get(i).click();
				}
			}
		}
	}

	private int parseValueOfElement(WebElement elementToParse) {
		return Integer.parseInt(elementToParse.getText());
	}

}
