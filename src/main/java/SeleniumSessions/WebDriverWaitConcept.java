package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static RemoteWebDriver driver;

	public static void main(String[] args) {

		// exp wait:
		//custom wait -- can be applied for a specific element on the basis of some exp conditions
		//isPresent, isVisible, isClickable, 
		//its not a global wait
		//can be used for non web elements: frames, alerts, url, titles
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoauto.xyz/signin");

		driver.findElement(By.id("email")).sendKeys("admin02@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@title='Add lead']")).click();
				
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement compName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("company_name")));
//		compName.sendKeys("IBM");
//		
//		WebElement vatNum = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vat_number")));
//		vatNum.sendKeys("123456");
		By comp = By.id("company_name11");
		By vatNum = By.id("vat_number");
		
		waitForElementPresent(comp, 10, 2000).sendKeys("IBM");
		waitForElementPresent(vatNum, 5).sendKeys("12345");
	}
	
	
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementPresent(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
}
