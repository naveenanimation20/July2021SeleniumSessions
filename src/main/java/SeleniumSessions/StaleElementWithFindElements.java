package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithFindElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");//v1
		
		List<WebElement> footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));//v1
		
		System.out.println(footerList.size());//v1
		
//		for(WebElement e : footerList) {    //v1-->v2
//			System.out.println(e.getText());
//			e.click();
//			//v2 --> V3
//			//driver.navigate().back();
//			footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));//v2 --> v3
//		}
		
		for(int i=0; i<footerList.size(); i++) {
			footerList.get(i).click();
			driver.navigate().back();
			footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
		}
		
		//refresh
		//back/forward
		//click on link -- page is refreshed -- dom is updated
		
		
		
	}

}
