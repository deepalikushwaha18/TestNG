package TestNG.TestNG_SDETTraining;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;


public class Activity2 {
	WebDriver driver;
 
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
	  String path = "C:\\Driver\\geckodriver.exe";
	    System.setProperty("webdriver.gecko.driver",path);
	    driver=new FirefoxDriver();
		//Open browser
		
      driver.get("https://www.training-support.net/selenium/target-practice");
      
	
  }
  @Test
  public void testCase1() {
	  System.out.println("verifyTitle");
      // Check the title of the page
	  String  ActualAppTitle= driver.getTitle();
 	 System.out.println("ActualAppTitle:  "+ActualAppTitle);
	  String expectedAppTitle = "Target Practice" ;
			  Assert.assertEquals(ActualAppTitle,expectedAppTitle);

	  }
  @Test
	
  public void testCase2() {
	
      //This test case will Fail
	
      WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
	
      Assert.assertTrue(blackButton.isDisplayed());
	
      Assert.assertEquals(blackButton.getText(), "black");
	
  }
	
  
	
  @Test(enabled = false)
	
  public void testCase3() {
	
      //This test will be skipped and not counted
	
      String subHeading = driver.findElement(By.className("sub")).getText();
	
      Assert.assertTrue(subHeading.contains("Practice"));
	
  }
	
  
	
  @Test
	
  public void testCase4() {
	
      //This test will be skipped and will be be shown as skipped
	
      throw new SkipException("Skipping test case");      
	
  }
	

  
  @AfterMethod
	
  public void afterMethod() {
	  System.out.println("after method");
	
      //Close the browser
      driver.quit();
	
  }
	

}
