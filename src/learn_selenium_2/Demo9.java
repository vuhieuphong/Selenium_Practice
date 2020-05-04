package learn_selenium_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo9 {
	public String baseUrl = "https://www.amazon.ca/";
	String driverPath = "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching Chrome Browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void verifyHomepageTitle() {
		String expectedTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
