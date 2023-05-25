package org.automation;

//import javax.lang.model.element.Element;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class PolicyEngine extends BasePage{
	
	@Test
	public void createPolicy() throws InterruptedException {
	openUrl();
	loginToDip("Raveena","29@Raveena");
	Thread.sleep(2000);
	clickElement(By.className("icon-policy-active"));
	clickElement(By.className("icon-policy-data-active"));
	Thread.sleep(2000);
	clickElement(By.className("icon-bigdata-privacy-control"));
	Thread.sleep(5000);
	Thread.sleep(2000);
	clickElement(By.xpath("//span[contains(text(),'ADD')]"));
	Thread.sleep(5000);
	
	clickElement(By.xpath("//label[contains(text(),'Category ')]/../p-dropdown/div"));
	clickElement(By.cssSelector("[aria-label='Identifying purpose'] span"));
	
	enterText(By.name("identification"), "engine");
	enterText(By.name("policyName"), "engine");
	enterText(By.name("principle"),"engine");
	enterText(By.name("focusarea"),"engine");
	enterText(By.name("references"), "engine");
	enterText(By.name("securityControlName"), "engi");
	enterText(By.name("securityControlDescription"),"engi");
	dropdown(By.id("dataApplicability"), "Department");
	dropdown(By.xpath("//p-dropdown[@id='ownership']"),"Common");
	
	dropdown(By.id("alertNotification"), "Yes");
	dropdown(By.id("dataLossPrevention"),"Yes");
	dropdown(By.id("regulatoryRequirement"),"Yes");
	clickElement(By.xpath("//span[contains(text(),'Add')]/.."));
	Thread.sleep(2000);
	clickElement(By.xpath("(//span[contains(text(),'SAVE')])[2]"));
	Thread.sleep(10000);
	clickElement(By.xpath("//span[contains(text(),'Identifying purpose')]"));
	Thread.sleep(2000);
	clickElement(By.xpath("//td[contains(text(),' engine ')]/..//img[@alt='delete']"));
	Thread.sleep(3000);
	clickElement(By.xpath("//span[contains(text(),'YES')]/.."));
	Thread.sleep(5000);
	Assert.assertFalse(driver.findElements(By.xpath("//td[contains(text(),' engine ')]/..//img[@alt='delete']")).size()>0);

	
	//validate 
	//delete
	
	
	
	
		
	}
	
	@Test
	public void createAndDeletePolicy() throws InterruptedException {
		openUrl();
		loginToDip("Raveena","29@Raveena");
		Thread.sleep(2000);
		
		clickElement(By.className("icon-policy-active"));
		clickElement(By.className("icon-policy-data-active"));
		Thread.sleep(2000);
		clickElement(By.className("icon-bigdata-privacy-control"));
		Thread.sleep(5000);
		clickElement(By.id("add-subcategories"));
		enterText(By.id("add-subcategories"),"engine");
		clickElement(By.xpath("//span[contains(text(),' Add ')]"));
		Thread.sleep(4000);
		clickElement(By.xpath("//span[contains(text(),'engine')]/.."));
		Thread.sleep(2000);
		clickElement(By.xpath("//span[contains(text(),'engine')]/..//img[@alt='Delete']"));
		Thread.sleep(2000);
		clickElement(By.xpath("//span[contains(text(),'YES')]/.."));
		Thread.sleep(4000);
		
	}

}

