package com.login.packages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.login.pageFactory.LoginPage;

public class LoginpageObjects {


	//Set user name in textbox
	public static void setUserName(String strUserName,WebDriver driver) {

		driver.findElement(LoginPage.userName).sendKeys(strUserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
	}

	//Set password in password textbox
	public static void setPassword(String strPassword,WebDriver driver) {

		driver.findElement(LoginPage.password).sendKeys(strPassword);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static String defaultUserName(WebDriver driver) {

		String defaultName=driver.findElement(LoginPage.userName).getAttribute("placeholder").toString();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return defaultName;    
	}

	public static String defaultPassword(WebDriver driver) {

		String defaultPassword=driver.findElement(LoginPage.password).getAttribute("placeholder").toString();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return defaultPassword;    
	}
	//Click on Login button
	public static void clickLogin(WebDriver driver){

		driver.findElement(LoginPage.loginbtn).click();

	}  

	//Get the title of Login button
	public static String getLoginTitle(WebDriver driver){

		return driver.findElement(LoginPage.loginbtn).getText();

	}

	public static Boolean verifyLoginbtnEnabled(WebDriver driver){

		return driver.findElement(LoginPage.loginbtn).isEnabled();

	}


	public static String logintoDashboard(String strUserName,String strPasword,WebDriver driver) {

		//Fill user name
		setUserName(strUserName,driver);

		//Fill password
		setPassword(strPasword,driver);

		//Getting the text for login for validation
		String logintext=getLoginTitle(driver);

		boolean verifyLoginbtn=verifyLoginbtnEnabled(driver);

		if (strUserName.matches(Constantsvalues.UserRegexPattern) && strUserName.matches(Constantsvalues.PassRegexPattern)) {

			if(verifyLoginbtn==true){
				System.out.println("Scenario with Valid Username and Password---> Passed");
				//Click Login button
				clickLogin(driver);
			}
			else{System.out.println("Scenario with Valid Username and Password---> Failed");

			}
		}
		else if(!strUserName.matches(Constantsvalues.UserRegexPattern) || !strUserName.matches(Constantsvalues.PassRegexPattern)){

			if(verifyLoginbtn==false){
				System.out.println("Scenario with Valid Username and Password---> Passed");

			}
			else{System.out.println("Scenario with Valid Username and Password---> Failed");

			}
		}
		else{
			if(verifyLoginbtn==false){
				System.out.println("Scenario with Valid Username and Password---> Passed");

			}
			else{System.out.println("Scenario with Valid Username and Password---> Failed");

			}
		}

		return logintext;  


	}


}
