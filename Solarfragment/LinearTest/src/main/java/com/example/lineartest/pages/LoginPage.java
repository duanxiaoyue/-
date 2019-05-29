package com.example.lineartest.pages;

import com.example.lineartest.utils.Actions;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

    @FindBy(id = "me.tictok.linear:id/btnLogIn")
    private WebElement login1;

    @FindBy(id = "me.tictok.linear:id/etUser")
    private WebElement username;

    @FindBy(id = "me.tictok.linear:id/etPassword")
    private WebElement password;

    @FindBy(id = "me.tictok.linear:id/btnLogin")
    private WebElement login2;



    AndroidDriver driver;
    Actions actions;
    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }
    public void loginInit(String name,String pwd){
        actions.click(login1);
        actions.type(username,name);
        actions.type(password,pwd);
        actions.click(login2);
    }

    public void login(String name,String pwd){
        actions.type(username,name);
        actions.type(password,pwd);
        actions.click(login2);
    }

}
