package com.anyaut.automation.AnyautAutomationProject.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.anyaut.automation.AnyautAutomationProject.excelReader.ExcelUtilities;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public static WebDriver driver;
	public Properties OR = new Properties();
	ExcelUtilities excel;
	//String url = "https://anyaut.com/orange/";
	//String browser = "firefox";
	
	public void init() throws IOException{
		
		initialize();
		selectBrowser((String) OR.get("browser"));
		getUrl((String) OR.get("url"));
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	public void initialize() throws IOException{
		
		
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\anyaut\\automation\\AnyautAutomationProject\\config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}

	private void getUrl(String url) {
		log.info("Navigating to " + url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	private void selectBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			log.info("Creating object of " + browser);
			driver=new FirefoxDriver();
		}
		
	}
	
	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + OR.get("excelSheetPath") + excelName;
		excel = new ExcelUtilities(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	
		/*String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\anyAut\\Automation\\UIanyAut\\data\\" + excelName;
		excel = new ExcelUtilities(path);*/
		
	}
	
	public void getScreenShot(String name) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\anyaut\\automation\\AnyautAutomationProject\\screenshot\\";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
