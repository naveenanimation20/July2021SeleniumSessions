package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpWaitForListElements {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");
		
		
		By footerList = By.xpath("//ul[@class='footer-nav']//a");
//		List<WebElement> footerEleList = waitForElementsPresence(footerList, 5);
//		
//		for(WebElement e : footerEleList) {
//			System.out.println(e.getText());
//		}
		printElementsTextList(footerList, 5);
		
		
		//webdriverwait --> FluentWait --> Wait (I)
	}
	
	
	public static List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	public static List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public static List<String> getElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsPresence(locator, timeOut);
		List<String> eleValList = new ArrayList<String>();
		for(WebElement e : eleList) {
			eleValList.add(e.getText());
		}
		return eleValList;
	}
	
	public static void printElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsPresence(locator, timeOut);
		for(WebElement e : eleList) {
			System.out.println(e.getText());
		}
	}
	
	
	
	
	

}
