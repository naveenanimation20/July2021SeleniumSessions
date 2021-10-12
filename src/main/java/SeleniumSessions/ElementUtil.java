package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDiplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public boolean doIsSelected(By locator) {
		return getElement(locator).isSelected();
	}

	public boolean checkElementDisabled(By locator, String attrName) {
		String attrValue = getElement(locator).getAttribute(attrName);
		if (attrValue.equals("true")) {
			return true;
		}
		return false;
	}

	public String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public void doLinkClick(By locator, String linkValue) {
		List<WebElement> linksList = getElements(locator);
		System.out.println(linksList.size());
		for (WebElement e : linksList) {
			String text = e.getText();
			System.out.println(text);
			if (text.trim().equals(linkValue)) {
				e.click();
				break;
			}
		}
	}

	public boolean checkElementDisplayed(By locator) {
		if (getElements(locator).size() == 1)
			return true;
		return false;
	}

	public boolean checkElementDisplayed(By locator, int eleOccurrence) {
		if (getElements(locator).size() == eleOccurrence)
			return true;
		return false;
	}

	/************************************
	 * drop down utils
	 **************************/
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public boolean doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
		return isDropDownValueSelected(select, text);
	}

	public boolean doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		return isDropDownValueSelected(select, value);

	}

	public boolean isDropDownValueSelected(Select select, String expValue) {
		if (select.getFirstSelectedOption().getText().contains(expValue)) {
			System.out.println(expValue + ": is selected");
			return true;
		}
		return false;
	}

	public void doSelectDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		iterateDropDownAndSelect(optionsList, value);
	}

	public void selectDropDownWithoutSelect(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		iterateDropDownAndSelect(optionsList, value);

	}

	private void iterateDropDownAndSelect(List<WebElement> optionsList, String value) {
		System.out.println("total options: " + optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	/*************************** Actions class Utils *********************/
	public void parentChildMenuHandle(By parent, By child) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parent)).build().perform();
		Thread.sleep(2000);
		doClick(child);
	}

	public int rightClickItemsCount(By rightClick, By items) {
		return getRightClickList(rightClick, items).size();
	}

	public void clickOnRightClickItem(By rightClick, By items, String value) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).perform();
		List<WebElement> menuList = getElements(items);
		for (WebElement e : menuList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	/**
	 * 
	 * @param rightClick
	 * @param items
	 * @return
	 */
	public List<String> getRightClickList(By rightClick, By items) {
		List<String> itemValueList = new ArrayList<String>();
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).perform();
		List<WebElement> menuList = getElements(items);
		System.out.println(menuList.size());

		for (WebElement e : menuList) {
			String text = e.getText();
			System.out.println(text);
			itemValueList.add(text);
		}
		return itemValueList;
	}

	/***********************************
	 * wait utils
	 *********************************/

	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	public String alertGetText(int timeOut) {
		Alert alert = waitForJSAlert(timeOut);
		String text = alert.getText();
		alert.accept();
		return text;
	}

	public void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}

	public boolean waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public boolean waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(urlValue));
	}

	public String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}

	public String waitForTitleToBe(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

	public void waitForFrameUsingIDOrName(String frameIDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));
	}

	public void waitForFrameUsingIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameUsingByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameUsingWebElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public List<String> getElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsPresence(locator, timeOut);
		List<String> eleValList = new ArrayList<String>();
		for (WebElement e : eleList) {
			eleValList.add(e.getText());
		}
		return eleValList;
	}

	public void printElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsPresence(locator, timeOut);
		for (WebElement e : eleList) {
			System.out.println(e.getText());
		}
	}

	public List<String> getVisibleElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsVisible(locator, timeOut);
		List<String> eleValList = new ArrayList<String>();
		for (WebElement e : eleList) {
			eleValList.add(e.getText());
		}
		return eleValList;
	}

	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresent(By locator, long timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator, int timeOut) {
		waitForElementToClickable(locator, timeOut).click();
	}

	public WebElement waitForElementPresenceWithWebDriverWait(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.withMessage(Error.TIME_OUT_WEB_ELEMENT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresenceWithFluetWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_WEB_ELEMENT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public Alert waitForAlertPresenceWithFluetWait(int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_ALERT_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebDriver waitForFramePresenceWithFluetWait(By frameLocator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.withMessage(Error.TIME_OUT_FRAME_MESG).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchFrameException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	/*********** custom wait util *************/
	public WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ": " + locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println(
						"Element is not found exception...tried for : " + timeOut + " with interval time of 500 ms");
			}
		}

		return element;

	}

	public WebElement retryingElement(By locator, int timeOut, int pollingTime) {

		WebElement element = null;
		int attempts = 0;
		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + ": " + locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;
		}

		return element;

	}

}
