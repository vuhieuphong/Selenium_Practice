package learn_selenium_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Demo12 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();	
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Actions object named builder
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		Thread.sleep(1000);
		WebElement link=driver.findElement(By.xpath("//span[contains(text(),'Your Orders')]"));
		builder.moveToElement(link).build().perform();
		Thread.sleep(1000);
		link.click();
		WebElement emailBar=driver.findElement(By.id("ap_email"));
		builder.moveToElement(emailBar).build().perform();
		WebElement continueBtn=driver.findElement(By.id("continue"));
		Thread.sleep(1000);
		builder.moveToElement(continueBtn).build().perform();
		Thread.sleep(1000);
		//perform a series of actions
		Action seriesOfActions=builder
				.sendKeys(emailBar,"vuhieuphong99@gmail.com")
				.keyDown(continueBtn,Keys.SHIFT)
				//.keyUp(continueBtn,Keys.SHIFT)  //will cause stale element since link is clicked and button no longer in DOM
				.build();
		seriesOfActions.perform();
			
		Thread.sleep(1000);
		//drag and drop action
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		Thread.sleep(1000);
		builder.dragAndDrop(source, target).build().perform();
		Thread.sleep(1000);
		driver.quit();
	}
	
	// Keyboard Interface: 
	// SendKeys(), KeyDown(), KeyUp()
	// Mouse Interface : 
	// Click(), DoubleClick(), ContextClick(), Release()
	// ClickAndHold() : click at current mouse location w/o releasing
	// DragAndDrop() : clickAndHold at source location n moves to target w/o releasing mouse
	// DragAndDropBy() : clickAndHold at source location n shifts according to given offset x n y axis 
	// MoveByOffset() : shift mouse from current position to given offset
	// MoveToElement() : shift mouse location to centre of element
	
	// Syntax: Action.DragAndDrop(source,target).build().perform();
	
}
