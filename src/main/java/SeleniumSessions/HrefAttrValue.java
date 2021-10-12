package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HrefAttrValue {

	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		String url = driver.findElement(By.linkText("About Us")).getAttribute("href");
		System.out.println(url);
		
		String srcValue = driver
			.findElement(By.xpath("//img[@alt='SYANKA Glass Wine Glass - Set Of 4, Clear, 360ml']"))
					.getAttribute("src");
		System.out.println(srcValue);
		
		
		
	}

}
