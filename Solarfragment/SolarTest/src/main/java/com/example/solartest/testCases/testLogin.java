package com.example.solartest.testCases;

import com.example.solartest.base.BaseTest;
import com.example.solartest.dataProvider.NSDataProvider;
import com.example.solartest.pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sun.rmi.runtime.Log;

public class testLogin extends BaseTest {

    @Test
    public void testLoginSuccess() throws InterruptedException {
        System.out.println("testLogin");
        Thread.sleep(Long.parseLong("5000"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("wangwu","101978");
        //断言：登录成功
        if(getDriver().findElement(By.id("com.example.lx.solarfragment:id/bt1")).isDisplayed()) {
            assert (true);
            System.out.println("testLoginSuccess成功");
        }
        else{
            assert(false);
            System.out.println("testLoginSuccess失败");
        }
    }

    @Test
    public void testLoginFailed(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("zhaosi","123456");
        //断言：密码或用户名输入错误
        if(getDriver().findElement(By.id("com.example.lx.solarfragment:id/login")).isDisplayed()){
            assert(true);
            System.out.println("testLoginFailed成功");
        }
        else{
            assert(false);
            System.out.println("testLoginFailed失败");
        }
    }
}
