package com.example.lineartest.testCases;

import com.example.lineartest.base.BaseTest;
import com.example.lineartest.pages.FriendPage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import javax.xml.ws.WebEndpoint;

import static org.testng.Assert.assertEquals;

public class testFriend extends BaseTest {

    @Test
    public void testFriend(){
        FriendPage friendPage = new FriendPage(getDriver());
        assertEquals(friendPage.chat("123456"),true) ;
    }
}
