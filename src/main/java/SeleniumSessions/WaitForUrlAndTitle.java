package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlAndTitle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		String title = waitForTitleContains(5, "Login");
		System.out.println(title);
		
		driver.findElement(By.linkText("Register")).click();
		
		title = waitForTitleContains(5, "Register");
		System.out.println(title);
		
		
		
		if(waitForUrlContains("route=account/register", 5)) {
			System.out.println("register url is correct");
		}
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		if(wait.until(ExpectedConditions.urlContains("route=account/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}
//		
//		if(wait.until(ExpectedConditions.urlToBe("https://demo.opencart.com/index.php?route=account/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}		
	}
	
	public static String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static String waitForTitleToBe(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

	public static boolean waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public static boolean waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(urlValue));
	}
	
	
	
	
	
	
}
