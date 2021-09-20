package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitie.POM.HomePage;
import com.actitie.POM.LoginPage;
import com.beust.jcommander.Parameter;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromesriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver.geckodriver.exe");
		
	}
	public WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser(String browser) {
		Reporter.log("openBrowser",true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
     @AfterTest
     public void closeBrowser() {
    	 Reporter.log("closeBrowser",true);
    	 driver.close();
    	 
     }
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		FileLIB f =new FileLIB();
		String url = f.getPropertyData("url");
		String usr = f.getPropertyData("username");
		String pwd = f.getPropertyData("password");
		driver.get(url);
		LoginPage l = new LoginPage(driver);
		l.setLogin(usr, pwd);
		
		/*driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("login")).click();
		(avoided this hardcoding)
		*/
	}
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
		HomePage h = new HomePage(driver);
		h.setLogout();
		
		//driver.findElement(By.id("logoutLink")).clear();
		//Reporter.log("logout",true);	
		//HomePage h=new HomePage(driver);
		//h.setLogout()

}
}
