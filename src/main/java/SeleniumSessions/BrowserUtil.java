package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class BrowserUtil {

	public WebDriver driver;

	/**
	 * This method is used to init the driver on the basis of given browser name
	 * @param browserName
	 * @return it return the driver
	 */
	public WebDriver initDriver(String browserName) {

		System.out.println("browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("please pass the right browser..." + browserName);
		}

		return driver;
	}

	public void lauchUrl(String url) {
		if (url == null || url.isEmpty()) {
			System.out.println("url is incorrect");
			return;
		}
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
