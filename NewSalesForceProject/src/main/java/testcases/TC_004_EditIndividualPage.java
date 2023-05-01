package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBase;
import pages.LoginPage;

public class TC_004_EditIndividualPage extends ProjectBase {
	@BeforeTest
	public void setup() {
		excelFile="EditIndividualBook";
		testName ="Login Test";
		testDescription ="Login is entered successfully";
		testCategory ="Smoke";
		testAuthor="Sukanya";
		
		
	}
	@Test(dataProvider="fetchData")
	public void runEdit(String uname, String pwd,String name, String date, String Amt, String pay) throws InterruptedException {
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
		.clickSave()
		.clickEdit()
		.clearAmount()
		.enterClearAmount(pay)
		.clickFinalSave();
	
		
		
	}

}
