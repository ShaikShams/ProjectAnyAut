package com.anyaut.automation.AnyautAutomationProject.addModulePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anyaut.automation.AnyautAutomationProject.baseClass.TestBase;
import com.anyaut.automation.AnyautAutomationProject.uiActions.AutDetailsPage;

public class LoginData extends TestBase {

	public static final Logger log = Logger.getLogger(LoginData.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "LoginData");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyAddEditModuleWithSameData(String userName, String password) throws Exception {

		log.info("========= Starting VerifyAddEditModuleWithValidData ===========");
		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.logout();
		log.info("========= Finished VerifyAddEditModuleWithValidData ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}
