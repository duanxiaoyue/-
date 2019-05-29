package com.example.lineartest.pages;

import com.example.lineartest.utils.Actions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class FindPage {

    @FindBy(id = "me.tictok.linear:id/imageSport")
    private WebElement find;

    @FindBy(id = "me.tictok.linear:id/title")
    private WebElement title;

    @FindBy(id = "me.tictok.linear:id/tv_article")
    private WebElement article;
    AndroidDriver driver;
    Actions actions;
    public FindPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    //选择文章下滑到底部
    public void slip(){
        List<WebElement> texts = driver.findElementsByClassName("android.widget.TextView");
        for(int i=0;i<texts.size();i++){
            if(texts.get(i).getText().equals("发现")){
                texts.get(i).click();
                break;
            }
        }
        actions.click(title);
        //下滑
        Point pointD = new Point(615,2144);
        Point pointU = new Point(670,315);
        PointOption point_down = new PointOption().withCoordinates(pointD);
        PointOption point_up = new PointOption().withCoordinates(pointU);
        for(int i =0;i<5;i++){
            actions.swip(point_down,point_up,5);
        }
    }
}
