package ru.mail.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class InboxPage extends Page {
	private final static String PART_OF_SEND_URL = "sendmsgok";

	@FindBy(xpath = ".//a[@id='PH_logoutLink']")
	protected WebElement logoutLink;

	@FindBy(xpath = ".//i[@class='ico ico_toolbar ico_toolbar_compose']")
	private WebElement composeButton;

	@FindBy(xpath = ".//textarea[@data-original-name='To']")
	private WebElement sendToField;

	@FindBy(xpath = ".//input[@name='Subject']")
	private WebElement subjectField;

	@FindBy(xpath = ".//body[@class='mceContentBody compose2']")
	private WebElement messageArea;

	@FindBy(xpath = ".//iframe[contains(@id, 'toolkit')]")
	private WebElement textFrame;

	@FindBy(xpath = ".//div[@data-shortcut-title='Ctrl+Enter']")
	private WebElement sendButton;

	@FindBy(xpath = ".//div[@data-name='remove']")
	private WebElement removeButton;

	@FindBy(xpath = ".//div[@class='b-checkbox__box']")
	private WebElement selectCheckbox;

	@FindBy(xpath = "(.//div[@class='b-dropdown b-dropdown_selectAll'])[1]")
	private WebElement selection;

	@FindBy(xpath = ".//span[@class='b-dropdown__list__item__text' and text()='Выделить все письма']")
	private WebElement selectAll;

	@FindBy(xpath = ".//div[@class='b-datalist__item__subj']")
	private List<WebElement> listOfSubjects;

	@FindBy(xpath = ".//a[@href='/messages/trash/']")
	private WebElement binFolder;

	@FindBy(xpath = ".//span[@class='b-dropdown__ctrl__text' and text()='Переместить']")
	private WebElement moveTo;

	@FindBy(xpath = ".//a[@data-name='0']/span[@class='b-dropdown__list__item__text']")
	private WebElement toInbox;

	@FindBy(xpath = ".//div[@class='notify']")
	private List<WebElement> notifications;

	@FindBy(xpath = ".//span[@class='b-nav__link__text']")
	private WebElement configureFolders;

	@FindBy(xpath = ".//button[@data-name='newFolder']")
	private WebElement addFolderButton;

	@FindBy(xpath = ".//div[@class='is-folder-add_in']")
	private WebElement addFolderWindow;

	@FindBy(xpath = ".//div[@class='js-hover b-flag b-flag_onhover']")
	private List<WebElement> unmarkedFlags;

	@FindBy(xpath = ".//span[@class='b-dropdown__ctrl__text' and text()='Вид']")
	private WebElement sortOptions;

	@FindBy(xpath = "(.//a[@data-bem='b-dropdown__list__params' and @data-name='sort_subj_asc'])[1]")
	private WebElement sortAscending;

	@FindBy(xpath = ".//div[@id='b-nav_folders']")
	private WebElement foldersArea;

	public InboxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void logout() {
		logoutLink.click();
	}

	public boolean isElementPresent() {
		return wait.until(ExpectedConditions.visibilityOf(logoutLink)).isDisplayed();
	}

	private Function<WebDriver, WebElement> sendInfoMessageIsAppeared = new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.xpath(".//div[@class='message-sent__title']"));
		}
	};

	public boolean isSuccessfullSend(WebDriver driver) {
		fluentWait.until(sendInfoMessageIsAppeared);
		return driver.getCurrentUrl().contains(PART_OF_SEND_URL);
	}

	public void removeAllLetters() {
		wait.until(ExpectedConditions.invisibilityOfAllElements(notifications));
		wait.until(ExpectedConditions.visibilityOf(selectCheckbox)).click();
		removeButton.click();
	}

	public void moveToInbox() throws AWTException {
		binFolder.click();
		wait.until(ExpectedConditions.invisibilityOfAllElements(notifications));
		wait.until(ExpectedConditions.visibilityOf(selection)).click();
		new Robot().keyPress(KeyEvent.VK_V);
		toInbox.click();
	}

	public boolean isLettersPresent(WebDriver driver) {
		driver.navigate().refresh();
		return listOfSubjects.isEmpty();
	}

	public void composeLetter(WebDriver driver, String subject, String message, String... addresses) {
		wait.until(ExpectedConditions.visibilityOf(composeButton)).click();
		sendToField.clear();
		Arrays.asList(addresses).stream().forEach(a -> sendToField.sendKeys(a + " "));
		clearAndFill(subjectField, subject);
		driver.switchTo().frame(textFrame);
		clearAndFill(messageArea, message);
		driver.switchTo().defaultContent();
		sendButton.click();
	}

	public void addFolder(WebDriver driver, String folderName) {
		wait.until(ExpectedConditions.visibilityOf(foldersArea));
		new Actions(driver).moveToElement(foldersArea).build().perform();
		configureFolders.click();
		addFolderButton.click();
		clearAndFill(addFolderWindow.findElement(By.xpath(".//input[@class='b-input b-input_popup']")), folderName);
		addFolderWindow.findElement(By.xpath(".//span[@class='btn__text' and text()='Добавить']")).click();
	}

	public boolean isFolderAdded(WebDriver driver, String folderName) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.invisibilityOfAllElements(notifications));
		return driver.findElement(By.xpath(
				".//div[@class='b-folders__item-col b-folders__item-col_title ' and text()='" + folderName + "']"))
				.isDisplayed();
	}

	public void markAllWithFlags() {
		wait.until(ExpectedConditions.visibilityOfAllElements(unmarkedFlags));
		unmarkedFlags.stream().forEach(e -> e.click());
	}

	public boolean isAllMarked() {
		return unmarkedFlags.isEmpty();
	}

	public void sortBySubject() {
		wait.until(ExpectedConditions.visibilityOf(sortOptions)).click();
		sortAscending.click();
	}

	public boolean isAscendingSorted(WebDriver driver) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSubjects));
		return isAscending();

	}

	private boolean isAscending() {
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSubjects));
		for (int i = 1; i < listOfSubjects.size(); i++) {
			if (listOfSubjects.get(i - 1).getText().compareTo(listOfSubjects.get(i).getText()) <= 0) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
