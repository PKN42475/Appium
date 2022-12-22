package practice;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridPractice {
	@Test
	public void seleniumGrid() throws MalformedURLException {

		URL url = new URL("http://192.168.0.229:4444/wd/hub");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
	}
}