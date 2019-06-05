package com.example.lx.solarfragment;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;

public class UiautomatorPrictice {

    private UiDevice device ;

    @Test
    public void testSolar(){
    //登录
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        //点击Home键
        device.pressHome();

        //点击SolarApp
        UiObject logo = device.findObject(new UiSelector().text("Solar"));
        try {
            logo.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        //输入用户名密码
        UiObject username = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/login_name"));
        UiObject password = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/password"));
        UiObject login = device.findObject(new UiSelector().text(" 登  录 "));
        try {
            username.setText("wangwu");
            password.setText("101978");
            login.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    //开启番茄闹钟
        //点击ONE
        UiObject one = device.findObject(new UiSelector().text("ONE"));
        try {
            one.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        //开始计时
        UiObject start = device.findObject(new UiSelector().text("25"));
        try {
            start.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        //返回
        device.pressBack();
    //个人中心
        //点击个人中心
        UiObject more = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/btn_more"));
        try {
            more.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    //查看积分
        UiObject score = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/ll_score_details"));
        try {
            score.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        device.pressBack();
    //切换账号
        UiObject change = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/ll_change_user"));
        try {
            change.click();
            username.setText("lisi");
            password.setText("123456");
            login.click();
            more.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    //注册新用户
        UiObject register = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/ll_zhu_ce"));
        try {
            register.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        UiObject name = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/username"));
        UiObject phone = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/phone"));
        UiObject email = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/email"));
        UiObject pwd = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/password"));
        UiObject pwd2 = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/qpassword"));

        try {
            name.setText("zhaosi");
            phone.setText("15222222223");
            email.setText("123@456.com");
            pwd.setText("123456");
            pwd2.setText("123456");
            device.findObject(new UiSelector().text("注册")).click();
            username.setText("zhaosi");
            password.setText("123456");
            login.click();
            more.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    //设置
        UiObject set = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/ll_set_up"));
        try {
            set.click();
            device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/switch1"));
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        device.pressBack();
    //退出
        UiObject logout = device.findObject(new UiSelector().resourceId("com.example.lx.solarfragment:id/ll_check_out"));
        try {
            logout.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testLinear(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
        try {
            device.findObject(new UiSelector().text("Linear")).click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        //登录
        UiObject login1 = device.findObject(new UiSelector().text("登录"));
        UiObject username = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/etUser"));
        UiObject password = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/etPassword"));
        UiObject login2 = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/btnLogin"));
        try {
            login1.click();
            username.setText("sienna");
            password.setText("123456");
            login2.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    //添加运动计划
        UiObject add = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/add"));
        UiObject run = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/plan_image1"));
        UiObject ok = device.findObject(new UiSelector().resourceId("android:id/button1"));
        try {
            add.click();
            run.click();
            ok.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    //管理运动记录
        UiObject manage = device.findObject(new UiSelector().text("管理我的运动记录"));
        try {
            manage.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        device.pressBack();
    //查看动态
        UiObject find = device.findObject(new UiSelector().text("发现"));
        UiObject youga = device.findObject(new UiSelector().text("瑜伽"));
        UiObject article = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/tv_article"));
        try {
            find.click();
            youga.click();
            article.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        device.pressBack();
        device.pressBack();
    //好友聊天
        UiObject friend = device.findObject(new UiSelector().text("好友"));
        UiObject Friend1 = device.findObject(new UiSelector().text("Friend1"));
        UiObject chat = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/input_text"));
        UiObject send = device.findObject(new UiSelector().resourceId("me.tictok.linear:id/send"));
        try {
            friend.click();
            Friend1.click();
            chat.setText("hello");
            send.click();
            device.pressBack();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    //退出登录
        UiObject mine = device.findObject(new UiSelector().text("我的"));
        UiObject set = device.findObject(new UiSelector().text("设置"));
        UiObject exit = device.findObject(new UiSelector().text("退出登录"));
        try {
            mine.click();
            set.click();
            exit.click();
            ok.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }


    }

}
