package Task;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Redmi {
	public AndroidDriver driver;
	
	@Test
	public void Android() throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		//cap.setCapability("app", "C:\\Users\\pavan\\Downloads");	//Install

		//Launch App
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver<>(url , cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"App\"]").click();
		Thread.sleep(4000);
		//scrollToElement(driver, "text", "Voice Recognition");
		//Thread.sleep(4000);
		//driver.findElementByAccessibilityId("Voice Recognition").click();
		//Thread.sleep(4000);
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		//Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Notification\"]").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"IncomingMessage\"]").click();
		Thread.sleep(4000);
		driver.findElementById("io.appium.android.apis:id/notify_app").click();
		Thread.sleep(4000);
		driver.openNotifications();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Joe']").click();
		Thread.sleep(2000);
		String mess = driver.findElementById("io.appium.android.apis:id/message").getText();
		Thread.sleep(2000);
		System.out.println(mess);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Search\"]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Invoke Search\"]").click();
		Thread.sleep(2000);
		driver.findElementById("io.appium.android.apis:id/txt_query_prefill").click();
		Thread.sleep(2000);
		driver.findElementById("io.appium.android.apis:id/txt_query_prefill").sendKeys("pavan");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"onSearchRequested()\"]").click();
		Thread.sleep(2000);
		driver.findElementById("android:id/search_close_btn").click();
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]").click();
		Thread.sleep(2000);
		AndroidElement src = (AndroidElement)driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		Thread.sleep(2000);
		AndroidElement dst = (AndroidElement)driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		Thread.sleep(2000);
		dragAndDrop(src, dst);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Buttons\"]").click();
		Thread.sleep(2000);
		driver.findElementById("io.appium.android.apis:id/button_toggle").click();
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	public void scrollToElement(AndroidDriver driver, String an, String av) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	}
	
	public void dragAndDrop(AndroidElement src, AndroidElement dst ) {
		TouchAction tc = new TouchAction(driver);
		tc.longPress(src).moveTo(dst).release().perform();
	}
}
