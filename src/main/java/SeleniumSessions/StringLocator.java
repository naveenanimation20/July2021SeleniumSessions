package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StringLocator {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// By email = By.id("input-email");

		String email = "input-email";
		String password = "input-password";
		String loginButton = "//input[@value='Login']";

		
//		By emailId = getBy("id", email);
//		//getElement(emailId).sendKeys("naveen@gmail.com");
//		doSendKeys(emailId, "naveen@gmail.com");
		
		doSendKeys("id", email, "naveen@gmail.com");
		doSendKeys("id", password, "test@123");
		doClick("Xpath", loginButton);
		
	}

	public static By getBy(String locatorType, String locatorValue) {
		System.out.println("type: " + locatorType + "  and " + " value : " + locatorValue);
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("please pass the right locator type.....");
			break;
		}

		return locator;

	}

	public static void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
