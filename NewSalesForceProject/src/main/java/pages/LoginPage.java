package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectBase;

public class LoginPage extends ProjectBase {
	public LoginPage(EdgeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node = node;
	
	}
	
	
	
	public LoginPage enterUserName(String UserName) {
		driver.findElement(By.id("username")).sendKeys(UserName);
		return this;
		
	}
	public LoginPage enterPassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
		return this;
	}
	public CreateIndividualPage clickLoginButton() {
		driver.findElement(By.id("Login")).click();
		return new CreateIndividualPage(driver, node);
	}

}
