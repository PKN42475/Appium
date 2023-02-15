package GeneralStores;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;

public class BrowserStackIOS {
	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("browserstack.user", "pavankumar_f1RFsm");
		dc.setCapability("browserstack.key", "NUQEo4CWUvxEw5PJmqNv");

		dc.setCapability("device", "iphone 13");
		dc.setCapability("os_version", "15");
		dc.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

		URL url= new URL("http://hub.browserstack.com/wd/hub");
		IOSDriver driver=new IOSDriver(url,dc);
	}
}
