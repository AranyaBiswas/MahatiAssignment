package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserConfig {

	public WebDriver InitializeDriver(String browser) {
		WebDriver driver;

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\chromedriver_win32_V75\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\resources\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			firefoxOptions.addPreference("browser.download.folderList", 2);
			firefoxOptions.addPreference("browser.download.dir", System.getProperty("user.home") + "\\Downloads");
			firefoxOptions.addPreference("browser.download.useDownloadDir", true);
			firefoxOptions.addPreference("browser.download.viewableInternally.enabledTypes", "");
			firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/pdf;text/plain;application/text;text/xml;application/xml");
			firefoxOptions.addPreference("pdfjs.disabled", true); // disable the built-in PDF viewer
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\resources\\edgedriver_win64_V89\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
		case "internet explorer":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\resources\\IEDriverServer_X64_3.150.1\\IEDriverServer.exe");
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.requireWindowFocus();
			ieOptions.ignoreZoomSettings();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			driver = new InternetExplorerDriver(ieOptions);
			break;
		default:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\chromedriver_win32_V75\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
			driver = new ChromeDriver(chromeOptions);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public void QuitDriver(WebDriver driver) {
		driver.quit();
	}

}
