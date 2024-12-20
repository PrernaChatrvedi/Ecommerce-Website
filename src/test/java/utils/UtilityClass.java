package utils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class UtilityClass {
	
	public static WebDriver driver;
	public String sheename;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;
	
		public void browser_Launch() {
	/*public void browserLaunch(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("headless-Chrome")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			driver = new ChromeDriver(option);
		}*/
		driver = new ChromeDriver();
		driver.get("https://www.bestbuy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
	}
	public void close_Browser() {
		driver.close();
	}
	
	public void visibilityOfElement(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
   
	public static String[][] readExcel(String sheetName) throws Exception {
		
		XSSFWorkbook book = new XSSFWorkbook("F:\\C data\\eclipse-workspace\\Ecommerce\\src\\test\\resources\\testData\\TestData.xlsx");
		XSSFSheet sheet = book.getSheet(sheetName);	
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
	
		String[][] data = new String[rowCount][columnCount];
		for(int i =1 ; i <= rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j =0 ; j<columnCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				
			}

		}
	
		book.close();	
		return data;
}
    public static void findBrokenLink(String linkurl) throws IOException {
		
		try {
			URL url = new URL(linkurl);
			HttpURLConnection httpsUrlConnecttion = (HttpURLConnection) url.openConnection();
			httpsUrlConnecttion.setConnectTimeout(5000);
			httpsUrlConnecttion.connect();
			if(httpsUrlConnecttion.getResponseCode()>=400) {
				System.out.println(linkurl + "---->"+ httpsUrlConnecttion.getResponseMessage()+"is the broken link");
			}else
			{
				System.out.println(linkurl + "---->"+ httpsUrlConnecttion.getResponseMessage());
			}
			
		}catch(Exception e){
			
		}	
	}
    public static String screenshot(String name) throws IOException {
		
		String path="F:\\C data\\eclipse-workspace\\Ecommerce\\Screenshot"+name+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}

	
}
