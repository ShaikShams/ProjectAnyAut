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

public class TC_Module_009_VerifyAddEditModuleWithBlankData extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC_Module_009_VerifyAddEditModuleWithBlankData.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "TC_Module_009");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyAddEditModuleWithBlankData(String userName, String password, String message) throws Exception {

		log.info("========= Starting VerifyAddEditModuleWithValidData ===========");

		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		Thread.sleep(10000);
		String failureMessage=autDetailsPage.clickonModulesWithBlank();
		Thread.sleep(3000);
		System.out.println(failureMessage);
		System.out.println(failureMessage.length());
		System.out.println(message);
		System.out.println(message.length());
		Assert.assertEquals(message,failureMessage);
		
		log.info("========= Finished VerifyAddEditModuleWithValidData ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}
