package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBase;
import pages.LoginPage;

public class TC_002_CreateIndividualPage extends ProjectBase{
	@BeforeTest
	public void setup() {
		excelFile="NewIndividualBook";
		testName ="Login Test";
		testDescription ="Login is entered successfully";
		testCategory ="Smoke";
		testAuthor="Sukanya";
		
		
	}
	@Test(dataProvider="fetchData")
	public void runCreative(String uname, String pwd,String date, String Amt, String name) throws InterruptedException {
		LoginPage lp=new LoginPage(driver, node);
		lp.enterUserName(uname)
		.enterPassword(pwd)
		.clickLoginButton()
		.clickOpportunity()
		.clickNewButton()
		.enterName(name)
		.clickCloseDate(date)
		.clickStage()
		.clickQualification() 
		.enterAmount(Amt)
		.clickSave();
	
		
	}

}
