package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TC_Contacts_003 extends TestBase {
	
	LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    
    String sheetName = "contacts";

    public TC_Contacts_003() {
        super();
    }
    
    @BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
    
/*    @Test(priority = 1)
    public void validateContactsPageLabelTest() {
    	Assert.assertTrue(contactsPage.validateContactsPageLabel());
    }
    
    @Test(priority = 2)
    public void selectContactsTest() {
    	contactsPage.selectContactsByName("a b");
    }
    
    @Test(priority = 3)
    public void selectMultipleContactsTest() {
    	contactsPage.selectContactsByName("aa bb");
    }
    */
    
    @DataProvider
    public Object[][] getCRMTestData() {
    	Object[][] data = TestUtil.getTestData(sheetName);
    	return data;
    }
    
    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
    	driver.navigate().refresh();
    	testUtil.switchToFrame();
    	homePage.clickOnNewContactLink();
   // 	contactsPage.createNewContact("Mr.", "Mike", "Myers", "Nevasa");
    	contactsPage.createNewContact(title, firstname, lastname, company);
    	
    }
    
    
    
    @AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
