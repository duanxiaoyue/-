package com.example.lineartest.utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class Actions {
    AndroidDriver driver;
    AndroidTouchAction aca;
    TouchAction dragDrop;
    public Actions(AndroidDriver driver){
        this.driver = driver;
        aca = new AndroidTouchAction(driver);
        dragDrop = new TouchAction(driver);
    }

    //单个元素的输入
    public void type(WebElement element,String Context){
        element.sendKeys(Context);
    }

    //点击
    public void click(WebElement element){
        element.click();
    }

    //长按
    public void longPress(WebElement ele){
//        this.dragDrop.longPress(element(ele)).perform();
        WebElement node = driver.findElementById("com.example.todolist:id/toDoItemDetailTv");
            TouchAction LongPress = new TouchAction(driver);
            LongPress.longPress(element(node)).perform();
    }

    //坐标点间的滑动
    public void swip(PointOption fromOption, PointOption toOption, int time){
        aca.press(fromOption).waitAction(waitOptions(ofSeconds(time))).moveTo(toOption).perform();

    }

    //元素间的滑动
    public void swip(WebElement formEle,WebElement toEle,long time){
        aca.press(element(formEle)).waitAction(waitOptions(ofSeconds(time))).
                moveTo(element(toEle)).perform();
    }


    //元素间拖动
    public void drop(WebElement fromele,WebElement toele){
        aca.longPress(longPressOptions()
                .withElement(element(fromele))
                .withDuration(ofSeconds(2)))
                .moveTo(element(toele))
                .release()
                .perform();

    }

    //坐标间拖动
    public void drop(Point center1, Point center2) {
        aca.longPress(longPressOptions()
                .withPosition(point(center1.x, center1.y))
                .withDuration(ofSeconds(2)))
                .moveTo(point(center2.x, center2.y))
                .release()
                .perform();
    }

}
