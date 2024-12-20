package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC008_ValidateAddItemFromBrand extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "ValidateAddItemFromBrand";
		testDescription ="Testing the Add item from brand functionality";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}	
	@Test
		public void ValidateShoingCart() {
			HomePage obj = new HomePage(driver);
			obj.click_country();
			obj.Click_Mainmenu().AddtoCartFromBrand();
		}

}
