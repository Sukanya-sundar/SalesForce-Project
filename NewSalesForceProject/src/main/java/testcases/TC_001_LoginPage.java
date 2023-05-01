package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBase;
import pages.LoginPage;

public class TC_001_LoginPage extends ProjectBase {
	@BeforeTest
	public void setup() {
		excelFile="LoginBook";
		testName ="Login Test";
		testDescription ="Login is entered successfully";
		testCategory ="Smoke";
		testAuthor="Sukanya";
		
		
	}
	
	
	@Test(dataProvider="fetchData")
	public void runLogin(String uname, String pwd) {
	
		LoginPage login= new LoginPage(driver ,node);
		login.enterUserName(uname).enterPassword(pwd).clickLoginButton();
		
	}
		
		

}
