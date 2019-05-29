package com.example.lineartest.testCases;

import com.example.lineartest.base.BaseTest;
import com.example.lineartest.pages.FindPage;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testFind extends BaseTest {

    @Test
    public void testSlip(){
        FindPage findPage = new FindPage(getDriver());
        findPage.slip();
        assertEquals(getDriver().currentActivity(),".explore.FindContentDetailsActivity");
    }
}
