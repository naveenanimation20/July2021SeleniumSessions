package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	static WebDriver driver;

	public static void main(String[] args) {

		// 1. ID : is a unique locator (static) --I --dynamic ids: firstname_455
		// 2. name : duplicate --II

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");
		
		//driver.findElement(By.name("firstname")).sendKeys("naveen");

//		By fn = By.name("firstname");
//		By ln = By.id("input-lastname");
//		//driver.findElement(fn).sendKeys("naveen");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(fn, "Tom");
//		eleUtil.doSendKeys(ln, "peter");

		//3. className: duplicate -- IV
		//driver.findElement(By.className("form-control")).sendKeys("naveen");
		
		//4. xpath: is not attribute -- is locator -- address of the element inside the DOM -- III
		
		//driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("naveen");
		
		//5. css Selector: is not attribute -- is locator -- III
		//CSS: Cascaded Style sheet
		//driver.findElement(By.cssSelector("#input-firstname")).sendKeys("naveen");
		
		//6. linkText: only for links --> html tag : <a> --anchor tag
		//driver.findElement(By.linkText("Login")).click();
		
		//7. partialLinkText: only for links --> html tag : <a> --anchor tag -- Not Recommended
		//driver.findElement(By.partialLinkText("Delivery")).click();
		
		//Delivery Process
		//Delivery Test
		//Delivery Information
		
		//8. tagName:
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
		By customers = By.linkText("Customers");
		By header = By.tagName("h2");
		
		String headerText = doGetText(header);
		System.out.println(headerText);
		
		doClick(customers);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	
	

}
