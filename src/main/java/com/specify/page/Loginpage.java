package com.specify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	private WebDriver driver;
	Homepage home;
	BaseLoginPage baseLogin;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	}
	private By email=By.id("email");
	private By password=By.id("password");
	private By login=By.cssSelector("[type='submit']");
	private By unSuccessfulMsg=By.xpath("//div[@class='m-info-box m-info-box--error']");

	private By popup=By.xpath("//*[text()='Please enter an email.']");
	public String getTitle() {
		return driver.getTitle();
	}
	public void doLogin(String usn,String pass) {
		clearTxt();
		driver.findElement(email).sendKeys(usn);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
	}
	public void clearTxt() {
		driver.findElement(email).clear();;
		driver.findElement(password).clear();;
	}
	public String loginWithValidCredentials(String usn,String pass) {
		doLogin(usn,pass);
		home=new Homepage(driver);
		String actual=home.getHomepageTitle();
		baseLogin= home.goBack();
		return actual;
	}
	public String loginWithInValidCredentials(String usn,String pass) {
		doLogin(usn,pass);
		String txt=driver.findElement(unSuccessfulMsg).getText();
		String subtxt=txt.substring(0, txt.indexOf('.'));
		return subtxt;
	}

	public String checkTheLogoutButton(String usn,String pass) {
		baseLogin.clickOnSignIn();
		doLogin(usn,pass);
		BaseLoginPage baseLogin1=	home.goBack();
		String txt=baseLogin1.getSignInText();
		return txt;
	}
	public String loginUsingEnterButton(String usn,String pass) {
		baseLogin.clickOnSignIn();
		driver.findElement(email).sendKeys(usn);
		driver.findElement(password).sendKeys(pass,Keys.ENTER);
		String actual=home.getHomepageTitle();  
		home.goBack();
		return actual;
	}

	public String loginWithEmptyRequiredFields() {
		baseLogin.clickOnSignIn();
		driver.findElement(login).click();
		String txt=driver.findElement(popup).getText();
		return txt;
	}
	public String loginWithValidCredentialsInDifferentBrowser(String usn,String pass) {
		doLogin(usn,pass);	 
		String actual=home.getHomepageTitle();	  
		return actual;
	}

}
