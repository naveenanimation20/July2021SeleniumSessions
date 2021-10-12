package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAttribute {
	
	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.freecrm.com/register/");
		
		String attrVal = driver.findElement(By.name("first_name")).getAttribute("type");
		System.out.println(attrVal);
		
//		String disableVal = driver.findElement(By.id("submitButton")).getAttribute("disabled");
//		System.out.println(disableVal);
//		if(disableVal.equals("true")) {
//			System.out.println("element is disabled");
//		}
		By submitBtn = By.id("submitButton");
		System.out.println(checkElementDisabled(submitBtn, "disabled"));
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public static boolean checkElementDisabled(By locator, String attrName) {
		String attrValue = doGetAttributeValue(locator, attrName);
		if(attrValue.equals("true")) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	

}
