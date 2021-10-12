package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		String username = "admin";
		String password = "admin";
		
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");

		//CDP - later
		
	}

}
