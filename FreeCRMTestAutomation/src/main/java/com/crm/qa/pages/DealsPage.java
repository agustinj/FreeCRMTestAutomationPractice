package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(name = "title")
	@CacheLookup
	WebElement title;
	
	@FindBy(name = "client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(name = "contact_lookup")
	@CacheLookup
	WebElement primaryContact;
	
	@FindBy(name = "amount")
	@CacheLookup
	WebElement amount;
	
	@FindBy(name = "probability")
	@CacheLookup
	WebElement probability;
	
	@FindBy(name = "commission")
	@CacheLookup
	WebElement commission;
	
	@FindBy(name = "identifier")
	@CacheLookup
	WebElement identifier;
	
//	@FindBy(name = "product_id")
//	WebElement productDropdown;
	
	@FindBy(name = "quantity")
	@CacheLookup
	WebElement quantity;
	
//	@FindBy(name = "type")
//	WebElement typeDropdown;
	
//	@FindBy(name = "source")
//	WebElement sourceDropdown;
	
	@FindBy(xpath = "//body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[2]")
	@CacheLookup  
	WebElement saveBtn;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewDeal(String tit, String comp, String pContact, String ident, String product_id, String type, String source) {
		
		title.sendKeys(tit);
		company.sendKeys(comp);
		primaryContact.sendKeys(pContact);
		identifier.sendKeys(ident);
		Select selectProduct = new Select(driver.findElement(By.name("product_id")));
		selectProduct.selectByVisibleText(product_id);
//		quantity.clear();
		Select selectType = new Select(driver.findElement(By.name("type")));
		selectType.selectByVisibleText(type);
		Select selectSource = new Select(driver.findElement(By.name("source")));
		selectSource.selectByVisibleText(source);
		
		
		saveBtn.click();
	}
	
	
}
