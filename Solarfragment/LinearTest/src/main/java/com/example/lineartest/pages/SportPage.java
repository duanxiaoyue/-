package com.example.lineartest.pages;

import com.example.lineartest.utils.Actions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;


public class SportPage {

    @FindBy(id = "me.tictok.linear:id/add")
    private WebElement add;

    @FindBy(id = "me.tictok.linear:id/plan_image2")
    private WebElement plan;

    @FindBy(id = "android:id/button1")
    private WebElement btn_ok;

    @FindBy(className = "android.widget.TextView")
    private List<WebElement> classes;

    @FindBy(id = "me.tictok.linear:id/begin_course")
    private WebElement start;

    @FindBy(id = "me.tictok.linear:id/manage_record")
    private WebElement manage;

    @FindBy(id = "me.tictok.linear:id/imgdelete")
    private WebElement delete;

    AndroidDriver driver;
    Actions actions;
    public SportPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    //添加运动计划  自行选择计划
    public void addSport(){
        actions.click(add);
        actions.click(plan);
        actions.click(btn_ok);
    }

    //开始课程  自行选择课程
    public void startClass(){
        actions.click(classes.get(12));
        actions.click(start);
    }

    //删除运动计划
    public boolean deleteSport(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.click(manage);
        List<WebElement> groups_pre = driver.findElementsByClassName("android.view.ViewGroup");
        int i = groups_pre.size();
        //拖拽
        Point point_right = new Point(1000,400);
        Point point_left = new Point(600,400);
        actions.drop(point_right,point_left);
        //删除
        actions.click(delete);
        List<WebElement> groups_later = driver.findElementsByClassName("android.view.ViewGroup");
        int j = groups_later.size();
        if(i==(j+2))
            return true;
        else
            return false;
    }

}
