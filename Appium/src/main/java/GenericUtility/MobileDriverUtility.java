package GenericUtility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileDriverUtility {

	public TouchAction tc;
	public AndroidDriver driver;

	public void tapByElement(int finger, MobileElement element, int duration) {
		driver.tap(finger, element, duration);
	}

	public void tapByCoordinate(int finger, int x, int y, int duration) {
		driver.tap(finger, x, y, duration);
	}

	public void swipeAction(int startX, int startY, int endX, int endY, int duration) {
		driver.swipe(startX, startY, endX, endY, duration);
	}

	public void scrollToElement(AndroidDriver driver, String an, String av) {
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}

	public void dragAndDrop(MobileElement src, MobileElement dest) {
		tc = new TouchAction(driver);
		tc.longPress(src).waitAction().moveTo(dest).release().perform();
	}

	public void takeScreenShot(AndroidDriver driver, String screenshotname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot"+screenshotname+".PNG");
		Files.copy(src, dest);
	}
	
	public void waitUntilTitlePresent(String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(value));
	}
}