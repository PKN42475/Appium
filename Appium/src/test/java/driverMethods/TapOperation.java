package driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TapOperation {
	@Test
	public void tapOperation() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4a");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", ".cal.CalculatorActivity");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement five = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_5_s");
		driver.tap(1, five, 500);
		MobileElement plus = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_plus_s");
		driver.tap(1, plus, 500);
		MobileElement two = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
		driver.tap(1, two, 500);
		MobileElement equals = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_equal_s");
		driver.tap(1, equals, 500);
		String result = (String) driver.findElementById("com.miui.calculator:id/result").getText();
		System.out.println(result);
	}
}
