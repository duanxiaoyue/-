package com.example.lineartest.pages;

import com.example.lineartest.utils.Actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class MinePage {

    @FindBy(id = "me.tictok.linear:id/settings")
    private WebElement set;

    @FindBy(id = "me.tictok.linear:id/logout")
    private WebElement exit;

    @FindBy(id = "android:id/button1")
    private WebElement btn_ok;

    AndroidDriver driver;
    Actions actions;
    public MinePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    //退出登录
    public void exit(){
        List<WebElement> texts = driver.findElementsByClassName("android.widget.TextView");
        for(int i=0;i<texts.size();i++){
            if(texts.get(i).getText().equals("我的")){
                texts.get(i).click();
                break;
            }
        }
        actions.click(set);
        actions.click(exit);
        actions.click(btn_ok);
    }
}
