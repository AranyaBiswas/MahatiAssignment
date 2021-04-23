package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.BasePage;

public class GmailLoginPage extends BasePage {

	public GmailLoginPage(WebDriver driver) {
		super(driver);
	}

	By emailTextBoxBy = By.xpath("//input[@id='identifierId']");
	By nextButtonBy = By.xpath("//div[@id='identifierNext']/div/button");
	
	public WebElement GetEmailTextBox() {
		WebElement element = FindElement(emailTextBoxBy);
		return element;
	}

	public WebElement GetEmailTextBox_AndSendKeys(String inputText) {
		WebElement element = SendKeys(emailTextBoxBy, inputText);
		return element;
	}
	
	public WebElement GetNextButton() {
		WebElement element = FindElement(nextButtonBy);
		return element;
	}
	
	public WebElement GetNextButton_Click() {
		WebElement element = Click(nextButtonBy);
		return element;
	}
}
