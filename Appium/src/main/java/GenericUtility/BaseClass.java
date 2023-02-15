package GenericUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass {

	public AppiumDriverLocalService server;
	public AppiumDriver driver;
	public static AppiumDriver sdriver;

	@BeforeSuite
	public void connectToDatabase() {
		System.out.println("Connecting to database");
	}

	@BeforeTest
	public void startParallelExecution() {
		System.out.println("Start Parallel Execution");
	}

	//@Parameters({"port"})
	@BeforeClass
	public void connectToServer() {
//		int port1 = Integer.parseInt(port);
		
		//Default Server 4723
//		server = AppiumDriverLocalService.buildDefaultService();

		//Any Free Port for Server
//		server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingAnyFreePort()
//				.withLogFile(new File("./ServerLogs/logs.txt")));
//
//		//Customized Server
//		server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingPort(port1)
//				.withLogFile(new File("./ServerLogs/logs.txt")));

//		server.start();
		System.out.println("Appium server started");
	}

	@BeforeMethod
	public void launchApplication() throws MalformedURLException {
		System.out.println("Launching application");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4A");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sdriver = driver;
	}

	@AfterMethod
	public void closeApplication() {
		driver.closeApp();
		System.out.println("Closing Application");
	}

	@AfterClass
	public void disconnectToServer() {
//		server.stop();
		System.out.println("Appium server stopped");
	}

	@AfterTest
	public void stopParallelExecution() {
		System.out.println("Stop Parallel Execution");
	}

	@AfterSuite
	public void disconnectToDatabase() {
		System.out.println("Disconnecting from database");
	}
}
