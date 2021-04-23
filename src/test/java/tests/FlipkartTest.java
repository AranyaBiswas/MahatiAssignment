package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataProviderClass;
import pageObjects.FlipkartHomepage;
import util.BrowserConfig;

public class FlipkartTest extends BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void setupMethods(Method m) {
		System.out.println("==============TC Starting... " + m.getName()+ "======================");
		driver = new BrowserConfig().InitializeDriver("edge");
	}

	@AfterMethod
	public void closeMethods(Method m) {
		System.out.println("==============TC Finished... " + m.getName()+ "======================");
		new BrowserConfig().QuitDriver(driver);
	}

	@Test(dataProvider="Flipkart", dataProviderClass = DataProviderClass.class)
	public void FlipkartHomePage_LinkTest(String url) throws InterruptedException {
		FlipkartHomepage flipkartHomepage = new FlipkartHomepage(driver);
		flipkartHomepage.GoTo(url);
		flipkartHomepage.CloseLoginPopup();
		flipkartHomepage.PrintNumberOfLinks();
		flipkartHomepage.PrintTextAndUrls();
	}

}
