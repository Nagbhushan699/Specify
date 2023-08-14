package com.specify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
WebDriver driver;
public Homepage(WebDriver driver) {
	this.driver=driver;
}
private By repo=By.xpath("//span[text()='Repositories']");
private By drop=By.xpath("//button[@aria-label='Menu']//div[@class='a-vector']//*[name()='svg']");
private By logout=By.xpath("//button[@class='m-menu-list__item--with-icon']");
public String getHomepageTitle() {
	
	String act=driver.findElement(repo).getText();
	return act;
}

public BaseLoginPage goBack() {
	driver.findElement(drop).click();
	driver.findElement(logout).click();	
	return new BaseLoginPage(driver);
}
}
