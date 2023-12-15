package com.juaracoding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class CreateInputPage extends PageBase{
    public CreateInputPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(id = "btnExpense")
    private MobileElement expenseButton;

    @FindBy(id = "btnIncome")
    private MobileElement incomeButton;

    @FindBy(id = "tvDate")
    private MobileElement setDate;

    @FindBy(id = "spCategory")
    private MobileElement chooseCategory;

    @FindBy(id = "etAmount")
    private MobileElement addAmount;

    @FindBy(id = "etNote")
    private MobileElement addNotes;

    @FindBy(id = "btSave")
    private MobileElement saveButton;

    public void clickExpenseButton(){
        click(expenseButton);
    }
    public void clickIncomeButton(){
        click(incomeButton);
    }

    public void enterAmount(String amount){
        sendText(addAmount, amount);
    }

    public void enterNotes(String notes){
        sendText(addNotes, notes);
    }

    public void clickSaveButton(){
        click(saveButton);
    }


}
