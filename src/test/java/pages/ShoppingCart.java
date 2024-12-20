package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.ProjectSpecificMethods;

public class ShoppingCart extends ProjectSpecificMethods{
	@FindBy(xpath ="(//a[text()='See Details'])[1]")
	WebElement seedetails;
	@FindBy(xpath ="//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
	WebElement cartbutton;
	@FindBy(xpath ="//button[text()='Appliances']")
	WebElement Appliances;
	@FindBy(xpath ="//button[text()='Major Kitchen Appliances']")
	WebElement MajorKitchenAppliances;
	@FindBy(xpath ="//a[contains(text(),'Refrigerators')]")
	WebElement Refrigerators;
	@FindBy(xpath ="(//div[@class='flex-grid-row-1 flex-grid-column-1'])[1]")
	WebElement selectRefrigerators;
	@FindBy(xpath ="(//button[@class='c-button c-button-primary c-button-sm c-button-block c-button-icon c-button-icon-leading add-to-cart-button '])[1]")
	WebElement Addtcart;
	@FindBy(xpath ="//a[text()='Go to Cart']")
	WebElement gotocart;
	@FindBy(xpath ="//span[text()='Cart']")
	WebElement cart;
	@FindBy(xpath ="(//button[@class='c-button-unstyled top-four v-fw-medium'])[3]")
	WebElement Brands;
	@FindBy(xpath ="(//a[@class='hamburger-menu-flyout-list-item  '])[1]")
	WebElement Apple;
	@FindBy(xpath ="//button[@class='btn btn-lg btn-block btn-primary']")
	WebElement Checkout;
	@FindBy(xpath ="//input[@id='fld-e']")
	WebElement useremail;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement continue1;
	@FindBy(xpath ="//input[@id='password-radio']")
	WebElement pwdradio;
	@FindBy(xpath ="//input[@id='fld-p1']")
	WebElement pwd;
	@FindBy(xpath ="//input[@id='firstName']")
	WebElement firstname;
	@FindBy(xpath ="//input[@id='lastName']")
	WebElement lastname;
	@FindBy(xpath ="//input[@id='street']")
	WebElement streetadd;
	@FindBy(xpath ="//input[@id='city']")
	WebElement cityadd;
	@FindBy(xpath ="//select[@id='state']")
	WebElement stateadd;
	@FindBy(xpath ="//input[@id='zipcode']")
	WebElement zipcodeadd;
	@FindBy(xpath ="//input[@id='save-for-billing-address-Map {}']")
	WebElement saveAddress;
	@FindBy(xpath ="//button[@class='c-button c-button-secondary c-button-md new-address-form__button']")
	WebElement Apply;
	@FindBy(xpath ="//button[@class='btn btn-lg btn-block btn-secondary']")
	WebElement scheduledelivery;
	
	public ShoppingCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void ValidateSearchAndAdd(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		seedetails.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)", "");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")));
		 try {
	            cartButton.click(); // Attempt to click the Add to Cart button
	        } catch (ElementClickInterceptedException e) {
	            // If intercepted, use JavaScript to click
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartButton);
	        }
	}
	public ShoppingCart ValidateAddtoCartFromDept() {
		WebElement label = driver.findElement(By.xpath("//div[@class='page-heading']"));
		Assert.assertTrue(label.getText().contains("Your Cart"));
		System.out.println("Product added in cart");
		return this;
	}
	public void AddtoCartFromBrand(){
		Brands.click();
		Apple.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WebElement label1 = driver.findElement(By.xpath("//h2[@id='flex-header-9bc5db23-9f62-4ded-8b58-511aee4ea7b9']"));
		Assert.assertTrue(label1.getText().contains("Shop all Apple"));
	}
	
	public ShoppingCart ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		return this;
	}
	public ShoppingCart Appliances() {
		Appliances.click();
		return this;
	}
	public ShoppingCart MajorKitchenAppliances() {
		MajorKitchenAppliances.click();
		return this;
	}
	public ShoppingCart Refrigerators() {
		Refrigerators.click();
		return this;
	}
	public ShoppingCart selectRefrigerators() {
		selectRefrigerators.click();
		return this;
	}
	public ShoppingCart Addtcart() {
		Addtcart.click();
		return this;
	}
	public ShoppingCart gotocart() {
		gotocart.click();
		return this;
	}
	public ShoppingCart cart() {
		cart.click();
		return this;
	}
	public ShoppingCart Wait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Checkout));
		return this;
	}
	public ShoppingCart Checkout() {
		Checkout.click();
		return this;
	}
	public ShoppingCart enter_email(String Email) {
		useremail.sendKeys(Email);
		return this;
	}
	public ShoppingCart continue1() {
		continue1.click();
		return this;
	}
	public ShoppingCart radioselect() {
		pwdradio.click();
		return this;
	}
	public ShoppingCart saveAddress() {
		saveAddress.click();
		return this;
	}
	public ShoppingCart Apply() {
		Apply.click();
		return this;
	}
	public ShoppingCart scheduledelivery() {
		scheduledelivery.click();
		return this;
	}
	
	public ShoppingCart enter_pass(String Password) {
		pwd.sendKeys(Password);
		return this;
	}
	public ShoppingCart enter_FirstName(String firstName) {
		firstname.sendKeys(firstName);
		return this;
	}
	public ShoppingCart enter_LastName(String lastName) {
		lastname.sendKeys(lastName);
		return this;
	}
	public ShoppingCart enter_Street(String street) {
		streetadd.sendKeys(street);
		return this;
	}
	public ShoppingCart enter_City(String city) {
		cityadd.sendKeys(city);
		return this;
	}
	public ShoppingCart enter_State(String state) {
		WebElement sel = stateadd;
		Select objSelect = new Select(sel);
		objSelect.selectByVisibleText("CA");
		return this;
	}
	public ShoppingCart enter_Zipcode(String ZipCode) {
		zipcodeadd.sendKeys(ZipCode);
		return this;
	}
}
