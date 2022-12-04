package driverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwitchingFromNativeToWeb {
	@Test
	public void switchToWeb() throws MalformedURLException, Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4a");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement text = (MobileElement)driver.findElementById("com.androidsample.generalstore:id/nameField");
		text.sendKeys("Pavan");
		driver.tap(1, text, 100);
		MobileElement shop = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		driver.tap(1, shop, 100);
		MobileElement cart = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/productAddCart");
		driver.tap(1, cart, 100);
		MobileElement gcart = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
		driver.tap(1, gcart, 100);
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		Thread.sleep(4000);

		Set<String> windows = driver.getContextHandles();

		for(String window:windows) {
			System.out.println("Active Applications" + window);
		}
		Thread.sleep(4000);
		driver.context("WEBVIEW_com.androidsample.generalstore");

		Thread.sleep(4000);
		driver.findElementByXPath("//input[@name='q]").sendKeys("Tyss");
	}
}
