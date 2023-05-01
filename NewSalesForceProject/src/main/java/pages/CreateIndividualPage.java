package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectBase;

public class CreateIndividualPage extends ProjectBase {
	public CreateIndividualPage(EdgeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}
	public CreateIndividualPage clickIcon(){
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	return this;
	}
	public CreateIndividualPage clickViewAll() {
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	return this;
	}
	public CreateIndividualPage clickSales() {
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	return this;
	}
    public CreateIndividualPage clickOpportunity() throws InterruptedException {
		Thread.sleep(2000);
			WebElement press = driver.findElement(By.xpath("//a[@class='slds-context-bar__label-action dndItem']/span[text()='Opportunities']"));
			driver.executeScript("arguments[0].click();",press);
		return this;
	}
	

	public NewIndividualPage clickNewButton() throws InterruptedException {
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.xpath("//a[@class='forceActionLink']"));
		driver.executeScript("arguments[0].click();", button);
		return new NewIndividualPage(driver, node);
	}

}
