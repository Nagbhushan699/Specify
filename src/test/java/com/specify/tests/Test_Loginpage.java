package com.specify.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.specify.utility.ExcelReader;
import com.specify.basetest.BaseClass;
import com.specify.constants.Constants;

public class Test_Loginpage extends BaseClass{
	static Logger log=Logger.getLogger(Test_Loginpage.class);
	@Test(priority=1,dataProvider = "getInvalidCredentials")
	public void verifyLoginWithInValidCredentials(String usn,String pass) {
	String actual=	login.loginWithInValidCredentials(usn,pass);
	log.info(actual);
	String expected=Constants.UNSUCCESSFULOGINMSG;
	log.info(expected);
	Assert.assertEquals(actual,expected);
	}
	
	@DataProvider()
	public Object[][] getInvalidCredentials() throws IOException {
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"src\\main\\resources"+File.separator+"Login Credentials.xlsx";
		String sheetname="Login Credentials";
		ExcelReader excel=new ExcelReader(fullpath,sheetname);
		return excel.getAllData();
	}
	
	@Test(priority = 2,dataProvider = "getValidCredentials")
	public void verifyLoginWithValidCredentials(String usn,String pass) {
	String actual=	login.loginWithValidCredentials(usn, pass);
	log.info(actual);
	String expected=Constants.SUCCESSFULOGINMSG;
	log.info(expected);
	Assert.assertEquals(actual,expected );
	}
	@DataProvider()
	public Object[][] getValidCredentials() {
		Object[][] obj= {{"nagbhushanb06@gmail.com", "Bhushan@123"}};
		return obj;
	}
	@Test(priority = 3,dataProvider = "getValidCredentials")
	public void verifyLogoutButton(String usn,String pass) {
	String actual=	login.checkTheLogoutButton(usn, pass);
	log.info(actual);
	String expected=Constants.SIGNINTEXT;
	log.info(expected);
	Assert.assertEquals(actual, expected );
	}
	@Test(priority=4,dataProvider = "getValidCredentials")
	public void verifyloginUsingEnterButton(String usn,String pass) {
		String actual=	login.loginUsingEnterButton(usn, pass);
		log.info(actual);
		String expected=Constants.SUCCESSFULOGINMSG;
		log.info(expected);
		Assert.assertEquals(actual, expected );
	}
	@Test(priority=5)
	public void verifyLoginWithEmptyRequiredFields() {
		String actual=login.loginWithEmptyRequiredFields();
		log.info(actual);
		String expected=Constants.ERRORMSG;
		log.info(expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 6,dataProvider = "getValidCredentials")
	public void verifyLoginWithValidCredentialsInDifferentBrowser(String usn,String pass) {
	String actual=	login.loginWithValidCredentialsInDifferentBrowser(usn,pass);
	log.info(actual);
	String expected=Constants.SUCCESSFULOGINMSG;
	log.info(expected);
	Assert.assertEquals(actual,expected );
	}
}
