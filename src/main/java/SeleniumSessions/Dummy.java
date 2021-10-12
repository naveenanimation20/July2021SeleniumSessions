package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demoauto.xyz/signin");

		driver.findElement(By.id("email")).sendKeys("admin02@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//span[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@title='Add lead']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company_name"))).sendKeys("NAL");
		//driver.findElement(By.id("company_name")).sendKeys("NAL");
		
	}

}
