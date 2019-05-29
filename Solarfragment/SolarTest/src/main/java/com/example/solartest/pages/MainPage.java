package com.example.solartest.pages;

import com.example.solartest.base.BaseTest;
import com.example.solartest.utils.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class MainPage {

    @FindBy(id = "com.example.lx.solarfragment:id/bt1")
    private WebElement one;

    @FindBy(id = "com.example.lx.solarfragment:id/bt2")
    private WebElement two;

    @FindBy(id = "com.example.lx.solarfragment:id/bt3")
    private WebElement three;

    @FindBy(id = "com.example.lx.solarfragment:id/bt4")
    private WebElement four;

    @FindBy(id = "com.example.lx.solarfragment:id/bt5")
    private  WebElement five;

    @FindBy(id = "com.example.lx.solarfragment:id/bt6")
    private WebElement six;

    @FindBy(className = "android.widget.LinearLayout")
    private List<WebElement> clock;

    @FindBy(id = "com.example.lx.solarfragment:id/btn_give_up")
    private WebElement giveup;



    AndroidDriver driver;
    Actions actions;
    public MainPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);

    }

    public void alarmClock(int number) {
        switch (number){
            case 1:
                actions.click(one);
                break;
            case 2:
                actions.click(two);
                break;
            case 3:
                actions.click(three);
                break;
            case 4:
                actions.click(four);
                break;
            case 5:
                actions.click(five);
                break;
            case 6:
                actions.click(six);
                break;
        }
        actions.click(clock.get(4));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.click(giveup);

    }

}
