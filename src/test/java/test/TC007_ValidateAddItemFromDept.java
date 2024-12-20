package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC007_ValidateAddItemFromDept extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		
		testName = "ValidateAddItemFromDept";
		testDescription ="Testing the add item from department manu functionality";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";
		
	}
	@Test
	public void ValidateShoingCart() {
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
		.cart()
		.ValidateAddtoCartFromDept();
	}
}
