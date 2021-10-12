package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithWebElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement emailId = driver.findElement(By.id("input-email"));
		
		emailId.sendKeys("naveen@gmail.com");
		
		driver.navigate().refresh();
		
		emailId = driver.findElement(By.id("input-email"));
		emailId.sendKeys("tom@gmail.com");
		//StaleElementReferenceException: stale element reference:
		//element is not attached to the page document		
		
	}

}
