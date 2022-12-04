package POM;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageForGeneralStore {
	public AndroidDriver driver;

	//Initialization
	public LoginPageForGeneralStore(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Declaration
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement UsernameTxt;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement MaleRdBtn;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement FemaleRcBtn;

	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement LetsShopBtn;

	public MobileElement getUsernameTxt() {
		return UsernameTxt;
	}

	public MobileElement getMaleRdBtn() {
		return MaleRdBtn;
	}

	public MobileElement getFemaleRcBtn() {
		return FemaleRcBtn;
	}

	public MobileElement getLetsShopBtn() {
		return LetsShopBtn;
	}

	//Utilization
	public void login(String name) {
		UsernameTxt.sendKeys(name);
		MaleRdBtn.click();
		LetsShopBtn.click();
	}
}
