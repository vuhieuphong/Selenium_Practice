package learn_selenium_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//For Firefox:
		//System.setProperty("webdriver.gecko.driver","...");
		//WebDriver driver=new FirefoxDriver();
		//driver.manage().deleteAllCookies();
		
		//stop loading page after 40 secs
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//throw exception after waiting for next element for 30 secs
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("vuhieuphong1999@gmail.com");
		//driver.findElement(By.cssSelector("#identifierId")).sendKeys("vuhieuphong1999@gmail.com");
		//driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("vuhieuphong1999@gmail.com");
		driver.findElement(By.className("CwaK9")).click();
		String at=driver.getTitle();
		String et="gmail";
		driver.close();
		if(at.equalsIgnoreCase(et)) {
			System.out.println("Test Successful");
		}
		else {
			System.out.println("Test Failure");
		}
	}

}
