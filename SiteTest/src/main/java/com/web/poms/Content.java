package com.web.poms;
import com.web.controls.WebButton;
import com.web.core.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Content extends AbstractPom{

    public Content(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"toolbar-item-shortcuts-tray\"]/nav/ul/li[2]/a")
    public WebButton addContentBtn;

}
