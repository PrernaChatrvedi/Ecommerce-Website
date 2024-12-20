package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC004_ValidateSignUp extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() {
		sheename ="SignUp";
		testName = "SignUp";
		testDescription ="Testing the SignUp functionality with the help of excelsheet";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
	}
	@Test(dataProvider = "readData")
	public void SignUpTest(String email, String password, String type, String message) {
		HomePage obj = new HomePage(driver);
		obj.click_country();
		obj.click_account();
		obj.SignUp().enter_email(email)
		.continue_click()
		.radio_pwd()
		.enter_password(password)
		.continue_click();
		obj.validateSignUp(type, message);
		
	}

}
