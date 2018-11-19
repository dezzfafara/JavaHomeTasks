package task_20;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MailRuTests {
	private final static int INDEX_OF_ELEMENT = 0;
	private final static String START_URL = "https://mail.ru";
	private final static int QUANTITY_OF_LETTERS_TO_SELECT = 3;
	private WebDriver driver;
	private HomePage homePage;
	private InboxPage inboxPage;
	private SpamPage spamPage;
	private ComposeLetterPage composeLetterPage;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		inboxPage = new InboxPage(driver);
		spamPage = new SpamPage(driver);
		composeLetterPage = new ComposeLetterPage(driver);
		driver.manage().window().maximize();
		driver.get(START_URL);
	}

	@BeforeMethod
	@Parameters({ "login", "password" })
	public void login(String login, String password) {
		homePage.inboxLogin(login, password);
	}

	@Test(priority = 1, enabled = true)
	public void testMoveToSpam() {
		assertTrue(inboxPage.logoutLinkIsDisplayed());
		assertFalse(inboxPage.hasInboxLetters(), "INBOX LETTERS ARE MISSING...");
		inboxPage.moveLetterToSpamByIndex(driver, INDEX_OF_ELEMENT);
		inboxPage.switchToSpam();
		assertTrue(spamPage.doesContainSubject(driver, inboxPage.getSubjectText()),
				"NO SUCH SUBJECT FOUND IN SPAM FOLDER...");
	}

	@Test(priority = 2, enabled = true)
	public void testRemoveFromSpam() {
		assertTrue(inboxPage.logoutLinkIsDisplayed());
		inboxPage.switchToSpam();
		assertFalse(spamPage.hasSpamLetters(driver), "NO SPAM...");
		spamPage.moveToInboxByIndex(driver, INDEX_OF_ELEMENT);
		spamPage.switchToInbox(driver);
		assertTrue(inboxPage.doesContainSubject(spamPage.getSubjectText()), "NO SUCH LETTER...");
	}

	@Test(priority = 3, enabled = true)
	@Parameters({ "subject", "messageText", "recepient1", "recepient2", "recepient3" })
	public void testSendGroupLetter(String subject, String messageText, String recepient1, String recepient2,
			String recepient3) {
		composeLetterPage.clickComposeButton(driver);
		assertTrue(composeLetterPage.sendGroupLetter(driver, subject, messageText, recepient1, recepient2, recepient3),
				"EMAIL WAS NOT SENT...");
	}

	@Test(priority = 4, enabled = true)
	public void testSelectDeselectLetters() {
		inboxPage.selectLetters(driver, QUANTITY_OF_LETTERS_TO_SELECT);
		assertTrue(inboxPage.isSelectionCorrect(driver, QUANTITY_OF_LETTERS_TO_SELECT), "SELECTION IS INCORRECT...");
		inboxPage.deselectAll();
	}

	@AfterMethod
	public void logout() {
		inboxPage.logout();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
