package TestNG.TestNG_SDETTraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	 
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("before method");
		  String path = "C:\\Driver\\geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver",path);
		    driver=new FirefoxDriver();
			//Open browser
			
	      driver.get("https://www.training-support.net");
		
	  }
	  @Test
	  public void testCase1() {
		  System.out.println("verifyTitle");
	      // Check the title of the page
		  String  ActualAppTitle= driver.getTitle();
	 	 System.out.println("ActualAppTitle:  "+ActualAppTitle);
		  String expectedAppTitle = "Training Support" ;
				  Assert.assertEquals(ActualAppTitle,expectedAppTitle);

		  }
	  
	  @AfterMethod
		
	  public void afterMethod() {
		  System.out.println("after method");
		
	      //Close the browser
	      driver.quit();
		
	  }
}
