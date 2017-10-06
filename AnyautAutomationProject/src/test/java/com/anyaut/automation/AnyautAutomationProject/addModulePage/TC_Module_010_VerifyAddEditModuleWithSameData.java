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

public class TC_Module_010_VerifyAddEditModuleWithSameData extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC_Module_010_VerifyAddEditModuleWithSameData.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "TC_Module_010");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyAddEditModuleWithSameData(String userName, String password, String moduleName, String moduleNameError, String moduleID, String moduleIDError) throws Exception {

		log.info("========= Starting VerifyAddEditModuleWithValidData ===========");

		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		Thread.sleep(10000);
		String moduleNameErrorMessage=autDetailsPage.clickonModuleNameWithSameData(moduleName);
		Thread.sleep(3000);
		System.out.println(moduleNameErrorMessage);
		System.out.println(moduleNameErrorMessage.length());
		System.out.println(moduleNameError);
		System.out.println(moduleNameError.length());
		log.info("========= Validating the Error Message ===========");
		Assert.assertEquals(moduleNameError,moduleNameErrorMessage);
		log.info("========= Finished Validating the Error Message ===========");
		Thread.sleep(3000);
		String moduleIDErrorMessage=autDetailsPage.clickonModuleIDWithSameData(moduleID);
		Thread.sleep(3000);
		System.out.println(moduleIDErrorMessage);
		System.out.println(moduleIDErrorMessage.length());
		System.out.println(moduleIDError);
		System.out.println(moduleIDError.length());
		log.info("========= Validating the Error Message ===========");
		Assert.assertEquals(moduleIDError,moduleIDErrorMessage);
		log.info("========= Finished Validating the Error Message ===========");
		log.info("========= Finished VerifyAddEditModuleWithValidData ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

	
}
