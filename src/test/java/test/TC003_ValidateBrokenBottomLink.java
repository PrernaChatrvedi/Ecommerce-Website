package test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC003_ValidateBrokenBottomLink extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "ValidteBottomLinks";
		testDescription ="Testing the all the bottom links on the website";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}
	@Test
	public void BottomLinks() {
		HomePage obj = new HomePage(driver);
		obj.click_country();
		obj.ValidateBottomLinks();
		
		
	}

}
