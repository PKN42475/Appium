package ObjectRepository;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class HomePage {

	public AppiumDriver<WebElement> driver;
	
	//Declaration
	@FindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement title;

	@FindBy(xpath="//android.widget.TextView[@text='Select the country where you want to shop']")
	private WebElement countryText;

	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement dropDown;

	@FindBy(xpath="//android.widget.TextView")
	private List<WebElement> list;
	
	@FindBy(xpath="//android.widget.TextView[@text='Your Name']")
	private WebElement name;

	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameTextField;

	@FindBy(xpath="//android.widget.TextView[@text='Gender']")
	private WebElement gender;

	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleRdBtn;

	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRdBtn;

	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopBtn;

	//Getters
	public WebElement getTitle() {
		return title;
	}

	public WebElement getCountryText() {
		return countryText;
	}

	public WebElement getDropDown() {
		return dropDown;
	}
	
	public List<WebElement> getList() {
		return list;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getMaleRdBtn() {
		return maleRdBtn;
	}

	public WebElement getFemaleRdBtn() {
		return femaleRdBtn;
	}

	public WebElement getLetsShopBtn() {
		return letsShopBtn;
	}

	//Initialization
	public HomePage(AppiumDriver<WebElement> driver){
		PageFactory.initElements(driver, this);
	}

	//Business Logics
	public String Title() {
		return title.getText();
	}

	public String selectCountryText() {
		return countryText.getText();
	}

	public void clickOnDropDownButton() {
		dropDown.click();
	}
	
	public List<WebElement> printAllCoutryNames() {
		return list;
	}

	public String nameText() {
		return name.getText();
	}

	public void nameTextBox(String name) {
		nameTextField.sendKeys(name);
	}

	public String genderText() {
		return gender.getText();
	}

	public void clickOnMale() {
		maleRdBtn.click();
	}

	public void clickOnFemale() {
		femaleRdBtn.click();
	}

	public void clickOnLetsShopButton() {
		letsShopBtn.click();
	}

}
