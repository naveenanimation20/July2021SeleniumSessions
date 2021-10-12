package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectHtmlTagDropDown {

	static WebDriver driver;

	public static void main(String[] args) {

		// html tag : <select>
		// use Select class in selenium

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//		
//		Select select = new Select(country);
//		//select.selectByIndex(5);
//		select.selectByVisibleText("India");	
//		String text = select.getFirstSelectedOption().getText();
//		System.out.println(text);

//		//select.selectByValue("Bhutan");

		By country = By.id("Form_submitForm_Country");
		doSelectByVisibleText(country, "India23");

		// doSelectByIndex(country, 5);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public static boolean doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
		return isDropDownValueSelected(select, text);
	}

	public static boolean doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		return isDropDownValueSelected(select, value);

	}

	public static boolean isDropDownValueSelected(Select select, String expValue) {
		if (select.getFirstSelectedOption().getText().equals(expValue)) {
			System.out.println(expValue + ": is selected");
			return true;
		}
		return false;
	}

}
