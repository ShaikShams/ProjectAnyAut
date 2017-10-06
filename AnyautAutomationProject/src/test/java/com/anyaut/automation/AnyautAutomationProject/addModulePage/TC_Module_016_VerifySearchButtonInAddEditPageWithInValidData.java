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

public class TC_Module_016_VerifySearchButtonInAddEditPageWithInValidData extends TestBase{

	public static final Logger log = Logger.getLogger(TC_Module_016_VerifySearchButtonInAddEditPageWithInValidData.class.getName());

	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData((String) OR.get("excelSheetName"), (String) OR.get("sheetName"));
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifySearchButtonInAddEditPageWithInValidData(String userName, String password, String moduleToBeSearched, String NoRecordsMessage) throws Exception {

		log.info("========= Starting VerifySearchButtonInAddEditPageWithInValidData ===========");
		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		boolean actual=autDetailsPage.moduleSearchWithInvalidData(moduleToBeSearched, NoRecordsMessage);
		Assert.assertEquals(actual, true);
		log.info("========= Finished VerifySearchButtonInAddEditPageWithInValidData ===========");

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}


}
