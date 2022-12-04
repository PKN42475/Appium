package driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeN {
	@Test
	public void swipe() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4a");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		cap.setCapability("appActivity", ".TouchScreenTestActivity");

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension size = driver.findElementById("jp.rallwell.siriuth.touchscreentest:id/surfaceView").getSize();
		int h = size.height;
		int w = size.width;
		System.out.println(h + " "+ w);
		
		driver.swipe((int)(w*0.25), (int)(h*0.25), (int)(w*0.25), (int)(h*0.75), 1500);
		driver.swipe((int)(w*0.25), (int)(h*0.75), (int)(w*0.75), (int)(h*0.75), 1500);
		driver.swipe((int)(w*0.75), (int)(h*0.75), (int)(w*0.75), (int)(h*0.25), 1500);
	}
}
