package com.actitime.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitie.POM.HomePage;
import com.actitie.POM.TaskListPage;
import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLIB;
@Listeners(com.actitime.generic.ListernerImplementation.class)

public class CustomerModule extends BaseClass {
	
	@Test
	public void createCustomer() throws Exception, IOException {
		FileLIB f = new FileLIB();
		String custName = f.getExcelData("CreateCustomer", 1, 2);
		String custDescription = f.getExcelData("CreateCustomer", 1, 3);
		HomePage h = new HomePage(driver);
		h.settaskTab();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getEnterCustomerNameTbx().sendKeys("Nus001");
		t.getCustDescrpTbx().sendKeys("comop");
		t.getSelectCustomerDD().click();
		t.getOurCompany().click();
		t.getCreateCustBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustCreated(), custName));
		String actualtext = t.getActualCustCreated().getText();
		Assert.assertEquals(actualtext, custName);
		Reporter.log("customer name ie "+custName+"Successfully create",true);	
		
		
	}
}
