package com.example.solartest.pages;

import com.example.solartest.utils.Actions;

import org.checkerframework.checker.fenum.qual.Fenum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;

public class TaskPage {

    @FindBy(id = "com.example.lx.solarfragment:id/image2")
    private WebElement task;

    @FindBy(id = "android:id/button3")
    private WebElement start;

    @FindBy(id = "android:id/button2")
    private WebElement btn_edit;

    @FindBy(id = "com.example.lx.solarfragment:id/taskname")
    private WebElement Edit_Name;

    @FindBy(id = "com.example.lx.solarfragment:id/tasktime")
    private WebElement Edit_Time;

    @FindBy(id = "com.example.lx.solarfragment:id/finish")
    private WebElement btn_finish ;

    @FindBy(id = "android:id/button1")
    private WebElement btn_del;

    @FindBy(id = "android:id/button1")
    private WebElement btn_del_ok;


    AndroidDriver driver;
    Actions actions;
    public TaskPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    public void chooseTask(String task_name){
        //点击“任务”
        actions.click(task);
        //选择任务
        List<WebElement> tasks_opt = driver.findElementsByClassName("android.widget.TextView");
        for(int i=0;i<tasks_opt.size();i++) {
            if (tasks_opt.get(i).getText().equals(task_name)) {
                tasks_opt.get(i).click();
                break;
            }
        }
    }

    public void startTask(String task_name){
       chooseTask(task_name);
        //点击“开始”
        actions.click(start);
    }

    public void editTask(String task_name,String edit_name,String times){
        chooseTask(task_name);
        //点击“编辑”
        actions.click(btn_edit);
        //修改任务名称和时间
        actions.type(Edit_Name,edit_name);
        actions.type(Edit_Time,times);
        //确认修改
        actions.click(btn_finish);
    }

    public void deleteTask(String task_name){
        chooseTask(task_name);
        //点击“删除”
        actions.click(btn_del);
        //点击“确定”
        actions.click(btn_del_ok);
    }
}
