package driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidKeyEvents {
	@Test
	public void android() throws MalformedURLException, Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4a");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability("appPackage", "com.android.camera");
		cap.setCapability("appActivity", ".Camera");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//driver.closeApp();

		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		System.out.println(AndroidKeyCode.BACK);
		System.out.println(AndroidKeyCode.ENTER);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);

		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CALL);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_NOTIFICATION);
		Thread.sleep(3000);

	}
}

