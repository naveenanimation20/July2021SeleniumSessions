package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class ClickEventCheck {

	static WebDriver driver;

	public static boolean isClickEvent(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("var ele = arguments[0];ele.addEventListener('click', function() {ele.setAttribute('customclickevent','true');});",element);
		element.click();
		String eventAttribute = element.getAttribute("customclickevent");
		return Boolean.parseBoolean(eventAttribute);
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		WebElement pricing = driver.findElement(By.linkText("Pricing"));
			if(isClickEvent(pricing)) {
				System.out.println("successfully clicked on pricing element");
			}

	}

}
