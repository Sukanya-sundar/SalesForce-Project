package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBase;
import pages.LoginPage;

public class TC_003_NewIndividualPage extends ProjectBase{
	@BeforeTest
	public void setup() {
		excelFile="NewIndividualBook";
		testName ="Login Test";
		testDescription ="Login is entered successfully";
		testCategory ="Smoke";
		testAuthor="Sukanya";
		
		
	}
	@Test(dataProvider="fetchData")
	public void runNew(String uname, String pwd, String name, String date, String Amt) throws IOException, InterruptedException {
		LoginPage lp=new LoginPage(driver, node);
		lp.enterUserName(uname)
		.enterPassword(pwd)
		.clickLoginButton()
		.clickOpportunity()
		.clickNewButton()
		.enterName(name)
		.enterAccountName()
		.selectname()
		.clickCloseDate(date)
		.clickStage()
		.clickQualification() 
		
		.enterAmount(Amt)
		.clickSave();
		}

}
