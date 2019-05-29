package com.example.solartest.testCases;

import com.example.solartest.base.BaseTest;
import com.example.solartest.pages.LoginPage;
import com.example.solartest.pages.MainPage;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class testMain extends BaseTest {


    @BeforeMethod
    public void init(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("wangwu","101978");
    }
    @Test
    public void testClock(){
        System.out.print("testMain");
        MainPage mp = new MainPage(getDriver());
        mp.alarmClock(5);
        //断言:one元素可见
        if(getDriver().findElement(By.id("com.example.lx.solarfragment:id/bt1")).isDisplayed()) {
            assert (true);
            System.out.println("testClock成功");
        }
        else{
            assert(false);
            System.out.println("testClock失败");
        }
    }

}
