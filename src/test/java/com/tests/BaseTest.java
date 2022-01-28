package com.tests;

import com.config.FrameworkConfig;
import com.constants.AppPackages;
import com.constants.PathConstants;
import io.appium.java_client.android.*;
import io.appium.java_client.remote.*;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    static AndroidDriver<AndroidElement> driver;
    FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.APP, PathConstants.APPLICATION_PATH);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        driver = new AndroidDriver<>(new URL( config.baseurl()+":"+config.port()), desiredCapabilities);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    public void openAppUsingPackage(String packageName) {
        driver.startActivity(new Activity(AppPackages.APP_PACKAGE, packageName));
    }

    public static WebElement waitForElementTobeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30L);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement findElementByText(String text) {
        return driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")");
    }

    public static WebElement findElementByTextContains(String partialText) {
        return driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+partialText+"\")");
    }

    public static WebElement scrollAndFindElementByText(String text) {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
    }
}
