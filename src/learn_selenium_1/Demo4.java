package learn_selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//using cssSelector
		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("OnePlus6T");
		driver.findElement(By.cssSelector("#gh-btn")).click();
		Thread.sleep(2000);
		//using xpath
		WebElement searchBar=driver.findElement(By.xpath("//input[@id='gh-ac']"));
		searchBar.clear();
		searchBar.sendKeys("Guitar");
		WebElement searchIcon=driver.findElement(By.xpath("//input[@id='gh-btn']"));
		searchIcon.click();
		
		js.executeScript("window.scrollBy(0,1000)");
		
		// htmltag[locator *= 'value']   //contain
		// htmltag[locator ^= 'value']   //prefix
		// htmltag[locator $= 'value']   //subfix
		// eg: // span[class*='item__price']
		
		// xpath starts w //:instruct xpath to search for element in root node
		// xpath starts w  /:instruct xpath to search for element anywhere in html
		
		// xpath functions: 
		// 1. contains() :
		// eg: //img[contains(@src,'sprites')
		
		// 2.starts-with() :
		// eg: //img[starts-with(@alt,'Shop')
		
		// 3.text() :
		// eg: //*[text()='Orders']
		// * means any tag
		
		// OR operation: |
	}

}
