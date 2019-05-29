package com.example.solartest.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
    AndroidDriver<WebElement> driver;
    public AndroidDriver<WebElement> getDriver(){
        return this.driver;
    }
    @BeforeClass
    public void startApp() throws IOException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot+"/apps");
        File app = new File(appDir.getCanonicalPath(), "app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("apps", app.getAbsolutePath());
        capabilities.setCapability("noReset",false);//保留历史数据
        capabilities.setCapability("appPackage", "com.example.lx.solarfragment");
        capabilities.setCapability("appActivity", ".LoginActivity");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
//        driver = new AndroidDriver<WebElement>(new URL("http://12/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
