package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLIB {
	public void waitforElementLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
     
	}
	public void waitforElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void customWait(WebElement element) {
		int i = 0;
		while(i<=1000) {
			try {
				element.isDisplayed();
				break;
			}
			catch(Exception e) {
				i++;
			}
		}
			
	}
	public void selectOption(WebElement element,int i) {
		Select s = new Select(element);
		s.selectByIndex(i);
	}
	public void selectOption(WebElement element,String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);

   }
}



