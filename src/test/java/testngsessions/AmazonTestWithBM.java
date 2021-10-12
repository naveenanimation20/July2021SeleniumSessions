package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestWithBM {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com");
	}

	@Test
	public void titleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}

	@Test
	public void searchTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
