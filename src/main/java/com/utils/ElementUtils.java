package com.utils;

import com.driver.DriverManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class ElementUtils {

    public static WebElement findByXpath(String xpath) {
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }

    public static List<WebElement> findElementsByXpath(String xpath) {
        return DriverManager.getDriver().findElements(By.xpath(xpath));
    }

    public static WebElement findByAccessibilityId(String accessibilityId) {
        return DriverManager.getDriver().findElement(MobileBy.AccessibilityId(accessibilityId));
    }


    public static WebElement waitForElementTobeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30L);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement findElementByText(String text) {
        return ((AndroidDriver<?>) DriverManager.getDriver()).findElementByAndroidUIAutomator("new UiSelector().text(\"" + text + "\")");
    }

    public static WebElement findElementByTextContains(String partialText) {
        return ((AndroidDriver<?>) DriverManager.getDriver()).findElementByAndroidUIAutomator("new UiSelector().textContains(\"" + partialText + "\")");
    }

    public static WebElement scrollAndFindElementByText(String text) {
        return ((AndroidDriver<?>) DriverManager.getDriver()).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
    }

    public static void tapOnElement(WebElement element) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).tap(tapOptions().withElement(element(element))).perform();
    }

    public static void longPressOnElement(WebElement peopleNamesMenu, long duration) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(longPressOptions().withElement(element(peopleNamesMenu)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                .perform();
    }

    public static void moveElementFromSourceToTarget(WebElement source, WebElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(target))
                .release();
    }
}
