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

    @FindBy(xpath ="//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDesc\" and @text=\"Mencoba Expense Appium\"]")
    private MobileElement expenseDescription;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvAmount\" and @text=\"30.000\"]")
    private MobileElement expenseAmount;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDateOne\" and @text=\"12\"]")
    private MobileElement expenseDay;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDateTwo\"])")
    private MobileElement expenseMonthYear;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDateThree\" and @text=\"Selasa\"]")
    private MobileElement expenseDayName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\"]")
    private MobileElement expenseType;

    @FindBy(xpath ="//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDesc\" and @text=\"Mencoba Income Appium\"]")
    private MobileElement incomeDescription;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvAmount\" and @text=\"40.000\"]")
    private MobileElement incomeAmount;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDateOne\" and @text=\"29\"]")
    private MobileElement incomeDay;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDateTwo\"])")
    private MobileElement incomeMonthYear;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvDateThree\" and @text=\"Rabu\"]")
    private MobileElement incomeDayName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.chad.financialrecord:id/tvName\"]")
    private MobileElement incomeType;

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

    public String getTitleMonthlyValue(){
        return titleMonthly.getText();
    }

    public String getExpenseDescription(){
        return expenseDescription.getText();
    }

    public String getExpenseAmount(){
        return expenseAmount.getText();
    }

    public String getExpenseDay(){
        return expenseDay.getText();
    }

    public String getExpenseMonthYear(){
        return expenseMonthYear.getText();
    }

    public String getExpenseDayName(){
        return expenseDayName.getText();
    }

    public String getExpenseType(){
        return expenseType.getText();
    }

    public String getIncomeDescription(){
        return incomeDescription.getText();
    }

    public String getIncomeAmount(){
        return incomeAmount.getText();
    }

    public String getIncomeDay(){
        return incomeDay.getText();
    }

    public String getIncomeMonthYear(){
        return incomeMonthYear.getText();
    }

    public String getIncomeDayName(){
        return incomeDayName.getText();
    }

    public String getIncomeType(){
        return incomeType.getText();
    }
}
