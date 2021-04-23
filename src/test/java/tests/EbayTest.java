package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataProviderClass;
import pageObjects.EBayHomePage;
import util.BrowserConfig;

public class EbayTest extends BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void setupMethods(Method m) {
		System.out.println("==============TC Starting... " + m.getName() + "======================");
		driver = new BrowserConfig().InitializeDriver("edge");
	}

	@AfterMethod
	public void closeMethods(Method m) {
		System.out.println("==============TC Finished... " + m.getName() + "======================");
		new BrowserConfig().QuitDriver(driver);
	}

	@Test(dataProvider="Ebay", dataProviderClass = DataProviderClass.class)
	public void Ebay_ProductSearchTest(String url, String searchItem, String category) throws InterruptedException {
		EBayHomePage eBayHomePage = new EBayHomePage(driver);
		eBayHomePage.GoTo(url);
		eBayHomePage.GetSearchBox_AndSendKeys(searchItem);
		eBayHomePage.CategoryDropdown_Select(category);
		eBayHomePage.GetSearchButton_Click();
		Thread.sleep(2000); //Just for visual satisfaction that TC is passing
		
	}

}
