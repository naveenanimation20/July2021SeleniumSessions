package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		
		WebDriver driver = br.initDriver("chrome");
		br.lauchUrl("https://demo.opencart.com/index.php?route=account/login");
		
		System.out.println(br.getPageTitle());
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);

		jsUtil.flash(eleUtil.getElement(emailId));
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		
		jsUtil.flash(eleUtil.getElement(password));
		eleUtil.doSendKeys(password, "naveen@123");
		
		//br.quitBrowser();
		
	}

}
