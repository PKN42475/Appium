package org.crm.Campaigns;

import org.testng.annotations.Test;
import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateCampaignTest extends BaseClass{
	@Test(groups = {"SmokeTest"})
	public void createCampaignTest() throws Throwable {

		File_Utility fu = new File_Utility();
		String URL = fu.getPropertyKeyValue("url");
		String UN = fu.getPropertyKeyValue("un");
		String PW = fu.getPropertyKeyValue("pw");

		WebDriver_Utility wu = new WebDriver_Utility();
		wu.waitForPageLoad(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PW);

		HomePage hm = new HomePage(driver);
		hm.clickOnMore();
		hm.clickOnCampaign();

		Java_Utility ju = new Java_Utility();
		int RanNum = ju.getRandomNum(1000);

		Excel_Utility eu = new Excel_Utility();
		String data = eu.getDataFromExcel("sheet1", 1, 1)+RanNum;

		CampaignPage cp = new CampaignPage(driver);
		cp.campaignCreation();
		cp.campaignNameTextField(data);
		cp.clickSaveButton();
		cp.titleVerification(data);
	}
}
