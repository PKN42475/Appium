package GenericUtility;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;

public class MobileUtility {

	public AppiumDriver<MobileElement> driver;
//	public MobileUtility (AndroidDriver driver) {
//		this.driver = driver;
//	}

	//Tap to an element for 250 milliseconds
	public void tapByElement(AndroidDriver driver, AndroidElement androidElement) {
		new TouchAction(driver)
		.tap(TapOptions.tapOptions().withElement(element(androidElement)))
		.waitAction(waitOptions(ofMillis(250))).perform();
	}

	//Tap By Coordinates
	public void tapByCoordinates(int x, int y) {
		new TouchAction(driver)
		.tap(point(x,y))
		.waitAction(waitOptions(ofMillis(250))).perform();
	}

	//Press By Element
	public void pressByElement(AndroidDriver driver, AndroidElement element, long seconds) {
		new TouchAction(driver)
		.press(element(element))
		.waitAction(waitOptions(ofSeconds(seconds)))
		.release()
		.perform();
	}

	//Horizontal Swipe by percentages
	public void horizontalSwipeByPercentage(AndroidDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height*anchorPercentage);
		int startPoint = (int) (size.width*startPercentage);
		int endPoint = (int) (size.width*endPercentage);

		new TouchAction(driver)
		.press(point(startPoint, anchor))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endPoint, anchor))
		.release().perform();
	}

	//Vertical Swipe by percentages
	public void verticallSwipeByPercentage(AppiumDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width*anchorPercentage);
		int startPoint = (int) (size.height*startPercentage);
		int endPoint = (int) (size.height*endPercentage);

		new TouchAction(driver)
		.press(point(anchor, startPoint))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(anchor, endPoint))
		.release().perform();
	}

	//swipe By Elements
	public void swipeByElements(AndroidDriver driver, AndroidElement startELement, AndroidElement endELement) {
		int startX = startELement.getLocation().getX() + (startELement.getSize().getWidth()/2);
		int startY = startELement.getLocation().getY() + (startELement.getSize().getHeight()/2);
		int endX = endELement.getLocation().getX() + (endELement.getSize().getWidth()/2);
		int endY = endELement.getLocation().getY() + (endELement.getSize().getHeight()/2);
		new TouchAction(driver)
		.press(point(startX, startY))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endX, endY))
		.release().perform();
	}

	//multiTouch Action By Using an Android Element
	public void multiTouchByElement(AndroidDriver driver, AndroidElement androidElement) {
		TouchAction press = new TouchAction(driver)
				.press(element(androidElement))
				.waitAction(waitOptions(ofSeconds(1)))
				.release();
		new MultiTouchAction(driver)
		.add(press)
		.perform();
	}

	//Scroll To Element
	public void scrollToElement(AndroidDriver driver, String an, String av) {
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}

	//Scroll Forward
	public void scrollForward() {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		}
		catch (InvalidSelectorException e) {

		}
	}

	//Scroll Backward
	public void scrollBackward() {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward(100)"));
		}
		catch (InvalidSelectorException e) {

		}
	}

	//Scroll To Beginning
	public void scrollToBeginning() {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10)"));
		} 
		catch (InvalidSelectorException e) {

		}
	}


	// Scroll To End
	public void ScrollToEnd(AppiumDriver<WebElement> driver, int scrolls) {
		try {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd("+scrolls+")"));
		} 
		catch (InvalidSelectorException e) {

		}
	}
}
