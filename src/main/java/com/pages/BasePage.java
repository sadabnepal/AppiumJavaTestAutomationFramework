package com.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.driver.DriverManager.*;
import static com.reports.ExtentLogger.*;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    protected void clickElement(MobileElement element, String elementName) {
        waitForElementVisibility(element);
        element.click();
        info(elementName + " is clicked successfully!!");
    }

    protected void enterData(MobileElement element, String value, String elementName) {
        waitForElementVisibility(element);
        element.setValue(value);
        info(value + " is entered successfully in " + elementName);
    }

    protected WebElement scrollAndFindAndroidElementByText(String text, String elementName) {
        info("Performing scroll and to find " + elementName + " by text");
        return ((AndroidDriver<?>) getDriver())
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))");
    }

    protected void tapAndroidElement(MobileElement element, String elementName) {
        new AndroidTouchAction((PerformsTouchActions) getDriver())
                .tap(tapOptions().withElement(element(element))).perform();
        info("Tapped successfully on " + elementName);
    }

    protected void longPressAndroidElement(MobileElement peopleNamesMenu, long duration, String elementName) {
        new AndroidTouchAction((PerformsTouchActions) getDriver())
                .longPress(longPressOptions().withElement(element(peopleNamesMenu)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                .perform();
        info("Long pressed successfully on element " + elementName);
    }

    protected void moveAndroidElement(MobileElement source, WebElement target) {
        new AndroidTouchAction((PerformsTouchActions) getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(ElementOption.element(target))
                .release();
        info("Moved from element: " + source + " to element: " + target);
    }

    protected boolean isElementDisplayed(MobileElement element) {
        waitForElementVisibility(element);
        boolean state = element.isDisplayed();
        info("Element " + element + " is displayed: " + state);
        return state;
    }

    protected void waitForElementVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
