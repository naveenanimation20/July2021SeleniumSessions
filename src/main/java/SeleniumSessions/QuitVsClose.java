package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();// launch browser
		driver.get("http://www.google.com");// enter url

		String title = driver.getTitle();// get the page title
		System.out.println("page title : " + title);

		System.out.println(driver.getCurrentUrl());//get url

		driver.quit();// close the browser
		//driver.close();// close the browser//123
		
		driver = new ChromeDriver();//launch the browser//456
		driver.get("http://www.google.com");
		title = driver.getTitle();// get the page title
		//Quit: NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		//close: NoSuchSessionException: invalid session id
		System.out.println("page title : " + title);
		

	}

}
