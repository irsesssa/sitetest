package com.web.poms;

import com.web.controls.WebLink;
import com.web.core.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddContent extends AbstractPom {

    public AddContent(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//ul/li/a/span[text()='Article']")
    public WebLink articleLnk;

    @FindBy(xpath = "//ul/li/a/span[text()='Basic page']")
    public WebLink basicPageLnk;

}