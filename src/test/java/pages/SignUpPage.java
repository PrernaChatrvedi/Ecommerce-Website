package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethods;

public class SignUpPage extends ProjectSpecificMethods{
	@FindBy(xpath ="//input[@id='fld-e']")
	WebElement useremail;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath ="//input[@id='password-radio']")
	WebElement pwdradio;
	@FindBy(xpath ="//input[@id='fld-p1']")
	WebElement password;
	@FindBy(xpath ="//button[text()='Skip for now']")
	WebElement skip;

	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public SignUpPage enter_email(String UserEmail) {
		useremail.sendKeys(UserEmail);
		return this;
	}
	public SignUpPage continue_click() {
		submit.click();
		return this;
	}
	public SignUpPage radio_pwd() {
		pwdradio.click();
		return this;
	}
	public SignUpPage enter_password(String Password) {
		password.sendKeys(Password);
		return this;
	}
	

}
