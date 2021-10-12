package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://books-pwakit.appspot.com/");
		
		//driver.findElement(By.id("input")).sendKeys("naveen");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement input = (WebElement)(js.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")"));
		input.sendKeys("naveen");
		
	}

}
