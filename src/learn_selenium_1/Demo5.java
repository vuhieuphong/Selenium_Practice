package learn_selenium_1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Demo5 {

	public static void main(String[] args) throws InterruptedException {
		// implicit wait: wait for certain time b4 throw Exception that it cannot find ele on page
		// can change/override it anywhere, anytime
		// Syntax: driver().manage().timeouts.implicitlyWait(TimeOut,TimeUnit.SECONDS);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 
		//wait for 40 seconds to load b4 any action performed.
		//if only takes 5 seconds to load, rest 35 seconds will be ignored
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//applied globally for all web elements throughout driver instance
		
		//driver.get("https://login.yahoo.com/");
		//driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("vuhieuphong@yahoo.com");
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		// explicit wait: wait for certain conditions or max time exceeeded b4 throw ElementNotVisibleException
		// Syntax: WebDriverWait wait=new WebDriverWait(WebDriverReference,TimeOut);
		driver.get("https://www.facebook.com/");
		WebElement firstname=driver.findElement(By.name("firstname"));
		WebElement lastname=driver.findElement(By.name("lastname"));
		
		sendKeys(driver,firstname,10,"Phong");
		sendKeys(driver,lastname,20,"Vu");
		
		WebElement forgotAccount=driver.findElement(By.linkText("Forgot account?"));
		clickOn(driver,forgotAccount,10);
		
		// fluent wait: wait for a condition as well as frequency with which we want to condition b4 throw ElementNotVisibleException
		// Syntax: Wait wait=new FluentWait(WebDriver reference).withTimeout(timeout,SECONDS).pollingEvery(timeout,SECONDS).ignoring(Exception class); 
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(30,TimeUnit.SECONDS)
				.pollingEvery(1,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement content=fluentWait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText("Forgot account?"));
			}
		});
		System.out.println(content.getText());
	}
	
	public static void sendKeys(WebDriver driver1,WebElement element,int timeout,String value) {
		new WebDriverWait(driver1,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver1,WebElement element,int timeout) {
		new WebDriverWait(driver1,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
