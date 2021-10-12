package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By choices = By.xpath("//span[@class='comboTreeItemTitle']");

		// TC_01: single selection
		 selectChoice(choices, "choice 1");

		// TC_02: multi selection
		// selectChoice(choices, "choice 1", "choice 2", "choice 2 3", "choice 7");

		// TC_03: All selection:
		selectChoice(choices, "all");
	}

	/**
	 * This method is used to select the choices from the drop down and handling al three use cases:
	 * 1. single
	 * 2. Multi 
	 * 3. all (please pass the value as all/All/ALL)
	 * @param locator
	 * @param value
	 */
	public static void selectChoice(By locator, String... value) {

		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("All")) {

			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}
				}
			}
		} else {
			// select all choices:
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {
				System.out.println("all choices are selected....");
			}
		}

	}

}
