package SeleniumSessions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.noon.com/uae-en/");
		Thread.sleep(7000);		
		getCarouselItems("Top picks in laptops & monitors");
		
		
	}
	
	public static void getCarouselItems(String sectionName) {
		String xpath = "//h3[text()='"+sectionName+"']//parent::div//following-sibling::div//div[@data-qa='product-name']";
		String nextXpath = "//h3[text()='"+sectionName+"']//parent::div//following-sibling::div//div[contains(@class,'swiper-button-next')]";
		
		List<WebElement> recommList = driver.findElements(By.xpath(xpath));
		System.out.println(recommList.size());
		Set<String> prodList = new TreeSet<String>();
		while(!driver.findElement(By.xpath(nextXpath)).getAttribute("class").contains("swiper-button-disabled")) {
			//logic for next button
			for(WebElement e : recommList) {
				String text = e.getText();
					if(!text.isEmpty()) {
						prodList.add(text);
					}
			}
			//click on next:
			driver.findElement(By.xpath(nextXpath)).click();
			recommList = driver.findElements(By.xpath(xpath));
		}
		
		//traverse the prod list:
		for(String e : prodList) {
			System.out.println(e);
		}
	}
	

}
