package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsPageLabel;
	
//	@FindBy(name = "title")
//	WebElement titleDropdown;
	
	@FindBy(id = "first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id = "surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath = "//body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[2]")
	@CacheLookup
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']" + 
				"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public boolean validateContactsPageLabel() {
		return contactsPageLabel.isDisplayed();
	}
	
	public void createNewContact(String title, String ftName, String ltName, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
}
