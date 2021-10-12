package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest{

	@Test(priority = 2)
	public void titleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}

	@Test(priority = 3)
	public void searchTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

	@Test(priority = 1)
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
	}
	
	

}
