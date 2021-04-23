package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.BasePage;

public class FlipkartHomepage extends BasePage {
	By linksBy = By.tagName("a");
	By closeLoginPopupBy = By.xpath("//button[contains(text(),'✕')]");

	public FlipkartHomepage(WebDriver driver) {
		super(driver);
	}

	public void CloseLoginPopup() {
		try {
			Click(closeLoginPopupBy);
			System.out.println("Closed the login popup in homepage...");
		} catch (Exception e) {
			System.out.println("login popup in homepage not present..." + e.getMessage());
		}

	}

	public void PrintNumberOfLinks() {
		int count = FindElements(linksBy).size();
		System.out.println("============Starting Validation================");
		System.out.println(String.format("Number of links present in Flipkart Homepage is: %d", count));
		System.out.println("============Ending Validation================");
	}

	public void PrintTextAndUrls() {
		List<WebElement> links = FindElements(linksBy);
		System.out.println("============Starting Validation================");
		for (WebElement link : links) {
			System.out.println(String.format("Link Text: %s", link.getText()));
			System.out.println(String.format("Link URL: %s\n", link.getAttribute("href")));
		}
		System.out.println("============Ending Validation================");
	}
}
