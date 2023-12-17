package com.juaracoding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class CreateInputPage extends PageBase{

    private AppiumDriver driver;
    public CreateInputPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(id = "btnExpense")
    private MobileElement expenseButton;

    @FindBy(id = "btnIncome")
    private MobileElement incomeButton;

    @FindBy(id = "tvDate")
    private MobileElement date;

    @FindBy(xpath = "//android.view.View[@content-desc='12 Desember 2023']")
    private MobileElement expenseDate;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Bulan sebelumnya\"]")
    private MobileElement previousMonth;

    @FindBy(xpath = "//android.view.View[@content-desc='29 November 2023']")
    private MobileElement incomeDate;

    @FindBy(id = "android:id/button1")
    private MobileElement okInDate;

    @FindBy(id = "spCategory")
    private MobileElement category;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\" and @text=\"Kesehatan\"]")
    private MobileElement expenseCategory;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\" and @text=\"Penjualan\"]")
    private MobileElement incomeCategory;

    @FindBy(id = "etAmount")
    private MobileElement addAmount;

    @FindBy(id = "etNote")
    private MobileElement addNotes;

    @FindBy(id = "btSave")
    private MobileElement saveButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvTitle\" and @text=\"Bulanan\"]")
    private MobileElement titleMonthly;

    public void clickExpenseButton(){
        click(expenseButton);
    }
    public void clickIncomeButton(){
        click(incomeButton);
    }

    public void setExpenseDate(){
        click(date);
        click(expenseDate);
        click(okInDate);
    }

    public void setIncomeDate(){
        click(date);
        click(previousMonth);
        click(incomeDate);
        click(okInDate);
    }

    public void setExpenseCategory(){
        click(category);
        delay(1);
        click(expenseCategory);
    }

    public void setIncomeCategory(){
        click(category);
        delay(1);
        click(incomeCategory);
    }

    public void enterAmount(String amount){
        click(addAmount);
        sendText(addAmount, amount);
    }

    public void enterNotes(String notes){
        clear(addNotes);
        sendText(addNotes, notes);
    }

    public void clickSaveButton(){
        click(saveButton);
    }

    public void clickTitleMonthly(){
        click(titleMonthly);
    }

    public String getDateValue(){
        return date.getText();
    }

    public String getExpenseCategoryValue(){
        return expenseCategory.getText();
    }

    public String getIncomeCategoryValue(){
        return incomeCategory.getText();
    }
    public String getAmountValue(){
        return addAmount.getText();
    }

    public String getNotesValue(){
        return addNotes.getText();
    }

    public String getTitleMonthlyValue(){
        return titleMonthly.getText();
    }

}
