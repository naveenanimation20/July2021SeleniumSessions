package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		//create webelement + perform action(click, sendkeys, get text, isdisplayed)
		
		//1. 
//		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		
		//2. 
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("naveen@gmail.com");
//		password.sendKeys("test@123");

		//3. By locator:
		//a. ID
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		driver.findElement(emailId).sendKeys("naveen@gmail.com");
//		driver.findElement(password).sendKeys("naveen@123");

		//4. 
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement eId = driver.findElement(emailId);
//		WebElement pwd = driver.findElement(password);
//		
//		eId.sendKeys("naveen@gmail.com");
//		pwd.sendKeys("naveen@123");
		
		//5. generic function: getElement()
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId).sendKeys("naveen@gmail.com");
//		getElement(password).sendKeys("naveen@123");
		
		//6. generic function: getElement() + sendKeys()
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId, "naveen@gmail.com");
//		doSendKeys(password, "naveen@123");
		
		//7. 
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		eleUtil.doSendKeys(password, "naveen@123");
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	
	
	
	
	
	
	
	
	

}
