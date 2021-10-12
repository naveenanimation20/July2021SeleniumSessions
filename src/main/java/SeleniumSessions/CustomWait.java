package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demoauto.xyz/signin");

		driver.findElement(By.id("email")).sendKeys("admin02@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		By leads = By.xpath("//span[text()='Leads11']");
		By addLead = By.xpath("//a[@title='Add lead']");
		By compName = By.id("company_name11");

		retryingElement(leads, 10).click();
//		retryingElement(addLead, 5).click();
//		retryingElement(compName, 10, 2000).sendKeys("IBM");

	}

	public static WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ": " + locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println(
						"Element is not found exception...tried for : " + timeOut + " with interval time of 500 ms");
			}
		}

		return element;

	}

	public static WebElement retryingElement(By locator, int timeOut, int pollingTime) {

		WebElement element = null;
		int attempts = 0;
		while (attempts < timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ": " + locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}

		return element;

	}

}
