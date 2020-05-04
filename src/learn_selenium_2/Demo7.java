package learn_selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Demo7 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		EventFiringWebDriver eventHandler=new EventFiringWebDriver(driver);
		EventCapture eCapture=new EventCapture();
		eventHandler.register(eCapture);		
		
		eventHandler.navigate().to("https://the-internet.herokuapp.com/");
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		eventHandler.findElement(By.linkText("Redirect Link")).click();
		Thread.sleep(1000);
		eventHandler.navigate().to("https://the-internet.herokuapp.com/status_codes");
		Thread.sleep(1000);
		//navigate back to the first page
		eventHandler.navigate().back();
		Thread.sleep(1000);
		eventHandler.quit();
		eventHandler.unregister(eCapture);
		System.out.println("End of Listener Class");
	}
	
}
