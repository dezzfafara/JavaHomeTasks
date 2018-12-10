package ru.mail;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import database.SQLConnector;
import factory.DriverManager;
import factory.DriverManagerFactory;
import factory.DriverManagerFactory.DriverType;
import helper.PageHelper;
import model.Connection;
import model.Credentials;
import parser.ParserRunner;
import ru.mail.pages.InboxPage;
import ru.mail.pages.MainPage;

public class InboxTests {
	private final static String MAIN_PAGE_URL = "https://mail.ru";
	private DriverManager driverManager;
	private WebDriver driver;
	private MainPage mainPage;
	private InboxPage inboxPage;
	private Connection connection;
	private SQLConnector sqlConnector;
	private Credentials credentials;
	private PageHelper pageHelper;
	private final static Logger logger = Logger.getLogger(InboxTests.class);

	public InboxTests()
			throws XMLStreamException, SAXException, IOException, ParserConfigurationException, SQLException {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		pageHelper = new PageHelper(driver);
		mainPage = new MainPage(driver);
		inboxPage = new InboxPage(driver);
		sqlConnector = new SQLConnector();
		connection = new ParserRunner().initDOMParser();
		credentials = sqlConnector.getCredentialsData(connection.getUrl(), connection.getLogin(),
				connection.getPassword(), connection.getQuery());

	}

	@Given("^I am on the main application page$")
	public void goToMainPage() {
		driver.get(MAIN_PAGE_URL);
		driver.manage().window().maximize();
	}

	@Then("^I login$")
	public void testLogin() {
		mainPage.login(credentials.getLogin(), credentials.getPassword(), credentials.getDomain());
		pageHelper.captureScreen(logger);
	}

	@When("^I compose and send letter: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void testComposeLetter(String subject, String message, String address1, String address2, String address3) {
		inboxPage.composeLetter(driver, subject, message, address1, address2, address3);
		pageHelper.captureScreen(logger);
	}

	@Then("^I see success send page$")
	public void testIsSendSuccess() {
		pageHelper.customLogger(logger, inboxPage.isSuccessfullSend(driver), "Email is sent...",
				"Email is not sent...");
		assertTrue(inboxPage.isSuccessfullSend(driver));
		pageHelper.captureScreen(logger);
	}

	@When("^I select and remove all letters$")
	public void testRemoveAllLetters() {
		inboxPage.removeAllLetters();
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that inbox folder is empty$")
	public void testIsInboxEmpty() {
		pageHelper.customLogger(logger, inboxPage.isLettersPresent(driver), "All letters are removed...",
				"NOT all letters are removed...");
		assertTrue(inboxPage.isLettersPresent(driver));
		pageHelper.captureScreen(logger);
	}

	@When("^I move to bin folder and move all letters to inbox$")
	public void testMoveToInbox() throws AWTException {
		inboxPage.moveToInbox();
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that bin folder is empty$")
	public void testIsBinEmpty() {
		pageHelper.customLogger(logger, inboxPage.isLettersPresent(driver), "All letters are moved to inbox...",
				"NOT all letters are moved to inbox...");
		assertTrue(inboxPage.isLettersPresent(driver));
		pageHelper.captureScreen(logger);
	}

	@When("^I click configure folders and add folder \"([^\"]*)\"$")
	public void testAddFolder(String folderName) {
		inboxPage.addFolder(driver, folderName);
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that folder \"([^\"]*)\" is added$")
	public void testIsFolderAdded(String folderName) {
		pageHelper.customLogger(logger, inboxPage.isFolderAdded(driver, folderName), "Folder is added...",
				"Folder is not added...");
		assertTrue(inboxPage.isFolderAdded(driver, folderName));
		pageHelper.captureScreen(logger);
	}

	@When("^I mark all letters with flags$")
	public void testMarkFlags() {
		inboxPage.markAllWithFlags();
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that all letters are marked with flag$")
	public void tetsIsAllMarked() {
		pageHelper.customLogger(logger, inboxPage.isAllMarked(), "All letters are marked...",
				"NOT all letters are marked...");
		assertTrue(inboxPage.isAllMarked());
		pageHelper.captureScreen(logger);
	}

	@When("^I sort letters by subject in ascending order$")
	public void testSortAscending() {
		inboxPage.sortBySubject();
		pageHelper.captureScreen(logger);
	}

	@Then("^I see that letters are sorted in ascending order$")
	public void testIsAscendingSorted() {
		pageHelper.customLogger(logger, inboxPage.isAscendingSorted(driver), "Letters are sorted ascending...",
				"Letters are NOT sorted ascending...");
		assertTrue(inboxPage.isAscendingSorted(driver));
		pageHelper.captureScreen(logger);
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
