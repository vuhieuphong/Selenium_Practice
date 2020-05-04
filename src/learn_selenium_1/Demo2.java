package learn_selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.ca");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Guild Wars 2");
		driver.findElement(By.className("nav-input")).click();
		//navigate to another site
		driver.navigate().to("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.quit();
	}
}
