package com.actitie.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username")
	private WebElement untbx;  // declaration
	@FindBy(name ="pwd")
	private WebElement pwtbx;
	@FindBy(xpath="//div[.='Login']")
	private WebElement lgbtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);  //initialisation

		//Bussiness logic methods

	}
	public void setLogin(String un,String pw) {
		untbx.sendKeys(un);          // Utilization
		pwtbx.sendKeys(pw);
		lgbtn.click();
	}

}
