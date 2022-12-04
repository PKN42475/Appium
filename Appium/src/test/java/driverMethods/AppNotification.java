package driverMethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppNotification {
	@Test
	public void dragAndDrop() throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4a");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement app = (MobileElement)driver.findElementByXPath("//android.widget.TextView[@text='App']");
		driver.tap(1, app, 100);
		MobileElement notification = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Notification']");
		driver.tap(1, notification, 100);
		MobileElement message = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='IncomingMessage']");
		driver.tap(1, message, 100);
		MobileElement show = (MobileElement)driver.findElementByAccessibilityId("Show App Notification");
		driver.tap(1, show, 100);
		
		driver.openNotifications();
		driver.findElementByXPath("//android.widget.TextView[@text='Joe']").click();
		//driver.tap(1, joe, 100);
	}
}
