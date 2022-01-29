package com.utils;

import com.constants.AppPackages;
import com.driver.DriverFactory;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class ElementUtils {

    public static AndroidElement findByXpath(String xpath) {
        return DriverFactory.driver.findElementByXPath(xpath);
    }

    public static List<AndroidElement> findElementsByXpath(String xpath) {
        return DriverFactory.driver.findElementsByXPath(xpath);
    }

    public static AndroidElement findByAccessibilityId(String accessibilityId) {
        return DriverFactory.driver.findElementByAccessibilityId(accessibilityId);
    }

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

    public static void tapOnElement(AndroidElement element) {
        new AndroidTouchAction(DriverFactory.driver).tap(tapOptions().withElement(element(element))).perform();
    }

    public static void longPressOnElement(AndroidElement peopleNamesMenu, long duration) {
        new AndroidTouchAction(DriverFactory.driver)
                .longPress(longPressOptions().withElement(element(peopleNamesMenu)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                .perform();
    }

    public static void moveElementFromSourceToTarget(AndroidElement source, AndroidElement target) {
        new AndroidTouchAction(DriverFactory.driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(target))
                .release();
    }
}
