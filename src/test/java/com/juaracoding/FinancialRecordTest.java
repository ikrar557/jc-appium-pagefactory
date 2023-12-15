package com.juaracoding;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FinancialRecordTest extends TestBase{
    AddNewRecordPage addNewRecordPage;
    CreateInputPage createInputPage;
    public void performRecordCreation(String recordType, String amount, String notes) {
        addNewRecordPage.clickAddNewRecord();

        // TODO: Add date and category test

        if ("Expense".equals(recordType)) {
            createInputPage.clickExpenseButton();
        } else if ("Income".equals(recordType)) {
            createInputPage.clickIncomeButton();
        }

        createInputPage.enterAmount(amount);
        createInputPage.enterNotes(notes);
        createInputPage.clickSaveButton();
    }

    @BeforeClass
    public void testEnvironmentSetup() throws MalformedURLException {
        Android_RealDevice_setUp();
        addNewRecordPage = new AddNewRecordPage(driver);
        createInputPage = new CreateInputPage(driver);
    }

    @Test(priority = 1)
    public void testInputExpense(){
        performRecordCreation("Expense", "30000", "Mencoba Expense Appium");
    }

    @Test(priority = 2)
    public void testInputIncome(){
        performRecordCreation("Income", "40000", "Mencoba income Appium");
    }
}
