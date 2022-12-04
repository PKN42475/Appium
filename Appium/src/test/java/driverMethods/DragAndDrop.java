package driverMethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragAndDrop {
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
		driver.tap(1, 233, 1177, 1500);
		driver.tap(1, 195, 894, 1500);
		MobileElement src = (MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		driver.tap(1, 137, 418, 1500);
		MobileElement dst = (MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		driver.tap(1, 469, 414, 1500);

		TouchAction tc = new TouchAction(driver);
		tc.longPress(src).moveTo(dst).release().perform();
		
	}	
}
