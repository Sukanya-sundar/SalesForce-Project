package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectBase;

public class NewIndividualPage extends ProjectBase {
	public NewIndividualPage(EdgeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public NewIndividualPage enterName(String name) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		return this;
	}
	public NewIndividualPage enterAccountName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		return this;
	}
	public NewIndividualPage selectname() {
		driver.findElement(By.xpath("(//li[@class='slds-listbox__item'])[2]")).click();
		return this;
	}
	public NewIndividualPage clickCloseDate(String date) {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date);
		return this;
	}
	public NewIndividualPage clickStage() {
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
		return this;
	}
	public NewIndividualPage clickQualification() {
		driver.findElement(By.xpath("//span[@title='Qualification']")).click();
		return this;
	}
	public NewIndividualPage enterAmount(String amt) {
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amt);
		return this;
	}
	public EditIndividualPage clickSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new EditIndividualPage(driver, node);
	}

}
