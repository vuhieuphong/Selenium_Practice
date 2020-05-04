package learn_selenium_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo6 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// the driver will be below the alert
		// Driver.switchTo() to switch to alert
		// Alert.dismiss() or Alert.accept() for confirmation alerts
		// Alert.getText()
		// Alert.sendKeys() for prompt alerts
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Thread.sleep(1000);
		Alert alert=driver.switchTo().alert();
		String alertMessage=alert.getText();
		System.out.println(alertMessage);
		Thread.sleep(1000);
		alert.accept();
		
		//Close Popup with Robot
		//driver.findElement(By.id("PopUp")).click();
		//Robot robot=new Robot();
		//robot.mouseMove(400, 5);
		//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//Thread.sleep(1000);
		//robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		// Exceptions: WebDriverException, NoSuchElementException, 
		// NoSuchFrameException, NoAlertFoundException, TimeoutException
		
	}

}
