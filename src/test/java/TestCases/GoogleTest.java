package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
	}

	@Test(priority = 2)
	public void searchTest() {
		Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}

}
