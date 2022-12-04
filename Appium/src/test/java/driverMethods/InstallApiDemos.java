package driverMethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallApiDemos {
	@Test
	public void installTouchScreenapp() throws Throwable {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4a");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");

		//General Store installed and it will be launched if we use this code
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\pavan\\Downloads\\APK Files\\ApiDemos-debug.apk");

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Touch Screen installed it will not launch if we use this code
		driver.installApp("C:\\Users\\pavan\\Downloads\\APK Files\\ApiDemos-debug.apk");
	}
}
