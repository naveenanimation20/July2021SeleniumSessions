package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllValues {

	static WebDriver driver;

	public static void main(String[] args) {

		// html tag : <select>
		// use Select class in selenium

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By coutry = By.id("Form_submitForm_Country");
		doSelectDropDown(coutry, "Turkey");

//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//		
//		Select select = new Select(country);
//		List<WebElement> optionsList = select.getOptions();
//		System.out.println("total options: "+ optionsList.size());
//		
////		for(int i=0; i<optionsList.size(); i++) {
////			String text = optionsList.get(i).getText();
////			System.out.println(text);
////		}
//		
//		for(WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//				if(text.equals("Venezuela")) {
//					e.click();
//					break;
//				}
//		}
		
 
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("total options: "+ optionsList.size());
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals(value)) {
					e.click();
					break;
				}
		}
	}
	
	
	
	

}
