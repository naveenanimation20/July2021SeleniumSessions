package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		//win:
		//System.setProperty("webdriver.chrome.driver", "c:\\users\\documents\\driver\\chromedriver.exe");
		
		//mac
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//launch browser
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
