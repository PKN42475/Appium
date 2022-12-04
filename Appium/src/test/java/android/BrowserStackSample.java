package android;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserStackSample {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "pavankumar_f1RFsm");
		caps.setCapability("browserstack.key", "NUQEo4CWUvxEw5PJmqNv");

		// Set URL of the application under test
		caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
		driver.launchApp();
		
		driver.quit();

	}
}