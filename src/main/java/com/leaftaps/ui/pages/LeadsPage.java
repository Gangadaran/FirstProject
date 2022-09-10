package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.leaftaps.ui.baseclass.BaseClass;


public class LeadsPage extends BaseClass {

	public LeadsPage() {

	}
	public CreateLeadPage clickCreateLeadLink() {
		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
		return new CreateLeadPage();
	}
}
