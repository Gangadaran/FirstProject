package com.leaftaps.ui.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.baseclass.BaseClass;
import com.leaftaps.ui.pages.LoginPage;

public class CreateLead extends BaseClass {
	@BeforeTest
	public void setData() {
		excelFileName = "tc002";
		testName = "CreateLead";
		testDescription = "Create Lead with mandatory info";

		testCategory = "functional";

		testAuthor = "Gangadaran";
	}

	@Test(dataProvider = "testData")
	public void test(String username, String password, String companyName, String firstName, String lastName) throws IOException {

//	LoginPage page = new LoginPage();
//	page.enterUsername(username);
//	page.enterPassword(password);
//	page.clickLogin();
//	
//	WelcomePage page2 = new WelcomePage();
//	page2.clickCRMSFA();

		new LoginPage().enterUsername(username).enterPassword(password).clickLogin().clickCRMSFA().clickLeads()
				.clickCreateLeadLink().enterCompanyName(companyName).enterFirstName(firstName).enterLastName(lastName)
				.clickCreateLeadButton();

	}
}
