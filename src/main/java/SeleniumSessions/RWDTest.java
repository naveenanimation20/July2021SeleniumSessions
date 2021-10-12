package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//sel 3
public class RWDTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("naveen");
		driver.findElementByName("q").sendKeys("automation");
		
//		WebDriver driver1 = new ChromeDriver();
//		driver1.get("http://www.google.com");
		
		
		
	}

}
