package com.testcases;

import Pages.LoginPage;
import Utility.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class testRun extends BaseClass {

    @Test
    public void TestRun(){
        //String uName =  UtilityClass.readProps("userName");
        //String pWord =  UtilityClass.readProps("passWord");
        logger = report.createTest("Login Test");
        LoginPage loginPage1 = PageFactory.initElements(driver, LoginPage.class);
        logger.info("==Enter User Name into User Name and Password text box==");
        loginPage1.loginToJ2Page(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
        logger.pass("Login Successful");
    }
}
