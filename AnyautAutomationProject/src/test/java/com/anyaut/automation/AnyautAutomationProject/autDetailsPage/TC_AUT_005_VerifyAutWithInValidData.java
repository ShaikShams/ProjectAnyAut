package com.anyaut.automation.AnyautAutomationProject.autDetailsPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anyaut.automation.AnyautAutomationProject.baseClass.TestBase;
import com.anyaut.automation.AnyautAutomationProject.uiActions.AutDetailsPage;

public class TC_AUT_005_VerifyAutWithInValidData extends TestBase {

	public static final Logger log = Logger.getLogger(TC_AUT_005_VerifyAutWithInValidData.class.getName());
	AutDetailsPage autDetailsPage;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData("AnyautTestData.xlsx", "TC_AUT_005");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();

	}

	@Test(dataProvider = "loginData")
	public void VerifyAutWithInValidData(String userName, String password, String industryName, String expectedIndustryName) throws Exception {

		log.info("========= Starting VerifyAutWithValidData ===========");
		autDetailsPage = new AutDetailsPage(driver);
		autDetailsPage.loginToApplication(userName, password);
		autDetailsPage.commonMethod();
		String actualIndustryName=autDetailsPage.autTestMethodInvalidDataForUrl(industryName);
		System.out.println("Industry Passed "+industryName);
		System.out.println("Industry Found  "+actualIndustryName);
		Assert.assertEquals(actualIndustryName, expectedIndustryName);		
		log.info("========= Finished VerifyAutWithValidData ===========");

	}

	@AfterClass
	public void endTest() {

		driver.close();
	}

}
