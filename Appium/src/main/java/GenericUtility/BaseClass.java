package GenericUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	public static WebDriver sDriver;
	public AppiumDriverLocalService service;
	public AndroidDriver driver;


	@BeforeSuite
	public void databaseConnection() {
		System.out.println("Connected");
	}

	@BeforeTest
	public void parallelExecution() {
		System.out.println("Start");
	}

	@BeforeClass
	public void startServer() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}	

	@BeforeMethod
	public void openApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4A");
		cap.setCapability(MobileCapabilityType.UDID, "89d3da547d04");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "ApiDemos");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApp() {
		driver.closeApp();
	}

	@AfterClass
	public void stopServer() {
		service.stop();
	}

	@AfterTest
	public void stopParallelExecution() {
		System.out.println("Stop");
	}

	@AfterSuite
	public void closeDatabaseConnection() {
		System.out.println("Disconnected");
	}

}
