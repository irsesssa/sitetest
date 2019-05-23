package com.web.poms;

import com.web.controls.WebButton;
import com.web.core.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class People extends AbstractPom{

    public People(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add user']")
    public WebButton addUserBtn;

}