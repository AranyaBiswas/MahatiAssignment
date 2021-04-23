package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.BasePage;

public class GmailPasswordPage extends BasePage {

	public GmailPasswordPage(WebDriver driver) {
		super(driver);
	}

	By passwordTextBoxBy = By.xpath("//input[@name='password']");
	By nextButtonBy = By.xpath("//div[@id='passwordNext']/div/button");
	
	public WebElement GetPasswordTextBox() {
		WebElement element = FindElement(passwordTextBoxBy);
		return element;
	}

	public WebElement GetPasswordTextBox_AndSendKeys(String inputText) {
		WebElement element = SendKeys(passwordTextBoxBy, inputText);
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
