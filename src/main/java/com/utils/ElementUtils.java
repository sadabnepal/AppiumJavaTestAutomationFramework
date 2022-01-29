package com.utils;

import com.constants.AppPackages;
import com.driver.DriverFactory;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtils {

    public static void openAppUsingPackage(String packageName) {
        DriverFactory.driver.startActivity(new Activity(AppPackages.APP_PACKAGE, packageName));
    }

    public static WebElement waitForElementTobeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 30L);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement findElementByText(String text) {
        return DriverFactory.driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + text + "\")");
    }

    public static WebElement findElementByTextContains(String partialText) {
        return DriverFactory.driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + partialText + "\")");
    }

    public static WebElement scrollAndFindElementByText(String text) {
        return DriverFactory.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
    }
}
