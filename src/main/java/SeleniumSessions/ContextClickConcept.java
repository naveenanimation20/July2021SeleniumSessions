package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		By rightClick = By.xpath("//span[text()='right click me']");
		By items = By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");

//		List<String> actList = getRightClickList(rightClick, items);
//		if(actList.contains("Copy")) {
//			System.out.println("copy is present");
//		}
		

//		if(rightClickItemsCount(rightClick, items) == 6) {
//			System.out.println("count is correct");
//		}

		clickOnRightClickItem(rightClick, items, "Quit");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int rightClickItemsCount(By rightClick, By items) {
		return getRightClickList(rightClick, items).size();
	}

	public static void clickOnRightClickItem(By rightClick, By items, String value) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).perform();
		List<WebElement> menuList = getElements(items);
		for (WebElement e : menuList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	public static List<String> getRightClickList(By rightClick, By items) {
		List<String> itemValueList = new ArrayList<String>();

		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).perform();
		List<WebElement> menuList = getElements(items);
		System.out.println(menuList.size());

		for (WebElement e : menuList) {
			String text = e.getText();
			// System.out.println(text);
			itemValueList.add(text);
		}

		return itemValueList;

	}

}
