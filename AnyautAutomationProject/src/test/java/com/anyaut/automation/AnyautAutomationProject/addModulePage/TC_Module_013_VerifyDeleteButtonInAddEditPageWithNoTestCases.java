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

public class TC_Module_013_VerifyDeleteButtonInAddEditPageWithNoTestCases extends TestBase{

	public static final Logger log = Logger.getLogger(TC_Module_013_VerifyDeleteButtonInAddEditPageWithNoTestCases.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "TC_Module_013");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyDeleteButtonInAddEditPageWithNoTestCases(String userName, String password, String moduleToBeDeleted,String NoRecordsMessage) throws Exception {

		log.info("========= Starting VerifyDeleteButtonInAddEditPageWithNoTestCases ===========");
		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		Thread.sleep(3000);
		boolean actual=autDetailsPage.clickOnDeleteButtoninAddEditPage(moduleToBeDeleted, NoRecordsMessage);
		Assert.assertEquals(actual, true);
		log.info("========= Finished VerifyDeleteButtonInAddEditPageWithNoTestCases ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}


}
