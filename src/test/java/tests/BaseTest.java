package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

	@BeforeSuite
	public void StartSuite() {
	}

	@AfterSuite
	public void EndSuite() {
	}
}
