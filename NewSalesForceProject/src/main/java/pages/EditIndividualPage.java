package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectBase;

public class EditIndividualPage extends ProjectBase {
	public EditIndividualPage(EdgeDriver  driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}

	public EditIndividualPage clickEdit() {
		driver.findElement(By.xpath("//button[text()='Edit']")).click();
		return this;
		}
	public EditIndividualPage clearAmount() {
		driver.findElement(By.xpath("//input[@name='Amount']")).clear();
		return this;
	}
	public EditIndividualPage enterClearAmount(String pay) {
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(pay);
		return this;
	}
	public EditIndividualPage clickFinalSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return this;
	}

}
