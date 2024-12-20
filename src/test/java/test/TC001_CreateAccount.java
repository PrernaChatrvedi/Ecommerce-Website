package test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC001_CreateAccount extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setup() throws IOException {
		sheename ="CreateAccount";
		testName = "CreateAccount";
		testDescription ="Testing the Create Account functionality with the help of excelsheet";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}
	@Test(dataProvider = "readData")
	public void CreateAccountTest(String FirstName,String LastName,String Email,String Password,String ReEnterPassword,String Phone ) {
		HomePage obj = new HomePage(driver);
		obj.click_country();
		obj.click_account();
		obj.Create_Account()
		.enter_firstName(FirstName)
		.enter_lastName(LastName)
		.enter_email(Email)
		.enter_password(Password)
		.enter_reenterpassword(ReEnterPassword)
		.enter_phone(Phone)
		.submit()
		.Validate_CreateAccount()
		.back();
	}

}
