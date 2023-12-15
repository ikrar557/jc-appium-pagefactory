package com.juaracoding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

public class AddNewRecordPage extends PageBase{
    public AddNewRecordPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(id = "fabMenu")
    static MobileElement addNewRecord;

    public void clickAddNewRecord(){
        click(addNewRecord);
    }
}
