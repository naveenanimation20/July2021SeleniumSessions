package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggesListWithXpath {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/");
		
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[contains(text(),'Casual Dresses > Printed')]")).click();
		

	}

}
