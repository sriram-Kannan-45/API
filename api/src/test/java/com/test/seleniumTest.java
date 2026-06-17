package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumTest {
  @Test
  public void f() {
	  
	  WebDriver driver = new ChromeDriver();
	  
	  try
	  {
		  driver.get("https://jsonplaceholder.typicode.com/");
		  
		  String currentUrl = driver.getCurrentUrl();
		  
		  System.out.println("Current URL: " + currentUrl);
		  
		  Assert.assertTrue(currentUrl.contains("jsonplaceholder"));
		  
	  }
	  
		finally {
			driver.quit();
		}
  }
}
