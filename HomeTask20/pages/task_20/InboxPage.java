package task_20;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
	private final static int WAIT_PERIOD = 10;
	private WebDriverWait wait;
	private String subjectText;

	@FindBy(xpath = ".//a[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = ".//div[@class='js-item-checkbox b-datalist__item__cbx' and not(ancestor::div[contains(@style,'display: none')])]//preceding-sibling::div[@class='b-checkbox__box']")
	private List<WebElement> checkboxList;

	@FindBy(xpath = ".//div[@data-name='spam']")
	private WebElement spamButton;

	@FindBy(xpath = ".//div[@class='b-datalist__item__subj' and not(ancestor::div[contains(@style,'display: none')])]")
	private List<WebElement> listOfSubjects;

	@FindBy(xpath = ".//i[@class='ico ico_folder ico ico_folder_spam']")
	private WebElement spamLink;

	@FindBy(xpath = ".//div[@class='js-item-checkbox b-datalist__item__cbx' and not(ancestor::div[contains(@style,'display: none')])]//preceding-sibling::div[@class='b-checkbox__box']//ancestor::div[@class='js-checkbox b-checkbox b-checkbox_checked']")
	private List<WebElement> checkedCheckBoxes;

	@FindBy(xpath = ".//div[@class='b-dropdown b-dropdown_selectAll']")
	private WebElement deSelectAll;

	public InboxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, WAIT_PERIOD);
	}

	public void logout() {
		logoutLink.click();
	}

	public boolean logoutLinkIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(logoutLink)).isDisplayed();
	}

	public boolean hasInboxLetters() {
		return listOfSubjects.isEmpty();
	}

	public void moveLetterToSpamByIndex(WebDriver driver, int index) {
		explictWait(checkboxList);
		explictWait(checkboxList.get(index));
		try {
			if (!(checkboxList.get(index).isSelected())) {
				checkboxList.get(index).click();
			}
			explictWait(listOfSubjects);
			subjectText = listOfSubjects.get(index).getText();
			spamButton.click();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("NO ELEMENT WITH SUCH INDEX IN INBOX...");
		}
	}

	private void explictWait(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void explictWait(List<WebElement> listOfElements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
	}

	public void selectLetters(WebDriver driver, int quantityOfLettersToSelect) {
		explictWait(checkboxList);
		for (int i = 0; i < quantityOfLettersToSelect; i++) {
			if (i < checkboxList.size()) {
				checkboxList.get(i).click();
			}
		}
	}

	public void deselectAll() {
		deSelectAll.click();
	}

	public boolean isSelectionCorrect(WebDriver driver, int quantityOfLettersToSelect) {
		return (checkedCheckBoxes.size() == quantityOfLettersToSelect) ? true : false;
	}

	public boolean doesContainSubject(String subject) {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSubjects));
		return listOfSubjects.stream().anyMatch(element -> element.getText().contains(subject));
	}

	public String getSubjectText() {
		return this.subjectText;
	}

	public void switchToSpam() {
		spamLink.click();
	}
}
