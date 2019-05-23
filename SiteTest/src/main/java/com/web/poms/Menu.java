package com.web.poms;

import com.web.core.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Menu extends AbstractPom {

    public Menu(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"block-mainnavigation-2\"]/div/ul/li[3]/a")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"edit-name\"]")
    public WebElement logoutLnk;

    @FindBy(xpath = "//div[@id='toolbar-administration']//a[text()='Manage']")
    public WebElement manageLnk;

    @FindBy(xpath = "//div[@class='toolbar-menu-administration']//a[text()='People']")
    public WebElement peopleLnk;

    @FindBy(xpath = "//*[@id=\"toolbar-link-system-admin_content\"]")
    public WebElement contentLnk;
}