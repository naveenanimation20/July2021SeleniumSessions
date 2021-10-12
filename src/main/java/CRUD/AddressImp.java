package CRUD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressImp {
	
	private WebDriver driver;
	
	public AddressImp(WebDriver driver) {
		this.driver = driver;
	}

	public boolean addAddress(Address address) {
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.linkText("New Address")).click();
		driver.findElement(By.id("address_first_name")).sendKeys(address.getFirstName());
		driver.findElement(By.id("address_last_name")).sendKeys(address.getLastName());
		driver.findElement(By.id("address_street_address")).sendKeys(address.getAddress1());
		driver.findElement(By.id("address_city")).sendKeys(address.getCity());
		driver.findElement(By.id("address_zip_code")).sendKeys(address.getZipCode());
		driver.findElement(By.name("commit")).click();
		return driver.findElement(By.cssSelector("div.alert.alert-notice")).isDisplayed();
	}

	public void getAddress(Address address) {
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//td[text()='"+address.getFirstName()+"']")).isDisplayed();
	}

	public boolean updateAddress(Address address, String firstName) {
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//td[text()='"+firstName+"']//following-sibling::td/a[text()='Edit']")).click();
		driver.findElement(By.id("address_first_name")).sendKeys(address.getFirstName());
		driver.findElement(By.id("address_last_name")).sendKeys(address.getLastName());
		driver.findElement(By.id("address_street_address")).sendKeys(address.getAddress1());
		driver.findElement(By.id("address_city")).sendKeys(address.getCity());
		driver.findElement(By.id("address_zip_code")).sendKeys(address.getZipCode());
		driver.findElement(By.name("commit")).click();
		return driver.findElement(By.cssSelector("div.alert.alert-notice")).isDisplayed();
	}

	public boolean deleteAddress(String firstName) {
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//td[text()='"+firstName+"']//following-sibling::td/a[text()='Destroy']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		return driver.findElement(By.cssSelector("div.alert.alert-notice")).isDisplayed();

	}
	

}
