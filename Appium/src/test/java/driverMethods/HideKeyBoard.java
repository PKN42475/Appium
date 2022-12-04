package driverMethods;

import java.awt.List;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class HideKeyBoard {
	@Test
	public void hideKeyboard() throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2" );
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4A");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement view = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
		driver.tap(1, view, 100);
		MobileElement controles = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Controls\"]");
		driver.tap(1, controles, 100);
		MobileElement ltheam = (MobileElement)driver.findElementByAccessibilityId("1. Light Theme");
		driver.tap(1, ltheam, 100);
		MobileElement txt = (MobileElement) driver.findElementById("io.appium.android.apis:id/edit");
		txt.sendKeys("PAVAN");
		driver.tap(1, txt, 100);
		
		driver.hideKeyboard();
		MobileElement bx1 = (MobileElement)driver.findElementById("io.appium.android.apis:id/check1");
		driver.tap(1, bx1, 100);
		MobileElement bx2 = (MobileElement)driver.findElementById("io.appium.android.apis:id/check2");
		driver.tap(1, bx2, 100);
		MobileElement rd1 = (MobileElement)driver.findElementById("io.appium.android.apis:id/radio1");
		driver.tap(1, rd1, 100);
		MobileElement rd2 = (MobileElement)driver.findElementById("io.appium.android.apis:id/radio2");
		driver.tap(1, rd2, 100);
		MobileElement star = (MobileElement)driver.findElementById("io.appium.android.apis:id/star");
		driver.tap(1, star, 100);
		MobileElement tg1 = (MobileElement)driver.findElementById("io.appium.android.apis:id/toggle1");
		driver.tap(1, tg1, 100);
		MobileElement tg2 = (MobileElement)driver.findElementById("io.appium.android.apis:id/toggle2");
		driver.tap(1, tg2, 100);
		MobileElement spin = (MobileElement)driver.findElementById("io.appium.android.apis:id/spinner1");
		driver.tap(1, spin, 100);
		MobileElement jupiter = (MobileElement)driver.findElementByXPath("//android.widget.CheckedTextView[@index='4']");
		driver.tap(1, jupiter, 100);

		java.util.List<MobileElement> options = (java.util.List<MobileElement>) driver.findElementsByXPath("//android.widget.ListView[@resource-id='android:id/select_dialog_listview']");
		for(MobileElement i:options) {
			System.out.println(i.getText());
		}		
	}
}

