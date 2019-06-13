package com.dograworld.selenium.Jason;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.ParseException;

public class ReadJason {
	 WebDriver driver;
	    String url,searchWord,linkText;
	    JSONParser parser=new JSONParser();
	    
	    @BeforeTest
	    public void setup() throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException 
	    {
	        System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/shaweta/selenium/chromedriver");
	        Object obj = parser.parse(new FileReader("/Users/admin/Documents/shaweta/docs/link.jason"));
	        JSONObject jsonObject = (JSONObject) obj;
	        url = (String) jsonObject.get("URL");
	        searchWord = (String) jsonObject.get("SearchWord");
	        linkText = (String) jsonObject.get("linkSearch");
	            
	        driver = new ChromeDriver();
	        driver.get(url);
	        
	    }
	    
	    @Test
	    public void testSearch() throws FileNotFoundException, IOException, ParseException {
	    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	    
	        driver.findElement(By.name("q")).sendKeys(searchWord);
	        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK"))).click();
	       //driver.findElement(By.name("btnK")).click();
	       // driver.findElement(By.linkText(linkText)).click();
	        driver.findElement(By.xpath("//a[contains(.,'Katalon Studio: Simplify API')]")).click();
	        
	        String webTitle = driver.getTitle();
	        
	        Assert.assertEquals(webTitle, linkText);
	    }
	    
	    @AfterTest
	    public void tearDown()
	    {
	        driver.close();
	        driver.quit();

	    }
	}


