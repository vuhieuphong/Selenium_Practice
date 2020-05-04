package learn_selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTest.class)
public class Demo8 {
	public WebDriver driver;
	
	@Test
	public void Login() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://www.amazon.ca/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone X");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(1000);
	}
	
	@Test
	public void TestToFail() {
		System.out.println("This method is to test fail");
		Assert.assertTrue(false);
	}
}
