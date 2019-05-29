package com.example.solartest.testCases;

import com.example.solartest.base.BaseTest;
import com.example.solartest.pages.LoginPage;
import com.example.solartest.pages.PersonalPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class testPersonal extends BaseTest {

    @BeforeClass
    public void init(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("wangwu","101978");
    }

    //查看积分
    @Test(priority = 1)
    public void testGrade() {
        PersonalPage personalPage = new PersonalPage(getDriver());
        personalPage.score();
        //断言
        if (getDriver().findElement(By.id("com.example.lx.solarfragment:id/tv_score")).isDisplayed()) {
            assert (true);
            System.out.println("testGrade成功");
        } else {
            assert (false);
            System.out.println("testGrade失败");
        }

    }

    //切换账号
    @Test(priority = 2)
    public void testTranslate(){
        getDriver().navigate().back();
        getDriver().navigate().back();
        PersonalPage personalPage = new PersonalPage(getDriver());
        personalPage.translate("shazhaoyang","123123");
        //断言
        if (getDriver().findElement(By.id("com.example.lx.solarfragment:id/bt1")).isDisplayed()) {
            assert (true);
            System.out.println("testTranslate成功");
        } else {
            assert (false);
            System.out.println("testTranslate失败");
        }
    }

    //注册登录
    @Test(priority = 3)
    public void testRegLogin(){
        PersonalPage personalPage = new PersonalPage(getDriver());
        personalPage.Register("lisi","15222226532","456@456.com","123456","123456");
        //断言
        if (getDriver().findElement(By.id("com.example.lx.solarfragment:id/image1")).isDisplayed()) {
            assert (true);
            System.out.println("testRegLogin成功");
        } else {
            assert (false);
            System.out.println("testRegLogin失败");
        }
    }

    //提醒设置
    @Test(priority = 4)
    public void testRemind(){
        PersonalPage personalPage = new PersonalPage(getDriver());
        personalPage.remind("shock");
        //断言
        List<WebElement> texts = getDriver().findElementsByClassName("android.widget.TextView");
        assertEquals(texts.get(3).getText(),"震动提醒");
    }

    //铃声类型
    @Test(priority = 5)
    public void testSingType(){
        getDriver().navigate().back();
        getDriver().navigate().back();
        PersonalPage personalPage = new PersonalPage(getDriver());
        personalPage.singType(3);
        //断言
        List<WebElement> texts = getDriver().findElementsByClassName("android.widget.TextView");
        assertEquals(texts.get(7).getText(),"我们不一样");
    }

    //退出
    @Test(priority = 6)
    public void testExit(){
        getDriver().navigate().back();
        getDriver().navigate().back();
        getDriver().navigate().back();
        getDriver().navigate().back();
        PersonalPage personalPage = new PersonalPage(getDriver());
        personalPage.exit();
        //断言
        if (getDriver().findElement(By.id("com.example.lx.solarfragment:id/login")).isDisplayed()) {
            assert (true);
            System.out.println("testExit成功");
        } else {
            assert (false);
            System.out.println("testExit失败");
        }
    }

}
