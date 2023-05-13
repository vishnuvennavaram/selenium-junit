package org.automation;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {
    // Test1
    // Login successfully - HOME button

    // Test2
    // Forgot password  - texts. buttons, input

    // Test3
    // wrong password - error message

    WebDriver driver = new ChromeDriver();

    @Test
    public void test1() {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.name("email")).sendKeys("raveena");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("raveena avala");
        driver.findElement(By.name("login")).click();
        boolean home = driver.findElement(By.xpath("//span[contains(text(),'Home')]")).isDisplayed();

        Assert.assertTrue(home);
    }

    @Test
    public void test2() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Forgotten password?")).click();
        driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']")).isDisplayed());

    }

    @Test
    public void test3() {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("vennavaram1992@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("raveena avala");
        driver.findElement(By.name("login")).click();
        String password = driver.findElement(By.linkText("Forgotten password?")).getText();
        Assert.assertEquals("Forgotten password?", password);
    }
    @Test
    public void test4() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).sendKeys("raveena");
        driver.findElement(By.name("lastname")).sendKeys("avala");
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password_step_input']")).click();
        Thread.sleep(5000);
        String password = driver.findElement(By.name("reg_passwd__")).getText();
        Assert.assertEquals("Enter a combination of at least six numbers, letters and punctuation marks (such as ! and &).", password);
    }

    @After
    public void afterTest() {
        driver.close();
    }
}

