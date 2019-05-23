package com.web;


import com.web.core.BaseTest;
import com.web.core.Helpers;
import com.web.poms.AddUser;
import com.web.poms.Login;
import com.web.poms.Menu;
import com.web.poms.People;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DrupalTests extends BaseTest {
    @Test
    public void addNewUserTest() {
        loginWithDefaultUser();
        Menu menu = new Menu(driver);
        if (!menu.peopleLnk.isDisplayed()) {
            menu.manageLnk.click();
        }
        menu.peopleLnk.click();

        People people = new People(driver);
        people.addUserBtn.click();

        AddUser addUser = new AddUser(driver);
        String newRandomUser = RandomStringUtils.randomAlphanumeric(8);
        String newPassword = RandomStringUtils.randomAlphanumeric(8);

        System.out.println("User='" + newRandomUser + "'");
        System.out.println("Pass='" + newPassword + "'");

        addUser.emailInput.sendKeys(newRandomUser + "@email.com");
        addUser.usernameAddUserInput.sendKeys(newRandomUser);
        addUser.passwordAddUserInput.sendKeys(newPassword);
        addUser.confirmPassInput.sendKeys(newPassword);
        driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
        addUser.createNewAccount.click();

        Helpers.waitForVisibleElement(driver, addUser.infoMessage, 20);
        String actualMessageTxt = addUser.infoMessage.getText().trim().replace(" \\s+", " ");
        String expectedMessage = "Created a new user account for " + newRandomUser + ". No email has been sent.";
        Assert.assertTrue(StringUtils.contains(actualMessageTxt, expectedMessage));
    }
}
