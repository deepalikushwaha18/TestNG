package TestNG.TestNG_SDETTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Activity7{
	
	WebDriver driver;
	
	
@BeforeMethod
public void beforeClass() {
	  System.out.println("before method");
	  String path = "C:\\Driver\\geckodriver.exe";
	    System.setProperty("webdriver.gecko.driver",path);
	    driver=new FirefoxDriver();
		//Open browser
		
    driver.get("https://www.training-support.net/selenium/login-form");
	
}

@DataProvider(name = "Authentication")
public static Object[][] credentials(){
	return new Object[][]{{"admin", "password"}};
}

@Test(dataProvider = "Authentication")
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