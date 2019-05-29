package com.example.lineartest.pages;

import com.example.lineartest.utils.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class FriendPage {

    @FindBy(id = "me.tictok.linear:id/imageSport")
    private WebElement friend;

    @FindBy(id = "me.tictok.linear:id/friendContent")
    private WebElement friend1;

    @FindBy(id = "me.tictok.linear:id/input_text")
    private WebElement chat;

    @FindBy(id = "me.tictok.linear:id/send")
    private WebElement send;

    AndroidDriver driver;
    Actions actions;
    public FriendPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    //好友聊天
    public boolean chat(String content){
        List<WebElement> texts = driver.findElementsByClassName("android.widget.TextView");
        for(int i=0;i<texts.size();i++){
            if(texts.get(i).getText().equals("好友")){
                texts.get(i).click();
                break;
            }
        }
        actions.click(friend1);
        List<WebElement> text1 = driver.findElementsByClassName("android.widget.TextView");
        int old = text1.size();
        actions.type(chat,content);
        actions.click(send);
        List<WebElement> text2 = driver.findElementsByClassName("android.widget.TextView");
        int n = text2.size();
        if(old == (n-1)){
            return true;
        }
        else
            return  false;
    }

}
