package com.web.poms;

import com.web.core.AbstractPom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends AbstractPom {


    public Login(WebDriver driver) {
        super(driver);
    }

//WebElement pageTitle=driver.findElement(By.xpath("//*[@id='block-mainnavigation-2']/div/ul/li[3]/a"));
//WebElement usernameInput=driver.findElement(By.xpath("//*[@id='edit-name']"));
//WebElement passwordInput=driver.findElement(By.xpath("//*[@id='edit-pass']"));
// WebElement loginBtn=driver.findElement(By.xpath("//*[@id='edit-submit']"));

//String pageTitleStr="//*[@id='block-mainnavigation-2']/div/ul/li[3]/a";
//String usernameInputStr="//*[@id='edit-name']";
//String passwordInputStr="//*[@id='edit-pass']";
//String loginBtnStr="//*[@id='edit-submit']";

    By pageTitleLoc=By.xpath("//*[@id='block-mainnavigation-2']/div/ul/li[3]/a");
    By usernameInputLoc=By.xpath("//*[@id='edit-name']");
    By passwordInputLoc=By.xpath("//*[@id='edit-pass']");
    By loginBtnLoc=By.xpath("//*[@id='edit-submit']]");

        /*@FindBy(xpath="//*[@id='block-mainnavigation-2']/div/ul/li[3]/a")
        public WebElement pageTitle;*/

    @FindBy(xpath="//*[@id='edit-name']")
    public WebElement usernameInput;

    @FindBy(xpath="//*[@id='edit-pass']")
    public WebElement passwordInput;

    @FindBy(xpath="//*[@id='edit-submit']")
    public WebElement loginBtn;


    public void checkpageTitle(String value) {
        WebElement checkPageTitle=driver.findElement(pageTitleLoc);
        checkPageTitle.sendKeys(value);
    }

    public void usernameInput(String name) {
        WebElement usernameInput=driver.findElement(usernameInputLoc);
        usernameInput.sendKeys(name);
    }

    public void passwordInput(String pass) {
        WebElement passwordInput=driver.findElement(passwordInputLoc);
        passwordInput.sendKeys(pass);
    }

    public void loginBtn() {
        WebElement loginBtn=driver.findElement(loginBtnLoc);
        loginBtn.click();
    }
}