package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC002_ValidateBrokenLink extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "ValidateWebURL";
		testDescription ="Testing the web URL";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}
	@Test
	public void FindBrokenLink() throws IOException {
		HomePage obj = new HomePage(driver);
		String linkurl = "https://www.bestbuy.com/";
		obj.findBrokenLink(linkurl);
}
}
