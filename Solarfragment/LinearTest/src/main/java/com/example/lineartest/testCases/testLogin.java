package com.example.lineartest.testCases;



import com.example.lineartest.base.BaseTest;
import com.example.lineartest.pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testLogin extends BaseTest {

    @Test(priority = 2)
    public void testLoginSuccess() throws InterruptedException {
        Thread.sleep(Long.parseLong("5000"));
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("sienna","123456");
        if(getDriver().findElement(By.id("me.tictok.linear:id/add")).isDisplayed()) {
            assert (true);
            System.out.println("Linear:testLoginSuccess成功");
        }
        else{
            assert(false);
            System.out.println("Linear:testLoginSuccess失败");
        }
    }

    @Test(priority = 1)
    public void testLoginFailed(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginInit("zhaosi","123456");
        //断言
        if(getDriver().findElement(By.id("me.tictok.linear:id/btnLogin")).isDisplayed()) {
            assert (true);
            System.out.println("Linear:testLoginFailed成功");
        }
        else{
            assert(false);
            System.out.println("Linear:testLoginFailed失败");
        }
    }
}
