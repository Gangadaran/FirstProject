package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.leaftaps.ui.baseclass.BaseClass;


public class WelcomePage extends BaseClass {

	public WelcomePage() {

	}
	
	public HomePage clickCRMSFA() {
		WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaElement.click();
		return new HomePage();
	}
	public LoginPage clickLogout() {
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		return new LoginPage();
	}
}
