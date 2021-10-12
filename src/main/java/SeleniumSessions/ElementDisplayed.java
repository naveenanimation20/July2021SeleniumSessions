package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementDisplayed {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();

		WebDriver driver = br.initDriver("chrome");
		br.lauchUrl("https://classic.freecrm.com/register/");
//		
//		boolean flag = driver.findElement(By.id("input-email")).isDisplayed();
//		System.out.println(flag);
//		
//		driver.findElement(By.name("search")).isEnabled();
		
		WebElement submit = driver.findElement(By.id("submitButton"));
		
		System.out.println(submit.isDisplayed());
		System.out.println(submit.isEnabled());
		
		WebElement agreechk = driver.findElement(By.name("agreeTerms"));
		System.out.println(agreechk.isSelected());
		agreechk.click();
		System.out.println(agreechk.isSelected());
		System.out.println(submit.isEnabled());
		System.out.println(submit.isDisplayed());


	}

}
