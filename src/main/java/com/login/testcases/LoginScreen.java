package com.login.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.login.packages.Constantsvalues;
import com.login.packages.LoginpageObjects;


public class LoginScreen {


		WebDriver driver = null; 
		
	
		@BeforeClass
		public void setupBrowser() { 
			
			System.setProperty(Constantsvalues.chromedriverprop,Constantsvalues.chromedriverpath);
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-extensions");
			option.addArguments("--test-type");
			driver = new ChromeDriver(option);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.navigate().to(Constantsvalues.url); 
			driver.manage().window().maximize();
		}
		
		
		@Test(enabled=true,priority=1)
		public void verifyvalidLogin() { 
						
			SoftAssert s_assert = new SoftAssert();
			String defaultUsername=LoginpageObjects.defaultUserName(driver);
			String defaultPassword=LoginpageObjects.defaultPassword(driver);
			String loginText = LoginpageObjects.logintoDashboard("Alv1ns3t", "Welc0m3@123",driver);
			s_assert.assertEquals("username", defaultUsername,"Default Username text is not equal");
			s_assert.assertEquals("password", defaultPassword,"Default Password text is not equal");
			s_assert.assertEquals("Login", loginText,"Login text is not equal");
			s_assert.assertAll();
		}


		@Test(enabled=true,priority=2)
		public void verifyinvalidUsernameLogin() { 
						
			SoftAssert s_assert = new SoftAssert();
			String defaultUsername=LoginpageObjects.defaultUserName(driver);
			String defaultPassword=LoginpageObjects.defaultPassword(driver);
			String loginText = LoginpageObjects.logintoDashboard("---", "Welc0m3@123",driver);
			s_assert.assertEquals("username", defaultUsername,"Default Username text is not equal");
			s_assert.assertEquals("password", defaultPassword,"Default Password text is not equal");
			s_assert.assertEquals("Login", loginText,"Login text is not equal");
			s_assert.assertAll();
		}

		@Test(enabled=true,priority=2)
		public void verifyinvalidPasswordLogin() { 
						
			SoftAssert s_assert = new SoftAssert();
			String defaultUsername=LoginpageObjects.defaultUserName(driver);
			String defaultPassword=LoginpageObjects.defaultPassword(driver);
			String loginText = LoginpageObjects.logintoDashboard("Alv1ns3t", "W**3",driver);
			s_assert.assertEquals("username", defaultUsername,"Default Username text is not equal");
			s_assert.assertEquals("password", defaultPassword,"Default Password text is not equal");
			s_assert.assertEquals("Login", loginText,"Login text is not equal");
			s_assert.assertAll();
		}

		@AfterClass
		   public void teardown(){
			   if(driver!= null){
				   driver.close(); 
				   driver.quit();
				   
			   }
		   }
		
		
		
	}
