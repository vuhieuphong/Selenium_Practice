package learn_selenium_3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo13 {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).click();
		Robot robot=new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		System.out.println("a");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		System.out.println("b");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		System.out.println("c");
		robot.mouseMove(30, 100);
		System.out.println("d");
		Thread.sleep(1000);
		driver.quit();
	}
	
	// Robot Class:
	// upload file, handle popups, mouse n keyboard functions
	// robot.keyPress(KeyEvent.VK_DOWN)
	// robot.keyRelease(KeyEvent.VK_DOWN)
	// robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
	// robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK)
	// robot.mouseMove(point.getX(),point.getY())
	
	// Limitations:
	// mouse n keyboard event only work on current window instance
	// difficult to switch among frames or windows
	// mouseMove() depends on screen resolution
}
