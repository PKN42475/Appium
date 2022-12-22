package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser Launched Successfully");
		Thread.sleep(5000);
		driver.close();
		System.out.println("Browser CLosed Successfully");
	}
}
