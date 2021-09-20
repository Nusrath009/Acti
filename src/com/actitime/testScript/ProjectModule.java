package com.actitime.testScript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ProjectModule {
	@Test(priority=1,invocationCount =3)
    public void createProject() {
    	Reporter.log("createProject",true);
    }
    	@Test(priority=2,dependsOnMethods="createCustomer")
    	public void modifyProject() {
    		Reporter.log("modifyProject",true);
    		
    		
    	}
    	@Test(priority=3, enabled =false)
    	public void deleteProject() {
    		Reporter.log("deleteProject",true);
	}

}
