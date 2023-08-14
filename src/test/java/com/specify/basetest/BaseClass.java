package com.specify.basetest;

import java.io.IOException
;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.specify.driverfactory.DriverFactory;
import com.specify.page.Loginpage;
import com.specify.utility.ConfigProperties;


public class BaseClass {
protected WebDriver driver;
DriverFactory df;
Properties prop;
protected Loginpage login;
@BeforeTest
public void beforetest() throws IOException {
	df=new DriverFactory();
	driver=df.int_driver();
	prop=ConfigProperties.loadProperties();
	driver.get(prop.getProperty("baseUrl"));
	login=new Loginpage(driver);

}
@AfterTest
public void after() {
	driver.quit();
}

}
