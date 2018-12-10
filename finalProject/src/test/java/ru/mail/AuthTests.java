package ru.mail;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
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

public class AuthTests {
	private final static String MAIN_PAGE_URL = "https://mail.ru";
	private DriverManager driverManager;
	private WebDriver driver;
	private MainPage mainPage;
	private InboxPage inboxPage;
	private Connection connection;
	private SQLConnector sqlConnector;
	private Credentials credentials;
	private PageHelper pageHelper;
	private final static Logger logger = Logger.getLogger(AuthTests.class);

	public AuthTests()
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

	@Given("^I am on the main page$")
	public void goToMainPage() {
		driver.manage().window().maximize();
		driver.get(MAIN_PAGE_URL);
	}

	@When("^I login with valid credentials$")
	public void testValidLogin() {
		mainPage.login(credentials.getLogin(), credentials.getPassword(), credentials.getDomain());
		pageHelper.captureScreen(logger);
	}

	@Then("^I see logout link$")
	public void testPresenceOflogoutLink() {
		pageHelper.customLogger(logger, inboxPage.isElementPresent(), "Successfull login...", "Unsuccessfull login...");
		assertTrue(inboxPage.isElementPresent());
		pageHelper.captureScreen(logger);
	}

	@Then("^I logout$")
	public void testLogout() {
		inboxPage.logout();
		pageHelper.captureScreen(logger);
	}

	@And("^I see register link$")
	public void testPresenceOfRegisterLink() {
		pageHelper.customLogger(logger, mainPage.isElementPresent(), "Successfull logout...",
				"Unsuccessfull logout...");
		assertTrue(mainPage.isElementPresent());
		pageHelper.captureScreen(logger);
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
