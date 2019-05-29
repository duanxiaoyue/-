package com.example.lineartest.testCases;

import com.example.lineartest.base.BaseTest;
import com.example.lineartest.pages.LoginPage;
import com.example.lineartest.pages.SportPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testSport extends BaseTest {

//    @BeforeTest
//    public void login(){
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.loginInit("sienna","123456");
//    }
    //添加运动计划
    @Test(priority = 1)
    public void testAdd(){
        SportPage sportPage = new SportPage(getDriver());
        sportPage.addSport();
        assertEquals(getDriver().currentActivity(),".MainActivity");
    }

    //开始运动计划
    @Test(priority = 2)
    public void testStartClass(){
        SportPage sportPage = new SportPage(getDriver());
        sportPage.startClass();
        assertEquals(getDriver().currentActivity(),".sport.CourseActivity");
    }

    //删除运动计划
    @Test(priority = 3)
    public void testDeleteSport(){
        getDriver().navigate().back();
        getDriver().navigate().back();
        SportPage sportPage = new SportPage(getDriver());
        assertEquals(sportPage.deleteSport(),true);
    }

}
