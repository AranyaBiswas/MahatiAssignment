package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.BasePage;

public class GmailHomePage extends BasePage {

	By tabPrimaryBy = By.xpath("//div[@aria-label='Primary']");
	By emailRowsBy = By.xpath("//div//div//div//div//div//div[3]//div[1]//table[1]/tbody/tr");
	By nameOfSenderBy = By.xpath("//span[@role='gridcell']//span[contains(@email, '@')]");
	By emailSubjectBy = By.xpath("//div[@role='main']/div/table[@role='presentation']//h2");

	public GmailHomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isPrimarySelected() {
		String isSelected = FindElement(tabPrimaryBy).getAttribute("aria-selected");
		if (isSelected.equalsIgnoreCase("true")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement GetPrimaryTab() {
		WebElement element;
		element = FindElement(tabPrimaryBy);
		return element;
	}

	public WebElement ClickPrimaryTab() {
		WebElement element;
		element = Click(tabPrimaryBy);
		return element;
	}

	public int GetEmailsCount() {
		int emailsCount = FindElements(emailRowsBy).size();
		return emailsCount;
	}

	public WebElement ClickNthEmail(int nthEmail) {
		List<WebElement> emails = FindElements(emailRowsBy);
		WebElement email = emails.get(nthEmail);
		email.click();
		return email;
	}

	public String GetNameAndSenderOfEmail() {
		WebElement emailSender = FindElement(nameOfSenderBy);
		WebElement emailSubject = FindElement(emailSubjectBy);
		String nameAndSenderOfEmail = "Sender: " + emailSender.getText() + " - Subject: " + emailSubject.getText();
		return nameAndSenderOfEmail;
	}

}
