package task_20;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeLetterPage {
	private final static String PART_OF_SEND_URL = "sendmsgok";
	private final static int POLLING = 300;
	private final static int DURATION = 300;
	private FluentWait<WebDriver> fluentWait;
	private WebDriverWait wait;

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

	public ComposeLetterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(POLLING))
				.withTimeout(Duration.ofSeconds(DURATION)).ignoring(NoSuchElementException.class);
	}

	public void clickComposeButton(WebDriver driver) {
		wait.until(ExpectedConditions.visibilityOf(composeButton)).click();
	}

	private Function<WebDriver, WebElement> sendInfoMessageIsAppeared = new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			return driver.findElement(By.xpath(".//div[@class='message-sent__title']"));
		}
	};

	public boolean sendGroupLetter(WebDriver driver, String subject, String message, String... addresses) {
		sendToField.clear();
		Arrays.asList(addresses).forEach(address -> sendToField.sendKeys(address + " "));
		subjectField.clear();
		subjectField.sendKeys(subject);
		driver.switchTo().frame(textFrame);
		messageArea.clear();
		messageArea.sendKeys(message);
		driver.switchTo().defaultContent();
		sendButton.click();
		fluentWait.until(sendInfoMessageIsAppeared);
		String currentURL = driver.getCurrentUrl();
		return (currentURL.contains(PART_OF_SEND_URL)) ? true : false;

	}
}