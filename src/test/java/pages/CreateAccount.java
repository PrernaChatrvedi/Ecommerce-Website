package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethods;

public class CreateAccount extends ProjectSpecificMethods{
	@FindBy(xpath ="//input[@id='firstName']")
	WebElement firstName;
	@FindBy(xpath ="//input[@id='lastName']")
	WebElement lastName;
	@FindBy(xpath ="//input[@id='email']")
	WebElement email;
	@FindBy(xpath ="//input[@id='fld-p1']")
	WebElement password;
	@FindBy(xpath ="//input[@id='reenterPassword']")
	WebElement reenterpassword;
	@FindBy(xpath ="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath ="//h1[text()='Create an Account']")
	WebElement createAccount;
	@FindBy(xpath ="//a[@class='mini-header__nav']")
	WebElement gotoHomePage;
	
	public CreateAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreateAccount enter_firstName(String FirstName) {
		firstName.sendKeys(FirstName);
		return this;
	}
	public CreateAccount enter_lastName(String LastName) {
		lastName.sendKeys(LastName);
		return this;
	}
	public CreateAccount enter_email(String Email) {
		email.sendKeys(Email);
		return this;
	}
	public CreateAccount enter_password(String Password) {
		password.sendKeys(Password);
		return this;
	}
	public CreateAccount enter_reenterpassword(String Reenterpassword) {
		reenterpassword.sendKeys(Reenterpassword);
		return this;
	}
	public CreateAccount enter_phone(String Phone) {
		phone.sendKeys(Phone);
		return this;
	}
	public CreateAccount submit() {
		submit.click();
		return new CreateAccount(driver);
	}
	public CreateAccount Validate_CreateAccount() {
		String actualText = createAccount.getText();
		System.out.println(actualText);
		String expectedText = "Create an Account";
		Assert.assertEquals(actualText, expectedText);
		return new CreateAccount(driver);
	}
	public HomePage back() {
		gotoHomePage.click();
		return new HomePage(driver);
	}
	

}
