package data;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "Ebay")
	public Object[][] getEbayData(Method method) throws IOException {
		Object[][] arr = { { "https://www.ebay.com/", "Apple Watches", "Consumer Electronics" } };
		return arr;
	}
	
	@DataProvider(name = "Flipkart")
	public Object[][] getFlipkartData(Method method) throws IOException {
		Object[][] arr = { { "https://flipkart.com " } };
		return arr;
	}
	
	@DataProvider(name = "Gmail")
	public Object[][] getGmailData(Method method) throws IOException {
		Object[][] arr = { { "https://www.google.com/gmail/", "aaa@gmail.com", "aaa111@@1" } };
		return arr;
	}
}
