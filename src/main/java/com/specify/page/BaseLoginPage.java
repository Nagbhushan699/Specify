package com.specify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseLoginPage {
  WebDriver driver;
	public BaseLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	private By signin=By.xpath("//p[normalize-space()='Sign in']");
	public void clickOnSignIn() {
		driver.findElement(signin).click();
	}
	public String getSignInText() {
		return driver.findElement(signin).getText();
	}
}
