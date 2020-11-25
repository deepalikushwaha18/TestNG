package TestNG.TestNG_SDETTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	  @BeforeClass
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	    	  System.out.println("before Test");
			  String path = "C:\\Driver\\geckodriver.exe";
			    System.setProperty("webdriver.gecko.driver",path);
			    driver=new FirefoxDriver();
				//Open browser
	        //Open the browser
	        driver.get("https://www.training-support.net/selenium/login-form");
	    }
	
    @Test
	
    @Parameters({"username", "password"})
	
    public void loginTestCase(String username, String password) {
	
        //Find username and pasword fields
	
        WebElement usernameField = driver.findElement(By.id("username"));
	
        WebElement passwordField = driver.findElement(By.id("password"));
	
        
	
        //Enter values
	
        usernameField.sendKeys(username);
	
        passwordField.sendKeys(password);
	
        
	
        //Click Log in
	
        driver.findElement(By.cssSelector("button[type='submit']")).click();
	
        
	
        //Assert Message
	
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
	
    }
	
 
	
    @AfterClass
	
    public void afterClass() {
	
        //Close browser
	
        driver.close();
	
    }
}
