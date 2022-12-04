package android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BrowserStackFinal {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("browserstack.user", "pavankumar_f1RFsm");
		dc.setCapability("browserstack.key", "NUQEo4CWUvxEw5PJmqNv");
		
		dc.setCapability("device", "iphone 13");
		dc.setCapability("os_version", "15");
		
		dc.setCapability("project", "First Java Project");
		dc.setCapability("build", "browserstack-build-1");
		dc.setCapability("name", "first_test");
		dc.setBrowserName("safari");

		URL url= new URL("http://hub.browserstack.com/wd/hub");
		IOSDriver driver=new IOSDriver(url,dc);
	}
}
