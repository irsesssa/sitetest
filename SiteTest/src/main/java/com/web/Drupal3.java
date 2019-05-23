package com.web;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Drupal3 {
    @Test
    public void LaunchChrome_Method1() throws Exception {


        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
        String baseUrl="http://dev-realsport.pantheonsite.io";
        String username="admin-ira";


        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.xpath("//*[@id=\"block-bartik-content\"]/div/div/div/div/div/article/header/h2/a/span")).click();

        WebElement pageTitle=driver.findElement(By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/ul/li[3]/a"));
        pageTitle.click();

        WebElement usernameInput=driver.findElement(By.xpath("//*[@id=\"edit-name\"]"));
        usernameInput.sendKeys(username);

        WebElement passwordInput=driver.findElement(By.xpath("//*[@id=\"edit-pass\"]"));
        passwordInput.sendKeys("11111");

        WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"edit-submit\"]"));
        loginBtn.click();

        WebElement manageLnk=driver.findElement(By.xpath("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul"));
        manageLnk.click();

        WebElement peopleLnk=driver.findElement(By.xpath("//*[@id=\"toolbar-link-entity-user-collection\"]"));
        peopleLnk.click();

        WebElement addUserLnk=driver.findElement(By.xpath("//*[@id=\"block-seven-local-actions\"]/ul/li/a"));
        addUserLnk.click();

        String newRandomUser=RandomStringUtils.randomAlphanumeric(8);
        String newPassword = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("User='"+ newRandomUser +"'");
        System.out.println("Pass='"+ newPassword +"'");

        WebElement emailInput =driver.findElement(By.xpath("//*[@id=\"edit-mail\"]"));
        emailInput.sendKeys(newRandomUser+"@mail.com");
        WebElement usernameAddUserInput = driver.findElement(By.xpath("//*[@id=\"edit-name\"]"));
        usernameAddUserInput.sendKeys(newRandomUser);
        WebElement passwordAddUserInput= driver.findElement(By.xpath("//*[@id=\"edit-pass-pass1\"]"));
        passwordAddUserInput.sendKeys(newPassword);
        WebElement confirmPassUserInput =driver.findElement(By.xpath("//*[@id=\"edit-pass-pass2\"]"));
        confirmPassUserInput.sendKeys(newPassword);
        driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
        WebElement createNewAccount = driver.findElement(By.xpath("//*[@id=\"edit-submit\"]"));
       createNewAccount.click();
        WebElement infoMessage = driver.findElement(By.xpath("/html/body/div[2]/div/main/div[2]/div[2]/div"));
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(infoMessage));
        String actualMessageTxt=infoMessage.getText().trim().replace(" +"," ");
        String expectedMessage= "Created a new user account for " + newRandomUser +". No email has been sent.";
        Assert.assertTrue(StringUtils.contains(actualMessageTxt, expectedMessage));
    }
}
