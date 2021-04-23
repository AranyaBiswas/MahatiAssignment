package abstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	public void GoTo(String URL) {
		driver.get(URL);
		System.out.println("Navigation to the URL: '" + URL + "' is successfull...");
	}

	public WebElement WaitForElement(By elementBy) {
		WebElement element;
		System.out.println("Waiting for the element: " + elementBy.toString());
		element = wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				element);
		return element;
	}

	public WebElement FindElement(By elementBy) {
		WebElement element;
		WaitForElement(elementBy);
		System.out.println("Trying to find the element: " + elementBy.toString());
		element = driver.findElement(elementBy);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}

	public List<WebElement> FindElements(By elementBy) {
		List<WebElement> elements;
		WaitForElement(elementBy);
		System.out.println("Trying to find the elements: " + elementBy.toString());
		elements = driver.findElements(elementBy);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elements;
	}

	public WebElement Click(By elementBy) {
		WebElement element;
		element = FindElement(elementBy);
		element.click();
		System.out.println("Successfully clicked on: '" + elementBy.toString() + "'...");
		return element;
	}

	public WebElement Click_Javascript(By elementBy) {
		WebElement element;
		element = driver.findElement(elementBy);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("Successfully clicked on: '" + elementBy.toString() + "'...");
		return element;
	}

	public WebElement SendKeys(By elementBy, String input) {
		WebElement element;
		element = FindElement(elementBy);
		element.sendKeys(input);
		System.out.println("Sent text: '" + input + "' in '" + elementBy.toString() + "' Text Box...");
		return element;
	}

	public void waitForVisibilityOfElement(By elementBy) {
		System.out.println("Waiting for Visibility of Element... " + elementBy);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
	}

	public void waitForInvisibilityOfElement(By elementBy) {
		System.out.println("Waiting for Invisibility of Element... " + elementBy);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
	}

	public WebElement ScrollToView(By elementBy) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = FindElement(elementBy);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	public void AssertString(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("Assertion passed - Actual: '" + actual + "' is equals to the expected: ' " + expected);
		} catch (Exception e) {
			System.out.println("Assertion failed - Actual: '" + actual
					+ "' is NOT equals to the expected... Error Details: " + e.getMessage());
		}
	}

	public void AssertTrue(boolean actual) {
		try {
			Assert.assertTrue(actual);
			System.out.println("Assertion passed - True");
		} catch (Exception e) {
			System.out.println("Assertion failed - False - Error Details: " + e.getMessage());
		}
	}

}
