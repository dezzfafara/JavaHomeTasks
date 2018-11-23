package ru.mail;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpamPage {
	private final static int WAIT_PERIOD = 10;
	private WebDriverWait wait;
	private String subjectText;

	@FindBy(xpath = ".//a[contains(@href, 'https://e.mail.ru/thread') "
			+ "and not(ancestor::div[contains(@style,'display: none')])]")
	private WebElement listOfSpamLetters;

	@FindBy(xpath = ".//div[@class='js-item-checkbox b-datalist__item__cbx' "
			+ "and not(ancestor::div[contains(@style,'display: none')])]")
	private List<WebElement> listOfSpamCheckboxes;

	@FindBy(xpath = ".//div[@class='b-datalist__item__subj' "
			+ "and not(ancestor::div[contains(@style,'display: none')])]")
	private List<WebElement> listOfSpamSubjects;

	@FindBy(xpath = ".//div[@data-name='noSpam']")
	private WebElement notSpamButton;

	@FindBy(xpath = ".//i[@class='ico ico_folder ico ico_folder_inbox']")
	private WebElement inboxLink;

	public SpamPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, WAIT_PERIOD);
	}

	public boolean doesContainSubject(WebDriver driver, String subject) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSpamLetters));
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSpamCheckboxes));
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSpamSubjects));
		return listOfSpamSubjects.stream().anyMatch(element -> element.getText().contains(subject));
	}

	public void moveToInboxByIndex(WebDriver driver, int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSpamCheckboxes));

		wait.until(ExpectedConditions.elementToBeClickable(listOfSpamCheckboxes.get(index)));
		try {
			if (!(listOfSpamCheckboxes.get(index).isSelected())) {
				listOfSpamCheckboxes.get(index).click();
				wait.until(ExpectedConditions.visibilityOfAllElements(listOfSpamSubjects));
				wait.until(ExpectedConditions.visibilityOf(listOfSpamSubjects.get(index)));
				subjectText = listOfSpamSubjects.get(index).getText();
			}
			notSpamButton.click();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("NO ELEMENT WITH SUCH INDEX IS FOUND IN SPAM FOLDER...");
		}
	}

	public void openLetter(WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(listOfSpamLetters)).click();
	}

	public void clickNotSpamButton() {
		notSpamButton.click();
	}

	public boolean hasSpamLetters(WebDriver driver) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSpamCheckboxes));
		return listOfSpamCheckboxes.isEmpty();
	}

	public String getSubjectText() {
		return this.subjectText;
	}

	public void switchToInbox(WebDriver driver) {
		wait.until(ExpectedConditions.visibilityOf(inboxLink));
		inboxLink.click();
	}

}