package com.example.solartest.pages;

import com.example.solartest.utils.Actions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class PersonalPage {

    @FindBy(id = "com.example.lx.solarfragment:id/btn_more")
    private WebElement btn_more;

    @FindBy(id = "com.example.lx.solarfragment:id/ll_score_details")
    private WebElement score_details;

    @FindBy(id = "com.example.lx.solarfragment:id/ll_change_user")
    private WebElement changeUser;

    @FindBy(id = "com.example.lx.solarfragment:id/login_name")
    private WebElement username;

    @FindBy(id = "com.example.lx.solarfragment:id/password")
    private WebElement password;

    @FindBy(id = "com.example.lx.solarfragment:id/login")
    private WebElement btn_login;

    @FindBy(id = "com.example.lx.solarfragment:id/ll_zhu_ce")
    private WebElement btn_regist;

    @FindBy(id = "com.example.lx.solarfragment:id/username")
    private WebElement reg_username;

    @FindBy(id = "com.example.lx.solarfragment:id/phone")
    private WebElement reg_phone;

    @FindBy(id = "com.example.lx.solarfragment:id/email")
    private WebElement reg_mail;

    @FindBy(id = "com.example.lx.solarfragment:id/password")
    private WebElement reg_pwd;

    @FindBy(id = "com.example.lx.solarfragment:id/qpassword")
    private WebElement reg_qpwd;

    @FindBy(id = "com.example.lx.solarfragment:id/register")
    private WebElement reg_btn;

    @FindBy(id = "com.example.lx.solarfragment:id/ll_set_up")
    private WebElement btn_set;

    @FindBy(id = "com.example.lx.solarfragment:id/tv_sing1")
    private WebElement btn_chice;

    @FindBy(id = "android:id/button3")
    private WebElement btn_shock;

    @FindBy(id = "android:id/button2")
    private WebElement btn_sing;

    @FindBy(id = "android:id/button1")
    private WebElement btn_noSing;

    @FindBy(className = "android.widget.TextView")
    private List<WebElement> btn_Type;

    @FindBy(id = "com.example.lx.solarfragment:id/ll_check_out")
    private WebElement btn_checkout;

    AndroidDriver driver;
    Actions actions;
    public PersonalPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);

    }

    //查看积分
    public void score(){
        //点击更多
        actions.click(btn_more);
        //点击积分详情
        actions.click(score_details);
    }

    //切换账号
    public void translate(String name,String pwd){
        //点击更多
        actions.click(btn_more);
        //点击切换账号
        actions.click(changeUser);
        //输入用户名
        actions.type(username,name);
        //输入密码
        actions.type(password,pwd);
        //点击登录
        actions.click(btn_login);
    }
    //注册新用户
    public void Register(String uname,String phone,String mail,String pwd,String qpwd){
        //点击更多
        actions.click(btn_more);
        //点击注册新用户
        actions.click(btn_regist);
        //输入用户名
        actions.type(reg_username,uname);
        //输入手机号
        actions.type(reg_phone,phone);
        //输入邮箱
        actions.type(reg_mail,mail);
        //输入密码
        actions.type(reg_pwd,pwd);
        //确认密码
        actions.type(reg_qpwd,qpwd);
        //点击注册
        actions.click(reg_btn);
        //新用户登录
        actions.type(username,uname);
        actions.type(password,pwd);
        actions.click(btn_login);
    }

    //设置
    public void setClick(){
        //点击更多
        actions.click(btn_more);
        //点击设置
        actions.click(btn_set);
    }
      //提醒设置
    public void remind(String type){
        setClick();
        actions.click(btn_Type.get(2));
        switch (type){
            case "shock":
                actions.click(btn_shock);
                break;
            case "sing":
                actions.click(btn_sing);
                break;
            case "no":
                actions.click(btn_noSing);
                break;
        }
    }

      //铃声类型
    public void singType(int order){
        setClick();
        int i = order;
        List<WebElement> types = driver.findElementsByClassName("android.widget.TextView");
        actions.click(types.get(6));
        actions.click(btn_Type.get(i));
    }

    //退出
    public void exit(){
        actions.click(btn_more);
        actions.click(btn_checkout);
    }
}
