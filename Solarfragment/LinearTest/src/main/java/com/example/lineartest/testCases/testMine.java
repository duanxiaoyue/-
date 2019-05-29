package com.example.lineartest.testCases;

import com.example.lineartest.base.BaseTest;
import com.example.lineartest.pages.MinePage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testMine extends BaseTest {

    @Test
    public void testExit(){
        MinePage minePage = new MinePage(getDriver());
        minePage.exit();
        //断言
        assertEquals(getDriver().currentActivity(),".NexusLauncherActivity");
    }


}
