package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		br.initDriver("chrome");
		
		br.lauchUrl("https://www.amazon.com");
		
		String title = br.getPageTitle();
		System.out.println(title);

		System.out.println(br.getPageUrl());

		br.quitBrowser();

	}

}
