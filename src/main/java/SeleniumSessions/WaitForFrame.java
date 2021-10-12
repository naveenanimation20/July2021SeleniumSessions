package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {
	
	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//waitForFrameUsingIDOrName("main", 5);
		By frameLocator = By.name("main");
		waitForFrameUsingByLocator(frameLocator, 5);
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent();
		
		
	}
	
	public static void waitForFrameUsingIDOrName(String frameIDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));
	}
	
	public static void waitForFrameUsingIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameUsingByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameUsingWebElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	
	
	
	

}
