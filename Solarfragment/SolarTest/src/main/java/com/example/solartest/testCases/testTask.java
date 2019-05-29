package com.example.solartest.testCases;

import com.example.solartest.base.BaseTest;
import com.example.solartest.pages.LoginPage;
import com.example.solartest.pages.TaskPage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testTask extends BaseTest {

    @BeforeClass
    public void init(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("wangwu","101978");
    }

    //开始任务
    @Test(priority = 1)
    public void testStartTask(){
        TaskPage taskPage = new TaskPage(getDriver());
        taskPage.startTask("123");
        //断言
        if(getDriver().findElement(By.id("com.example.lx.solarfragment:id/btn_begin")).isDisplayed()){
            assert(true);
            System.out.println("testStartTask成功");
        }
        else {
            assert(false);
            System.out.println("testStartTask失败");
        }
    }

    //编辑任务
    @Test (priority = 2)
    public void testEditTask(){
        getDriver().navigate().back();
        TaskPage taskPage = new TaskPage(getDriver());
        taskPage.editTask("123","abc","23");
        //断言
        if(getDriver().findElement(By.id("com.example.lx.solarfragment:id/image2")).isDisplayed()){
            assert(true);
            System.out.println("testEditTask成功");
        }
        else {
            assert(false);
            System.out.println("testEditTask失败");
        }
    }

    //删除任务
    @Test (priority = 3)
    public void testDeleteTask(){
        TaskPage taskPage = new TaskPage(getDriver());
        taskPage.deleteTask("abc");
        if(getDriver().findElement(By.id("com.example.lx.solarfragment:id/image2")).isDisplayed()){
            assert(true);
            System.out.println("testDeleteTask成功");
        }
        else {
            assert(false);
            System.out.println("testDeleteTask失败");
        }
    }

}
