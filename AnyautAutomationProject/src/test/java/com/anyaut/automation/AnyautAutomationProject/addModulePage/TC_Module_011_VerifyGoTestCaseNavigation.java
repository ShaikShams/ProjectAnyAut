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

public class TC_Module_011_VerifyGoTestCaseNavigation extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC_Module_011_VerifyGoTestCaseNavigation.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "TC_Module_011");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyGoTestCaseNavigation(String userName, String password, String testCaseTitle) throws Exception {

		log.info("========= Starting VerifyAddEditModuleWithValidData ===========");

		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		Thread.sleep(5000);
		String getAddTestCaseTitle=autDetailsPage.clickonTestCases();
		System.out.println(getAddTestCaseTitle);
		System.out.println(testCaseTitle);
		Assert.assertEquals(testCaseTitle,getAddTestCaseTitle);
		log.info("========= Finished VerifyAddEditModuleWithValidData ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}


}
