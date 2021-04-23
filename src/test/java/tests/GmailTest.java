package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataProviderClass;
import pageObjects.GmailHomePage;
import pageObjects.GmailLoginPage;
import pageObjects.GmailPasswordPage;
import util.BrowserConfig;

public class GmailTest extends BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void setupMethods(Method m) {
		System.out.println("==============TC Starting... " + m.getName() + "======================");
		driver = new BrowserConfig().InitializeDriver("firefox");
	}

	@AfterMethod
	public void closeMethods(Method m) {
		System.out.println("==============TC Finished... " + m.getName() + "======================");
		new BrowserConfig().QuitDriver(driver);
	}

	@Test(dataProvider="Gmail", dataProviderClass = DataProviderClass.class)
	public void Gmail_EmailTest(String url, String email, String password) throws InterruptedException {
		GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);
		gmailLoginPage.GoTo(url);
		gmailLoginPage.GetEmailTextBox_AndSendKeys(email);
		gmailLoginPage.GetNextButton_Click();
		GmailPasswordPage gmailPasswordPage = new GmailPasswordPage(driver);
		gmailPasswordPage.GetPasswordTextBox_AndSendKeys(password);
		gmailPasswordPage.GetNextButton_Click();
		GmailHomePage gmailHomePage = new GmailHomePage(driver);
		if (!gmailHomePage.isPrimarySelected()) {
			gmailHomePage.ClickPrimaryTab();
		}
		System.out.println(String.format("Email Count: %d", gmailHomePage.GetEmailsCount()));
		gmailHomePage.ClickNthEmail(1);
		System.out.println(String.format("Name & Sender: %s", gmailHomePage.GetNameAndSenderOfEmail()));
	}

}
