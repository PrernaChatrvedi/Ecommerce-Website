package base;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificMethods extends UtilityClass{
	
	
	@BeforeSuite
	public void reportInitilization() {
		
		String path="F:\\C data\\eclipse-workspace\\Ecommerce\\Report\\EcommerceReport.html";
		// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Ecommerce Report");
		
		// To capture test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	@BeforeMethod
	public void lunchBrowser() {
		browser_Launch();
		
	}
	@DataProvider(name ="readData")
	public String[][] readData() throws Exception {
		String[][] data =readExcel(sheename);
		return data;
	}
	
	@AfterMethod
	public void closeBrowser() {
		close_Browser();
	}
	
	@AfterSuite
	public void reportClose() {
		
		extent.flush();
		
	}
	
		
}
