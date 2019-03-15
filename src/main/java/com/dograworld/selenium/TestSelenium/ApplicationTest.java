package com.dograworld.selenium.TestSelenium;



import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class ApplicationTest {
  @Test//testcase
  public void doLogin() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.gmail.com/");
	  driver.findElement(By.cssSelector("input#identifierId")).sendKeys("shdogra4@gmail.com");
	  WebElement e= driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		e.click();
		Thread.sleep(2000);
	  //Assert.fail("Test failed");
	 
	  System.out.println("Login test execution success");
  }


@Test 
public void doPasswordChange()
{
	System.out.println("Changing Password");
	
}


@Test
public void  logout()
{
	System.out.println("Logging out");
}



}
