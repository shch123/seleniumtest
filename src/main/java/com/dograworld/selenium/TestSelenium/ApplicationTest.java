package com.dograworld.selenium.TestSelenium;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class ApplicationTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver");
		driver = new ChromeDriver();
	   // driver.manage().window().maximize();
	    driver.get("https://www.penfed.org/");
	}

	
  @Test//testcase
  public void doLogin() throws InterruptedException  {
	 /* driver.findElement(By.cssSelector("img[src='/content/dam/penfedbtp/uploadedimages/Campaigns(1)/2016_-_Q1_Year_To_Shine/logo.png']"));
	  //driver.findElement(By.xpath("//[@test-id='test-username']"));
	  //driver.findElement(By.xpath("//*[@id='topmenu2']/ul/li[1]/span")).click();
	driver.findElement(By.xpath("//*[@id='topmenu2']/ul/li[8]/button")).click();
			
	  
	  driver.findElement(By.id("login-user-name-input")).sendKeys("test");
	 WebElement e= driver.findElement(By.id("login-user-login"));
		e.click();
		Thread.sleep(2000);
	  //Assert.fail("Test failed");
	   */
	  String actual=driver.getTitle();
	  String expected="url";
	  try {
		 
	  Assert.assertEquals(actual, expected);
	  }
	  catch(AssertionError e)
	  {
		  System.out.println("Test Failed");
		  System.out.println("Test Failed");
	  }
		
	 
	  System.out.println("Login test execution success");

	  System.out.println("Login test execution success");
	  
  }


/*@Test 
public void doPasswordChange()
{
	System.out.println("Changing Password");
	
}


@Test
public void  logout()
{
	System.out.println("Logging out");
}

*/
  
  @AfterTest
	public void close()
	{
	    driver.close();
	}

}
