package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithoutSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.xpath("//select[@id='Form_submitForm_Country']/option");
		selectDropDownWithoutSelect(country, "India");
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void selectDropDownWithoutSelect(By locator, String value) {

		List<WebElement> optionsList = getElements(locator);

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}

}
