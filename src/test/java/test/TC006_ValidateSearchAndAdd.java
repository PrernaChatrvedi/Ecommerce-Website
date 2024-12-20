package test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC006_ValidateSearchAndAdd extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		
		testName = "ValidateSearchAndAdd";
		testDescription ="Testing the search and add functionality on website";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}
	@Test
	public void ValidateShoingCart() {
		HomePage obj = new HomePage(driver);
		obj.click_country();
		obj.SearchBox();
		obj.SearchButton()
		.ValidateSearchAndAdd();
		
	
	}
}
	
