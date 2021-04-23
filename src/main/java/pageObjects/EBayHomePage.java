package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import abstractComponents.BasePage;

public class EBayHomePage extends BasePage {
	By searchBoxBy = By.xpath("//input[@aria-label='Search for anything']");
	By categoryDropdownBy = By.xpath("//select[@aria-label='Select a category for search']");
	By searchButtonBy = By.xpath("//input[@value='Search']");

	public EBayHomePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement GetSearchBox() {
		WebElement element = FindElement(searchBoxBy);
		return element;
	}

	public WebElement GetSearchBox_AndSendKeys(String inputText) {
		WebElement element = SendKeys(searchBoxBy, inputText);
		return element;
	}
	
	public WebElement GetCategoryDropdownButton() {
		WebElement element = FindElement(categoryDropdownBy);
		return element;
	}
	
	public WebElement CategoryDropdown_Select(String selectItem) {
		WebElement element = FindElement(categoryDropdownBy);
		Select select = new Select(element);
		select.selectByVisibleText(selectItem);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}
	public WebElement GetSearchButton() {
		WebElement element = FindElement(searchButtonBy);
		return element;
	}
	
	public WebElement GetSearchButton_Click() {
		WebElement element = Click(searchButtonBy);
		return element;
	}
}
