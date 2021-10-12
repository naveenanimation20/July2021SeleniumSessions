package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();//launch browser
		
		driver.get("http://www.google.com");//enter url
		
		String title = driver.getTitle();//get the page title
		System.out.println("page title : " + title);
		
		//verfication point/checkpoint: act vs exp result
		if(title.equals("Google")) {
			System.out.println("title is correct");
		}
		else {
			System.out.println("wrong title");
		}
		//Automation Steps + verification point--> Automation Test (testing)
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getPageSource().contains("Copyright"));
		
		//driver.quit();//close the browser
		driver.close();//close the browser

		
		
		
	}

}
