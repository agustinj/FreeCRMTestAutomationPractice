package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TC_Deals_004 extends TestBase {
	
	LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    DealsPage dealsPage;
    
    String sheetName = "deals";

    public TC_Deals_004() {
        super();
    }
    
    @BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
		
	}
    
/*    @DataProvider
    public Object[][] getCRMTestData() {
    	Object[][] data = TestUtil.getTestData(sheetName);
    	return data;
    }   */
    
/*    @Test(priority = 1, dataProvider = "getCRMTestData")
    public void validateCreateNewDeal(String title, String company, String primaryContact, String identifier, String product, String type, String source) {
    	driver.navigate().refresh();
    	testUtil.switchToFrame();
    	homePage.clickOnNewDealLink();
    	
    	dealsPage.createNewDeal(title, company, primaryContact, identifier, product, type, source);
    	
    }  */
    
    @Test(priority = 2)
    public void validateCreateNewDeal() {
    	driver.navigate().refresh();
    	testUtil.switchToFrame();
    	homePage.clickOnNewDealLink();
    	
    	dealsPage.createNewDeal("Option No 1", "Amazon", "Mike Michaels", "alc", "Laptop", "New", "Existing Customer");
    	
    }
    
    
    @AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
