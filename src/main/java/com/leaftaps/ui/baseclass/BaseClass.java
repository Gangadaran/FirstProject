package com.leaftaps.ui.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class BaseClass {
	public static RemoteWebDriver driver;
	public String excelFileName;
	public static Properties property;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public String testName, testDescription, testCategory, testAuthor;
	
	
	
	
   

	@BeforeSuite
	public void startReport1() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");

		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}

	public void reportStep(String testDesc, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			int takeSnap = takeSnap();
			node.pass(testDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap+".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			int takeSnap = takeSnap();
			node.fail(testDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap+".png").build());
		}

	}

	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random() * 99999 + 72637383);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + ranNum + ".png");
		FileUtils.copyFile(source, target);
		return ranNum;
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {

		 node = test.createNode(testName);
		
		property = new Properties();
		FileInputStream file = new FileInputStream("./confirg/AppConfig.properties");
		property.load(file);
		Object browserName = property.get("browserName");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		// getting URL from property file
		String URL = property.getProperty("URL");

		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void testCaseDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@DataProvider
	public String[][] testData() throws IOException {
		return ReadExcelData.getData(excelFileName);
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

}