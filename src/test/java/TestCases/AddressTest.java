package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRUD.Address;
import CRUD.AddressImp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddressTest {
	WebDriver driver;
	AddressImp addressImp;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://a.testaddressbook.com/sign_in");
		driver.findElement(By.id("session_email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("session_password")).sendKeys("Test@12345");
		driver.findElement(By.name("commit")).click();
		addressImp = new AddressImp(driver);
	}
	
	
	@Test
	public void createAddressTest() {
		Address address = new Address("money", "heist", "madrid", "bala cio", "321234");
		Assert.assertTrue(addressImp.addAddress(address));
	}
	
	@Test
	public void updateAddressTest() {
		Address address = new Address("BBT", "season11", "USA", "NY", "909090");
		addressImp.addAddress(address);
		address.setLastName("Theory");
		address.setCity("LAA");;
		addressImp.updateAddress(address, address.getFirstName());
		
	}
	
	@Test
	public void deleteAddressTest() {
		Address address = new Address("TWD", "dead", "US", "LA", "808080");
		addressImp.addAddress(address);
		addressImp.deleteAddress(address.getFirstName());
	}
	
	@Test
	public void deleteExistingAddressTest() {
		addressImp.deleteAddress("BBTBBT");
	}
	
	

}
