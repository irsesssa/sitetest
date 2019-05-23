package com.web.poms;

import com.web.controls.WebButton;
import com.web.controls.WebText;
import com.web.core.AbstractPom;
import com.web.core.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class Article extends AbstractPom {

    public Article(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//div[@role='contentinfo']")
    public WebText infoMessage;

    @FindBy(xpath="//article/div[contains(@class,'node__content')]/div")
    public WebText contentTxt;

    @FindBy(xpath = "//input[@value='Save']")
    public WebButton saveBtn;

    public void checkCreatedArticleMessage(String articleName){
        String message = "Article " + articleName + " has been created.";
        Helpers.check2StringIfEquals(infoMessage.getText(), message);
    }

}