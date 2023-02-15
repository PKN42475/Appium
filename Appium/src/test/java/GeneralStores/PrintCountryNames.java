package GeneralStores;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.MobileUtility;
import ObjectRepository.HomePage;
import io.appium.java_client.MobileBy;

public class PrintCountryNames extends BaseClass{
	@Test
	public void countryNames() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		MobileUtility mu = new MobileUtility();

		String title = hp.Title();
		Assert.assertEquals("General Store", title);
		Reporter.log(title +" verified", true);

		hp.clickOnDropDownButton();

		List<WebElement> countries = hp.printAllCoutryNames();
//		int count = countries.size();
//		System.out.println(count);
//		for(int i=0; i<20; i++) {
//			for(int j=0; j<count-1; j++) {
//				Reporter.log(countries.get(j).getText(), true);
//			}
//			mu.ScrollToEnd(driver, i);
//		}
		
//		for(int i=0; i<11; i++) {
//			for(WebElement allCountries:countries) {
//				System.out.println(allCountries.getText());
//			}
//			Thread.sleep(3000);
//			mu.ScrollToEnd(driver, i);
//		}
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward"));
		
	}
}
