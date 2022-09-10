package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.baseclass.BaseClass;


public class LoginPage extends BaseClass {

	public LoginPage() {
		

	}

	public LoginPage enterUsername(String username) throws IOException {
		try {
			WebElement usernameElement = driver.findElement(By.id("username"));
			usernameElement.sendKeys(username);
			reportStep("Enter username is successfully", "pass");
		} catch (Exception e) {
			reportStep("Enter username is successfully", "fail");

		}
//		LoginPage obj = new LoginPage();
//		return obj; 
		return this;
	}


		
	

	public LoginPage enterPassword(String password) {
		try {
			WebElement passwordElement = driver.findElement(By.id("password"));
			passwordElement.sendKeys(password);
			

		} catch (Exception e) {

		}
		return this;
	}

	public WelcomePage clickLogin() {
		try {
			WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
			loginButton.click();

		} catch (Exception e) {

		}
		return new WelcomePage();
	}

	
}
