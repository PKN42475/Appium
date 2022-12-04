package driverMethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import GenericUtility.File_Utility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApiDemosApp {
	@Test
	public void launchApp() throws Throwable {

		DesiredCapabilities cap = new DesiredCapabilities();
		File_Utility fu = new File_Utility();
		
		String plName = fu.getPropertyKeyValue("platformName");
		String plVersion = fu.getPropertyKeyValue("platformVersion");
		String dName = fu.getPropertyKeyValue("deviceName");
		String dVersion = fu.getPropertyKeyValue("UDID");
		String aPackage = fu.getPropertyKeyValue("appPackage");
		String aActivity = fu.getPropertyKeyValue("appActivity");

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, plName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, plVersion);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, dName);
		cap.setCapability(MobileCapabilityType.UDID, dVersion);
		cap.setCapability("appPackage", aPackage);
		cap.setCapability("appActivity", aActivity);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
