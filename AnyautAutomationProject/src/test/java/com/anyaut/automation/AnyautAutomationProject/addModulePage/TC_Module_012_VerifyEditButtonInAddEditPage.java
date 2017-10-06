package com.anyaut.automation.AnyautAutomationProject.addModulePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anyaut.automation.AnyautAutomationProject.baseClass.TestBase;
import com.anyaut.automation.AnyautAutomationProject.uiActions.AutDetailsPage;

public class TC_Module_012_VerifyEditButtonInAddEditPage extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Module_012_VerifyEditButtonInAddEditPage.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "TC_Module_012");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyEditButtonInAddEditPage(String userName, String password, String editModuleName, String editModuleId,String editModuleDescription,String expectedValue) throws Exception {

		log.info("========= Starting VerifyEditButtonInAddEditPage ===========");

		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		Thread.sleep(3000);
		autDetailsPage.clickonEditButtoninAddEditPage(editModuleName, editModuleId, editModuleDescription);
		Thread.sleep(10000);
		Assert.assertEquals(autDetailsPage.moduleList("Demo15"), expectedValue);
		log.info("========= Finished VerifyEditButtonInAddEditPage ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}


}
