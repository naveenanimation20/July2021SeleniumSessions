package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//imp wait: applied on webdriver ref
		//dynamic wait
		//its only applicable for web elements (not applicable for non webelements: url, title, alert)
		//is a global wait -- it will be applied on all the web elements by default
		
		//timeout -- 10 secs --> selenium is going to wait untill 10 secs, if the element is still
		//not present on the page, then sel will throw exception: NoSuchElementException
		//if element is found within 5 secs --> rest of the 5 secs will be ignored
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demoauto.xyz/signin");
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		//login page: 10 secs
		jsUtil.flash(driver.findElement(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("admin02@mailinator.com");
		
		jsUtil.flash(driver.findElement(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("123456");
		
		jsUtil.flash(driver.findElement(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//home page: 20 secs
		driver.findElement(By.xpath("//span[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@title='Add lead']")).click();
		
		//lead page: 5 secs
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("company_name")).sendKeys("IBM");
		
		//logout:
		//login page: 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//e..e..e...e...e...e...e --> 10 secs
		
		
	}

}
