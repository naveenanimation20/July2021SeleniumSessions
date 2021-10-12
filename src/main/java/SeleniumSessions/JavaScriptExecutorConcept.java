package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		System.out.println(jsUtil.getTitleByJS());
		
//		System.out.println(jsUtil.getPageInnerText());
//		
//		if(jsUtil.getPageInnerText().contains("Deal Pipeline")) {
//			System.out.println("PASS");
//		}
		
		//jsUtil.generateAlert("this is crm pro alert");
		
		//jsUtil.refreshBrowserByJS();
//		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
//		WebElement loginForm = driver.findElement(By.id("loginForm"));
		//jsUtil.drawBorder(loginForm);
		
//		jsUtil.flash(login);
//		jsUtil.flash(loginForm);
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(3000);
//		jsUtil.scrollPageUp();
		
		//WebElement pricing = driver.findElement(By.xpath("//span[text()='See pricing']"));
//		WebElement section = driver.findElement(By.xpath("//span[contains(text(),'Bestselling glassware and drinkware')]"));
//		jsUtil.scrollIntoView(section);
		
		WebElement bestSeller = driver.findElement(By.linkText("Best Sellers"));
		jsUtil.clickElementByJS(bestSeller);

		
	}

}
