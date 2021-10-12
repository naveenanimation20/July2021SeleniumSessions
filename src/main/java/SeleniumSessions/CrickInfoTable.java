package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrickInfoTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get(
				"https://www.espncricinfo.com/series/new-zealand-in-bangladesh-2021-1272089/bangladesh-vs-new-zealand-4th-t20i-1272096/full-scorecard");

		System.out.println(getWicketTakerName("Finn Allen"));
		
		System.out.println(getBatsManScoreList("Finn Allen"));
		System.out.println(getBatsManScoreList("Will Young"));

	}

	public static String getWicketTakerName(String batsmanName) {
		String wckTakerXpath = "//a[text()='" + batsmanName + "']/parent::td/following-sibling::td/span";
		return driver.findElement(By.xpath(wckTakerXpath)).getText();
	}
	
	public static List<String> getBatsManScoreList(String batsmanName) {
		String scoreXpath = "//a[text()='"+batsmanName+"']/parent::td/following-sibling::td";
		List<WebElement> scoreList = driver.findElements(By.xpath(scoreXpath));
		List<String> scoreValList = new ArrayList<String>();
		for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scoreValList.add(text);
		}
		return scoreValList;
	}

}
