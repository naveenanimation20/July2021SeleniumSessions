package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCrmFrameHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.verboseLogging", "true");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();

		
	}

}
