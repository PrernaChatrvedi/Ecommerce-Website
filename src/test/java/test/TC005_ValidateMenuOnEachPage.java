package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC005_ValidateMenuOnEachPage extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "ValidateMenuOnEachPage";
		testDescription ="Testing the menu option in all submenu";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}
	@Test
	public void ValidateEachMeuUnderMainmenu() {
		HomePage obj = new HomePage(driver);
		obj.click_country();
		obj.validateMenu();
	}

}
