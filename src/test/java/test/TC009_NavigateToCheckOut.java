package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;
   
public class TC009_NavigateToCheckOut extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setup() {
		sheename ="CheckOut";
		testName = "NavigateToCheckOut";
		testDescription ="Testing the checkout functionality with the help of excelsheet";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
	}
	@Test(dataProvider = "readData")
	
	public void ValidateShoingCart(String Email,String Password,String FirstName,String LastName,String Street,String City,String State,String ZipCode ) {
		HomePage obj = new HomePage(driver);
		obj.click_country();
		obj.Click_Mainmenu()
		.Appliances()
		.MajorKitchenAppliances()
		.Refrigerators()
		.selectRefrigerators()
		.ScrollDown()
		.Addtcart()
		.gotocart()
		.Checkout()
		.enter_email(Email)
		.continue1()
		.radioselect()
		.enter_pass(Password)
		.continue1();
		/*.enter_FirstName(FirstName) // This code will not work as this website is blocked automation
		.enter_LastName(LastName)
		.enter_Street(Street)
		.enter_City(City)
		.enter_State(State)
		.enter_Zipcode(ZipCode)
		.saveAddress()
		.Apply()
		.scheduledelivery();*/
		
		

		
	}
}
