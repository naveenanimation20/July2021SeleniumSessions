package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		
		//CSSSelector: its a locator, not an attribute
		
		//id: #{id}
		// #input-email
		//class: .className
		// .form-control
		By.cssSelector("#input-email");
		By.cssSelector(".form-control");
		
		//#{id}.{className}
		// #input-email.form-control
		// .form-control#input-email
		
		//.c1.c2.c3.....cn
		//.form-control.private-form__control.login-email
		//#{id}.c1.c2.c3
		// #username.form-control.private-form__control.login-email
		// .form-control.private-form__control.login-email#username
		
		// htmltag#id
		// input#username
		// htmltag.className
		// input.form-control.private-form__control.login-email
		
		By.xpath("//input[@class='form-control private-form__control login-email']");//right
		By.className("form-control private-form__control login-email");//wrong
		By.className("login-email");//right
		By.cssSelector(".form-control.private-form__control.login-email");//right
		
		// htmltag[attr='value']
		// input[value='Login'] --css
		//input[@value='Login'] --xpath
		
		// input[value='Login'][type='submit']
		By.cssSelector("input[value='Login'][type='submit']");
		
		// input[id*='email'] -- contains
		// input[value*='Login'][type='submit']
		// input[id^='input'] -- starts-with
		// input[id$='email'] -- ends-with
		
		//parent to child:
		//space bw parent and child (direct + indirect)
		// > bw parent and child (only direct child)
		
		// div.private-form__input-wrapper > input
		// div.private-form__input-wrapper input
		
		// form#hs-login > div -- 8 (only direct child)
		// form#hs-login div -- 20 (direct + indirect)
		
		// div.private-form__input-wrapper > input#password
		
		//child to parent: not allowed (backward traversing not allowed)
		
		//comma in css:
		// input#username,input#password, button#loginBtn, input#remember, a.google-sign-in
		int impEleCount = driver.findElements
								(By.cssSelector("input#username,input#password, "
											+ "button#loginBtn, input#remember, a.google-sign-in")).size();
		
		if(impEleCount == 4) {
			System.out.println("mandatory fields/elements are present on the page");
		}
		
		//sibling in css:
		//following-sibling: yes
		// div.private-form__input-wrapper + div
		//preceding-sibling: no
		
		// ul.footer-nav li a
		// ul.footer-nav a
		
		//nth-of-type: for indexing:
		// ul.footer-nav li:nth-of-type(4) a
		// footer ul.list-unstyled li:nth-of-type(1)
		
		          //xpath      vs       css
//1. syntax: 	  complex					simple
//2. functions:   better					limited
//3. backward: 	  possible					NA	
//4. performance:  good						good
		
		//IE:
		// 500 locators -- xpath (1 hr ~ 60 mins)
		// 500 locators -- css (50 mins)
		
		//Chrome//FF
		// 500 locators -- xpath (50 mins)
		// 500 locators -- css (55 mins)
		
		//Safari:
		// 500 locators -- xpath (50 mins)
		// 500 locators -- css (60 mins)
		
//5. webtable: 	much better				limited options
//6. dynamic attr:  good 				good
//7. element text:  Available			NA
//8. diff tags:     NA					comma feature		
		
		
	}

}
