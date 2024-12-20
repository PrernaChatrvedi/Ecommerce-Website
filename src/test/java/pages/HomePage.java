package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	@FindBy(xpath ="//div[@lang='en']//img[@alt='United States']")
	WebElement country;
	@FindBy(xpath ="//span[text()='Account']")
	WebElement account;
	@FindBy(xpath ="//a[@class='c-button c-button-outline c-button-sm rounded-full ml-100 basis-1/2 ']")
	WebElement createaccount;
	@FindBy(xpath ="//a[text()='Sign In']")
	WebElement signup;
	@FindBy(xpath ="//footer//a")
	List<WebElement> footerLinks; 
	@FindBy(xpath ="//h1[text()='Choose a sign-in method']")
	WebElement checkforlogin;
	@FindBy(xpath ="//button[@aria-label='Menu']")
	WebElement mainmenu;
	@FindBy(xpath ="//button[@type='button']")
	List<WebElement> allpages; 
	@FindBy(xpath ="//input[@id='gh-search-input']")
	WebElement Searchbox;
	@FindBy(xpath ="//button[@class='header-search-button ']")
	WebElement Searchbutton;
	@FindBy(xpath ="//div[@class='bottom-nav-left-wrapper']//a")
	List<WebElement> Submenulinks; 
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public HomePage click_country() {
		country.click();
		return this;
	}
	public HomePage click_account() {
		account.click();
		return this;
	}
	public CreateAccount Create_Account() {
		createaccount.click();
		return new CreateAccount(driver);
	}
	public HomePage SearchBox() {
		Searchbox.sendKeys("iphone");
		return new HomePage(driver);
	}
	public ShoppingCart SearchButton() {
		Searchbutton.click();
		return new ShoppingCart(driver);
	}
	
	public SignUpPage SignUp() {
		signup.click();
		return new SignUpPage(driver);
	}
	public HomePage Click_menu() {
		mainmenu.click();
		return new HomePage(driver);
	}
	public ShoppingCart Click_Mainmenu() {
		mainmenu.click();
		return new ShoppingCart(driver);
	}
	
	
	public HomePage ValidateHomePage() {
		String actualText = account.getText();
		String expectedText = "account";
		Assert.assertEquals(actualText, expectedText);
		return this;
	}
	public HomePage ValidateBottomLinks() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		int links = footerLinks.size(); // Get the count of links
	    System.out.println("Number of links in footer: " + links);
	    Assert.assertEquals(56, links); // Verify the count
		for(WebElement link :footerLinks) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
                try {
                	findBrokenLink(url);
                } catch (IOException e) {
                    System.out.println("Error validating link: " + url + " - " + e.getMessage());
                }
            } else {
                System.out.println("Invalid link (href attribute is empty): " + link.getText());
            }
		}
		
		return this;
	}
	public HomePage validateSignUp(String testCase, String expected) {
		if(testCase.equals("ValidEmailAndValidPassword")) {
			String actual = "prerna27chaturvedi@gmail.com";
			SoftAssert assertObj = new SoftAssert();
			assertObj.assertEquals(actual, expected);
		
		} else if(testCase.equals("InvalidEmailAndValidPassword")) {
			String actual = checkforlogin.getText();
			SoftAssert assertObj = new SoftAssert();
			assertObj.assertEquals(actual, expected);
		}
		return this;
	}
	public void validateMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase timeout
	    // Locate all submenu links before starting the loop
	    List<WebElement> Submenulinks = driver.findElements(By.xpath("//div[@class='bottom-nav-left-wrapper']//a"));
	    for (int i = 0; i < Submenulinks.size()-2; i++) {
	    	System.out.println(Submenulinks.size());
	        try {
	            // Re-locate elements in case DOM refreshed
	            WebElement mainMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Menu']")));
	            Submenulinks = driver.findElements(By.xpath("//div[@class='bottom-nav-left-wrapper']//a"));

	            WebElement link = Submenulinks.get(i);
	            String submenuName = link.getText();
	            System.out.println("Clicking on submenu: " + submenuName);

	            // Click the submenu link
	            link.click();

	            // Wait for the main menu to appear on the new page
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Menu']")));

	            // Validate that the main menu is still visible
	            mainMenu = driver.findElement(By.xpath("//button[@aria-label='Menu']"));
	            if (mainMenu.isDisplayed()) {
	                System.out.println("SUCCESS: Main menu is present on page: " + driver.getCurrentUrl());
	            } else {
	                System.out.println("FAILURE: Main menu is not present on page: " + driver.getCurrentUrl());
	            }

	        } catch (Exception e) {
	            System.out.println("ERROR: Unexpected exception. " + e.getMessage());
	        } finally {
	            // Navigate back to the main menu page
	            driver.navigate().back();

	            // Wait for the main menu to load again before proceeding
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Menu']")));
	        }
	    }
			
	}
}
