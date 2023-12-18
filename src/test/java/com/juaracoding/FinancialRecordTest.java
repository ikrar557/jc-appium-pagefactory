package com.juaracoding;

import com.beust.ah.A;
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

    private void assertExpenseRecord(String notes, String amount, String day, String monthYear, String dayName, String type) {
        Assert.assertEquals(createInputPage.getExpenseDescription(), notes);
        Assert.assertEquals(createInputPage.getExpenseAmount(), amount);
        Assert.assertEquals(createInputPage.getExpenseDay(), day);
        Assert.assertEquals(createInputPage.getExpenseMonthYear(), monthYear);
        Assert.assertEquals(createInputPage.getExpenseDayName(), dayName);
        Assert.assertEquals(createInputPage.getExpenseType(), type);
    }

    private void assertIncomeRecord(String notes, String amount, String day, String monthYear, String dayName, String type) {
        Assert.assertEquals(createInputPage.getIncomeDescription(), notes);
        Assert.assertEquals(createInputPage.getIncomeAmount(), amount);
        Assert.assertEquals(createInputPage.getIncomeDay(), day);
        Assert.assertEquals(createInputPage.getIncomeMonthYear(), monthYear);
        Assert.assertEquals(createInputPage.getIncomeDayName(), dayName);
        Assert.assertEquals(createInputPage.getIncomeType(), type);
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

    @Test(priority = 1)
    public void testInputExpense() {
        performExpenseRecordCreation("Expense", "30000", "Mencoba Expense Appium");
        createInputPage.clickSaveButton();
        assertExpenseRecord("Mencoba Expense Appium", "30.000", "12", "12.2023", "Selasa", "Kesehatan");
    }

    @Test(priority = 2)
    public void testInputIncome() {
        performIncomeRecordCreation("Income", "40000", "Mencoba Income Appium");
        createInputPage.clickSaveButton();
        assertIncomeRecord("Mencoba Income Appium", "40.000", "29", "11.2023", "Rabu", "Penjualan");
    }


    @Test(priority = 3)
    public void testTitleMonthly(){
        createInputPage.clickTitleMonthly();
        Assert.assertEquals(createInputPage.getTitleMonthlyValue(), "Bulanan");
    }
}
