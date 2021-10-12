package SeleniumSessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {

		
		//headless --> (CH/FF/EDGE)browser options --> it will not launch the browser, but it will block the visibility(display)
		//GhostDriver + PhantomJS --> headless ---> html page source of the application
		//HtmlUnitDriver --> headless --> html page source of the application
		
		//testing is happening behind the scene
		//faster than the UI mode
		//headless is not recommended for complex applications//pop ups/mouse movement
		//recommended for sanity test cases(15-20 tcs)
		
		//headless -- non ui mode
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");	
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		WebDriver driver = new FirefoxDriver(fo);
		
		driver.get("http://www.facebook.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//driver.quit();
		
		//SearchContext dr = new ChromeDriver();//valid -- but Not recomm
		
		//RemoteWebDriver dr = new ChromeDriver();//valid
		
		//ChromeDriver dr = new ChromeDriver();//valid -- only for chrome
		
		//SearchContext dr = new RemoteWebDriver();//valid -- but Not recomm
		
		
		
	}

}
