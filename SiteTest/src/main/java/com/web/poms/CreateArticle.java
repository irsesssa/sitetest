package com.web.poms;

import com.web.controls.WebButton;
import com.web.controls.WebTextInput;
import com.web.core.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateArticle extends AbstractPom {

    public CreateArticle(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//div[label[contains(text(),'Title')]]/input[contains(@id,'edit-title')]")
    public WebTextInput titleInput;

    @FindBy(xpath = "//body")
    private WebElement contentInput;

    public void fillInContent(String value){
        driver.switchTo().frame(0);
        contentInput.sendKeys(value);
        driver.switchTo().defaultContent();
    }

    @FindBy(xpath = "//input[@value='Save']")
    public WebButton saveBtn;

}
