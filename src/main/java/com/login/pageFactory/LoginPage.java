package com.login.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	WebDriver driver;

	public static By userName = By.xpath("//input[@name='email']");
		 	
	public static By password = By.xpath("//input[@name='password']");

	public static By loginbtn = By.xpath("//div[contains(text(),'Login')]");

	
}
