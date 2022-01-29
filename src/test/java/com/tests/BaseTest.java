package com.tests;

import com.constants.AppPackages;
import com.driver.DriverFactory;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {

    protected static AndroidDriver<WebElement> driver;


    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver();
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
