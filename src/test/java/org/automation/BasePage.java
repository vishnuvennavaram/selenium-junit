package org.automation;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
		
		WebDriver driver = getDriver();
		
		public WebDriver getDriver() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		
		@After
	    public void afterTest() {
	        driver.close();
	    }
		
		public void clickElement(By by) {
			driver.findElement(by).click();
		}
		
		public void enterText(By by, String text) {
			driver.findElement(by).sendKeys(text);
		}
		
		public void openUrl(String url) {
			driver.get(url);
		}
		
		public void openUrl() {
			driver.get("http://103.24.126.242:8020/workbench/app/signin");
		}
		
		public void dropdown(By by,String value) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			driver.findElement(by).findElement(By.cssSelector("div")).click();
			clickElement(By.cssSelector("[aria-label='" + value + "'] span"));
		}
		
		public void scrollToElement(By by) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement el=driver.findElement(by);
		    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", el);
		}
		
		public void loginToDip(String name,String password) {
			enterText(By.name("user_name"),name);
			enterText(By.name("password"), password);
			clickElement(By.className("loginBtn"));
		}
	
		public void clickUsingJsExecutor(By by) {
			WebElement element=driver.findElement(by);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	
		public void dropdownByJs(By by,String value) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			clickUsingJsExecutor(by);
			clickUsingJsExecutor(By.cssSelector("[aria-label='" + value + "'] span"));
		}
}
