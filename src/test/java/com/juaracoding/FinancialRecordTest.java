package com.juaracoding;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.juaracoding.PageBase.delay;

public class FinancialRecordTest extends TestBase{
    AddNewRecordPage addNewRecordPage;
    CreateInputPage createInputPage;
    public void performExpenseRecordCreation(String recordType, String amount, String notes) {
        addNewRecordPage.clickCloseButtonAlerts();
        addNewRecordPage.clickAddNewRecord();

        if ("Expense".equals(recordType)) {
            createInputPage.clickExpenseButton();
        } else if ("Income".equals(recordType)) {
            createInputPage.clickIncomeButton();
        }

        createInputPage.setExpenseDate();
        createInputPage.setExpenseCategory();
        createInputPage.enterAmount(amount);
        createInputPage.enterNotes(notes);
    }

    //TODO: Fix the code, so the date and category shouldn't be redundant and can be user defined
    public void performIncomeRecordCreation(String recordType, String amount, String notes) {
        addNewRecordPage.clickAddNewRecord();

        if ("Expense".equals(recordType)) {
            createInputPage.clickExpenseButton();
        } else if ("Income".equals(recordType)) {
            createInputPage.clickIncomeButton();
        }
        createInputPage.setIncomeDate();
        createInputPage.setIncomeCategory();
        createInputPage.enterAmount(amount);
        createInputPage.enterNotes(notes);
    }

    @BeforeClass
    public void testEnvironmentSetup() throws MalformedURLException {
        try {
            Android_RealDevice_setUp();
        } catch (WebDriverException e) {
            System.out.println("Real device setup failed. Using emulator instead.");
            Android_Emulator_setUp();
        }

        addNewRecordPage = new AddNewRecordPage(driver);
        createInputPage = new CreateInputPage(driver);
    }

    // TODO: Add test case negative if possible

    @Test(priority = 1)
    public void testInputExpense(){
        performExpenseRecordCreation("Expense", "30000", "Mencoba Expense Appium");
        Assert.assertEquals(createInputPage.getDateValue(), "12 Des 2023");
        Assert.assertEquals(createInputPage.getExpenseCategoryValue(), "Kesehatan");
        Assert.assertEquals(createInputPage.getAmountValue(), "30,000");
        Assert.assertEquals(createInputPage.getNotesValue(), "Mencoba Expense Appium");
        createInputPage.clickSaveButton();
    }

    @Test(priority = 2)
    public void testInputIncome(){
        performIncomeRecordCreation("Income", "40000", "Mencoba Income Appium");
        Assert.assertEquals(createInputPage.getDateValue(), "29 Nov 2023");
        Assert.assertEquals(createInputPage.getIncomeCategoryValue(), "Penjualan");
        Assert.assertEquals(createInputPage.getAmountValue(), "40,000");
        Assert.assertEquals(createInputPage.getNotesValue(), "Mencoba Income Appium");
        createInputPage.clickSaveButton();
    }

    @Test(priority = 3)
    public void testTitleMonthly(){
        createInputPage.clickTitleMonthly();
        Assert.assertEquals(createInputPage.getTitleMonthlyValue(), "Bulanan");
    }
}
