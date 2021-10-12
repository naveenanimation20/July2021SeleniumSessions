package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopUpHandle {

	//JS alert
	//Modal Dialogue pop up
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.findElement(By.name("proceed")).click();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		alert.sendKeys("this is my alert testing");
		Thread.sleep(5000);
		alert.accept();//click on ok
		//alert.dismiss(); //cancel the alert
		
		driver.switchTo().defaultContent();
		
	}

}
