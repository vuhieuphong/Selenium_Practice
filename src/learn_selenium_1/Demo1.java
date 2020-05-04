package learn_selenium_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		WebElement day=driver.findElement(By.id("day"));
		Select select1=new Select(day);
		Thread.sleep(1000);
		select1.selectByIndex(28);
		WebElement month=driver.findElement(By.id("month"));
		Select select2=new Select(month);
		Thread.sleep(1000);
		select2.selectByVisibleText("Jul");
		WebElement year=driver.findElement(By.id("year"));
		Select select3=new Select(year);
		Thread.sleep(1000);
		select3.selectByValue("1999");
		List<WebElement> sex=driver.findElements(By.name("sex"));
		Thread.sleep(1000);
		sex.get(0).click();
		Thread.sleep(1000);
		sex.get(1).click();
		WebElement submitBtn=driver.findElement(By.name("websubmit"));
		submitBtn.click();
	}

}
