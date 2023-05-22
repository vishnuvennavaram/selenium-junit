package org.automation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;



public class Locaters {
	 WebDriver driver = new ChromeDriver();
	 @Test
	 public void rahul() throws InterruptedException {
		 String username="rahul";
		 String expectedError="* Incorrect username or password";
		 driver.get("https://rahulshettyacademy.com/locatorspractice/"); 
		 driver.findElement(By.id("inputUsername")).sendKeys(username);
		 driver.findElement(By.name("inputPassword")).sendKeys("rahul123");
		 driver.findElement(By.className("signInBtn")).click();
		 Thread.sleep(2000);
		 String errorText = driver.findElement(By.cssSelector("p.error")).getText();
		 Thread.sleep(2000);
		 System.out.println(errorText);
		 // Assert.assertEquals(expectedError, errorText);
		 Assert.assertEquals(expectedError, driver.findElement(By.cssSelector("p.error")).getText());	
		 driver.close();
	 }
}
