package SeleniumSessions;

import org.openqa.selenium.By;

public class CustomXpath_1 {

	public static void main(String[] args) {

		
		//xpath: locator not an attribute
		//address of the element
		//1. absolute xpath : /html/body/div[2]/div[1]/ul/li[2]/a
		//2. relative xpath (custom xpath)
		
		//htmltag[@attr='value']
		//input[@name='email']
		//input[@id='input-email'] -- 1
		//*[@id='input-email'] -- 1
		//500 -- 100 inputs
		
		//htmltag[@attr1='value' and @attr2='value']
		//input[@type='text' and @name='email']
		//input[@type='text' and @name='email' and @id='input-email']
		//input[@type='text' and @name='email' and @id]
		//input[@type='text' and @name and @id]
		//input[@type and @name and @id]
		//input --6
		
		//index in xpath:
		// (//input[@type='text'])[1]
		// (//input[@type='text'])[position()=1]
		By.xpath("(//input[@type='text'])[1]");
		
		// (//input[@class='form-control'])[last()]
		// (//input[@class='form-control'])[last()-1]
		
		//dynamic attr:
		//<input id=test_123/>
		//<input id=test_456/>
		//<input id=test_890/>
		//input[starts-with(@id,'test_')]
		//input[contains(@id,'_')]

		
		//contains function:
		//used for dynamic elements: dynamic attributes
		
		//htmltag[contains(@id,'value')]
		//input[contains(@id,'input-email')]
		// input-email
		// login-email 
		//input[contains(@name,'em')]
		
		//htmltag[contains(@attr1,'value') and @attr2='value']
		//input[contains(@id,'email') and @name='email' and contains(@placeholder,'E-Mail')]
		//input[contains(@id,'email') and contains(@placeholder,'E-Mail')]
		
		//text(): links, labels, span, div, header
		//htmltag[text()='value']
		
		//h2[text()='Delight your customers']
		//a[text()='Recurring payments']
		//h3[text()='Import & Export']
		// (//a[text()='Forgotten Password'])[position()=2]
		
		//contains() with text():
		//h2[contains(text(),'Delight your')]
		
		//contains() with text() and attr:
		//htmltag[contains(text(),'value') and @attr='value']
		//a[contains(text(),'Login') and @class='list-group-item']
		//a[contains(text(),'Login') and @class='list-group-item' and contains(@href,'account/login')]

		//a[text()='Login' and @class='list-group-item' and contains(@href,'account/login')]
		
		
		//form-control private-form__control login-email
		By.xpath("//input[@class='form-control private-form__control login-email']");//right
		By.className("form-control private-form__control login-email");//wrong
		By.className("login-email");//right
		By.cssSelector(".form-control.private-form__control.login-email");//right
		//.c1.c2.c3.c4.....c100
		
		//parent to direct child: /
		//div[@class='form-group']/input[@name='email'] -- direct child
		//div[@class='form-group']//input[@name='email'] --direct + indirect child
		
		//div[@class='form-group']/child::input[@name='email']
		
		//child to parent:
		//input[@name='email']/../../../../../../../../../..
		//input[@name='email']/..
		//input[@name='email']/parent::div
		
		//input[@name='email']/parent::div/parent::form
		//input[@name='email']/../parent::form
		
		//input[@name='email']/ancestor::div
		//input[@name='email']/ancestor::form
		
		//sibling:
		//input[@name='email']/preceding-sibling::label
		//label[@for='input-email']/following-sibling::input
		
		//label[@for='input-email']/../input
		//label[@for='input-email']/parent::div/child::input
		
		//a[text()='Harshitha Deepak']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//a[text()='Indra Nanj']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		//a[text()='Indra Nanj']/parent::td/following-sibling::td/a[@context='company']
		
		
		//SVG Elements
		//Shadow-Dom
		//Pesudo Elements -- :: before and ::after
		
		
		
		
	}

}
