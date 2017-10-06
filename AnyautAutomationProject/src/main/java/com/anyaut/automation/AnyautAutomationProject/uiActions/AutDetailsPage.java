package com.anyaut.automation.AnyautAutomationProject.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutDetailsPage {

	public static final Logger log = Logger.getLogger(AutDetailsPage.class.getName());

	WebDriver driver;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@id='singlebutton']")
	WebElement signin;

	@FindBy(xpath = "//*[@id='sidebar-menu']/div/ul/li[2]/a")
	WebElement testPlan;

	@FindBy(xpath = "//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[1]/a")
	WebElement testSetup;

	@FindBy(xpath = "//a[@href='aut-details.php']")
	WebElement AUT;

	@FindBy(xpath = "//button[@id='enable_aut']")
	WebElement autEditButton;

	@FindBy(xpath = "//button[@onclick='return editAut()']")
	WebElement autUpdateButton;

	@FindBy(id = "edit_aut_name")
	WebElement autName;

	@FindBy(id = "edit_url_live_version")
	WebElement autURL;

	@FindBy(id = "edit_industry")
	WebElement industry;

	@FindBy(xpath = "//a[@href='add-module.php']")
	WebElement modules;

	@FindBy(xpath = "//input[@id='module_name']")
	WebElement moduleName;

	@FindBy(xpath = "//input[@id='module_id']")
	WebElement moduleID;

	@FindBy(xpath = "//input[@id='module_description']")
	WebElement moduleDescription;

	@FindBy(id = "add-module")
	WebElement addModule;

	@FindBy(xpath = "//table[@id='datatable-fixed-header']//tbody/tr/td[1]")
	List<WebElement> modulesList;

	@FindBy(xpath = "//div[@id='datatable-fixed-header_filter']/label/input")
	WebElement addEditPage_SearchButton;

	@FindBy(xpath = "//table[@id='datatable-fixed-header']/tbody/tr[3]/td[4]/a/i")
	WebElement editButton;

	@FindBy(xpath = "//table[@id='datatable-fixed-header']/tbody/tr[1]/td[5]/a/i")
	WebElement deleteButton;

	@FindBy(xpath = "//table[@id='datatable-fixed-header']/tbody/tr/td")
	WebElement noMatchFound;

	@FindBy(xpath = "//input[@name='modal_module_name']")
	WebElement editButton_ModuleName;

	@FindBy(xpath = "//input[@name='modal_module_id']")
	WebElement editButton_ModuleId;

	@FindBy(xpath = "//textarea[@name='modal_module_description']")
	WebElement editButton_ModuleDescription;

	@FindBy(id = "update-module")
	WebElement editButton_UpdateModule;

	@FindBy(xpath = "//span[@class='failure-msg']")
	WebElement failureMsg;

	@FindBy(xpath = "//span[@class='module_name_error']")
	WebElement moduleNameError;

	@FindBy(xpath = "//span[@class='module_id_error']")
	WebElement moduleIDError;

	@FindBy(xpath = "//a[@href='http://anyaut.com/orange/add-test-case.php']")
	WebElement goToTestCases;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileDropdown;

	@FindBy(xpath = "//a[@href='logout.php']")
	WebElement logout;

	@FindBy(xpath = "//button[@onclick='return addAut()']")
	WebElement autSubmitButton;

	public AutDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String emailAddress, String loginpassword) {

		log.info("Entering Username and Password");
		username.clear();
		username.sendKeys(emailAddress);
		password.clear();
		password.sendKeys(loginpassword);
		signin.click();
		log.info("Entered Username and Password and clicked on signin button and the object is: " + signin.toString());
	}

	public void logout() throws InterruptedException {

		log.info("Clciking on Profile Dropdown");
		profileDropdown.click();
		log.info("Clciked on Profile Dropdown");
		log.info("Clciking on Logout");
		logout.click();
		log.info("Clciked on Logout");
		Thread.sleep(3000);

	}

	public void commonMethod() {

		log.info("Clicking on Test Plan link");
		testPlan.click();
		log.info("Clicked on Test Plan Link");
		log.info("Clicking on Test Setup link");
		testSetup.click();
		log.info("Clicked on Test Setup Link");
	}

	public String autTestMethod(String appName, String appURL, String industryName) {

		AUT.click();
		autEditButton.click();
		autName.clear();
		autName.sendKeys(appName);
		autURL.clear();
		autURL.sendKeys(appURL);
		industry.clear();
		industry.sendKeys(industryName);
		autUpdateButton.click();
		String editText = autEditButton.getAttribute("innerHTML");
		return editText;

	}

	public String autTestMethodInvalidDataForAUT(String appName) throws InterruptedException {

		AUT.click();
		autEditButton.click();
		autName.clear();
		autName.sendKeys(appName);
		autUpdateButton.click();
		Thread.sleep(3000);
		autEditButton.click();
		Thread.sleep(3000);
		String updatedAutName = autName.getAttribute("value");
		return updatedAutName;

	}

	public String autTestMethodInvalidDataForUrl(String urlName) throws InterruptedException {

		AUT.click();
		autEditButton.click();
		autURL.clear();
		autURL.sendKeys(urlName);
		autUpdateButton.click();
		Thread.sleep(3000);
		autEditButton.click();
		Thread.sleep(3000);
		String updatedUrlName = autURL.getAttribute("value");
		return updatedUrlName;

	}

	public String autTestMethodInvalidDataForIndustry(String industryName) throws InterruptedException {

		AUT.click();
		autEditButton.click();
		industry.clear();
		industry.sendKeys(industryName);
		autUpdateButton.click();
		Thread.sleep(3000);
		autEditButton.click();
		Thread.sleep(3000);
		String updatedIndustryName = industry.getAttribute("value");
		return updatedIndustryName;

	}

	public void addEditModules(String eModuleName, String eModuleID, String eModuleDesciption) {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		log.info("Entering Module Name, Module ID and Module Description");
		moduleName.clear();
		moduleName.sendKeys(eModuleName);
		moduleID.clear();
		moduleID.sendKeys(eModuleID);
		moduleDescription.clear();
		moduleDescription.sendKeys(eModuleDesciption);
		addModule.click();
		log.info("Entered Module Name, Module ID and Module Description");

	}

	public String moduleList(String inputValue) {

		log.info("Importing all the list modules in WebElement");
		List<WebElement> modulelist = modulesList;

		log.info("Traversing through Webelement");
		for (WebElement ele : modulelist) {

			String output = ele.getText();
			System.out.println(output);
			log.info("Checking the created Module is listed or not");
			if (output.equals(inputValue)) {
				System.out.println("Pass");
				return output;
			}
		}
		return null;

	}

	public String clickonAUTWithBlankData() {

		log.info("Clicking on AUT link");
		AUT.click();
		log.info("Clicked on AUT link");
		log.info("Clicking on SUBMIT Button");
		autSubmitButton.click();
		log.info("Clicked on SUBMIT Button");
		String failureMessage = failureMsg.getText();
		return failureMessage;

	}

	public String clickonModulesWithBlank() {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		log.info("Clicking on Add Module");
		addModule.click();
		log.info("Clicked on Add Amodule");
		String failureMessage = failureMsg.getText();
		return failureMessage;

	}

	public String clickonModuleNameWithSameData(String eModuleName) throws InterruptedException {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		log.info("Entering Existing Module Name");
		moduleName.clear();
		moduleName.sendKeys(eModuleName);
		Thread.sleep(3000);
		log.info("Entered Module Name");
		String moduleNameErrorMessage = moduleNameError.getText();
		return moduleNameErrorMessage;

	}

	public String clickonModuleIDWithSameData(String eModuleID) throws InterruptedException {

		log.info("Entering Existing Module ID");
		moduleID.clear();
		moduleID.sendKeys(eModuleID);
		log.info("Entered Module ID");
		Thread.sleep(3000);
		String moduleIDErrorMessage = moduleIDError.getText();
		return moduleIDErrorMessage;

	}

	public String clickonTestCases() {
		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		log.info("Clicking on Go To Test Cases link");
		goToTestCases.click();
		log.info("Clicked on Go To Test Cases link");
		String addTestCaseTitle = driver.getTitle();
		return addTestCaseTitle;
	}

	public void clickonEditButtoninAddEditPage(String editModuleName, String editModuleId, String editModuleDescription)
			throws InterruptedException {
		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		editButton.click();
		Thread.sleep(5000);
		editButton_ModuleName.clear();
		editButton_ModuleName.sendKeys(editModuleName);
		Thread.sleep(3000);
		editButton_ModuleId.clear();
		editButton_ModuleId.sendKeys(editModuleId);
		Thread.sleep(3000);
		editButton_ModuleDescription.clear();
		editButton_ModuleDescription.sendKeys(editModuleDescription);
		Thread.sleep(3000);
		editButton_UpdateModule.click();
		log.info("Clicked on Update Button");
	}

	public boolean clickOnDeleteButtoninAddEditPage(String moduleToBeDeleted, String NoRecordsMessage)
			throws InterruptedException {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		addEditPage_SearchButton.sendKeys(moduleToBeDeleted);
		deleteButton.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		alert.accept();
		Thread.sleep(3000);
		addEditPage_SearchButton.clear();
		addEditPage_SearchButton.sendKeys(moduleToBeDeleted);
		String result = noMatchFound.getText();
		System.out.println(result);
		if (result.contentEquals(NoRecordsMessage)) {
			return true;
		}
		return false;

	}

	public boolean clickOnDeleteButtoninAddEditPageWithTestCase(String moduleToBeDeleted, String cannotMessage)
			throws InterruptedException {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		addEditPage_SearchButton.sendKeys(moduleToBeDeleted);
		deleteButton.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		alert.accept();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		String message1 = alert1.getText();
		alert1.accept();
		System.out.println(message1);
		if (message1.contains(cannotMessage)) {
			return true;
		}
		return false;

	}

	public boolean checkingSearchMethod(String inputValue) {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		log.info("Entering value in search button");
		addEditPage_SearchButton.sendKeys(inputValue);
		log.info("Importing all the list modules in WebElement");
		List<WebElement> modulelist = modulesList;

		log.info("Traversing through Webelement");
		for (WebElement ele : modulelist) {

			String output = ele.getText();
			System.out.println(output);
			log.info("Checking the created Module is listed or not");
			if (output.equals(inputValue)) {
				System.out.println("Pass");
				return true;
			}
		}
		return false;

	}

	public boolean moduleSearchWithInvalidData(String moduleToBeSearched, String NoRecordsMessage)
			throws InterruptedException {

		log.info("Clicking on Modules link");
		modules.click();
		log.info("Clicked on Modules link");
		addEditPage_SearchButton.clear();
		addEditPage_SearchButton.sendKeys(moduleToBeSearched);
		Thread.sleep(2000);
		String result = noMatchFound.getText();
		System.out.println(result);
		if (result.contentEquals(NoRecordsMessage)) {
			return true;
		}
		return false;

	}

}
