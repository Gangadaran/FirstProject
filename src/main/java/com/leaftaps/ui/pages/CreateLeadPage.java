package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.leaftaps.ui.baseclass.BaseClass;


public class CreateLeadPage extends BaseClass {

	public CreateLeadPage() {

	}

	public CreateLeadPage enterCompanyName(String companyName) {
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys(companyName);
		return this;
	}

	public CreateLeadPage enterFirstName(String firstName) {
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys(firstName);
		return this;
	}

	public CreateLeadPage enterLastName(String lastName) {
		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys(lastName);
		return this;
	}

	public ViewLeadPage clickCreateLeadButton() {
		WebElement elementCreateLeadButton = driver.findElement(By.name("submitButton"));
		elementCreateLeadButton.click();
		return new ViewLeadPage();
	}
}
