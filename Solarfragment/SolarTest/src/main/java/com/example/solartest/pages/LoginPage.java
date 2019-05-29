package com.example.solartest.pages;

import com.example.solartest.utils.Actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

    @FindBy(id = "com.example.lx.solarfragment:id/login_name")
    private WebElement username;

    @FindBy(id = "com.example.lx.solarfragment:id/password")
    private WebElement password;

    @FindBy(id = "com.example.lx.solarfragment:id/login")
    private WebElement login;



    AndroidDriver driver;
    Actions actions;
    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }
    public void login(String name,String pwd){
        actions.click(username);
        actions.type(username,name);
        actions.click(password);
        actions.type(password,pwd);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.click(login);
    }

}
