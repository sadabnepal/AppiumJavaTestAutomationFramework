package com.pages;


import com.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class BasePage {

    protected void clickElement(MobileElement element, String elementName) {
        element.click();
        System.out.println(elementName + " is clicked successfully!!");
    }

    protected void enterData(MobileElement element, String value, String elementName) {
        element.setValue(value);
        System.out.println(value + " is entered successfully in " + elementName);
    }

    protected WebElement scrollAndFindElementByText(String text, String elementName) {
        System.out.println("Performing scroll and to find " + elementName + " by text");
        return ((AndroidDriver<?>) DriverManager.getDriver())
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
    }

    protected void tapElement(WebElement element, String elementName) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(tapOptions().withElement(element(element))).perform();
        System.out.println("Tapped successfully on " + elementName);
    }

    protected void longPress(WebElement peopleNamesMenu, long duration, String elementName) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(longPressOptions().withElement(element(peopleNamesMenu)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                .perform();
        System.out.println("Long pressed successfully on element " + elementName);
    }

    protected void moveElement(WebElement source, WebElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(target))
                .release();
        System.out.println("Moved from element: " + source + " to element: " + target);
    }

}
