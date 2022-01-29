package com.tests;

import static com.utils.ElementUtils.*;

import com.constants.AppPackages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementStrategyTest extends BaseTest {

    @Test(priority = 0)
    public void appNameHeaderTest() {
        String actualHeader = driver.findElementByXPath("//android.widget.TextView").getText();
        Assert.assertEquals(actualHeader, "API Demos");
    }

    @Test(priority = 1)
    public void allMenuNamesTest() {
        String[] list = {"API Demos", "Accessibility", "Animation", "App", "Content", "Graphics", "Media", "NFC", "OS", "Preference", "Text", "Views"};
        List<String> expectedMenuList = Arrays.asList(list);

        List<String> actualMenuList = new ArrayList<>();
        driver.findElementsByCssSelector(".android.widget.TextView")
                .stream().map(WebElement::getText)
                .forEach(actualMenuList::add);
        Assert.assertEquals(actualMenuList, expectedMenuList);
    }

    @Test(priority = 2)
    public void viewMenuNavigationTest() {
        driver.findElementByAccessibilityId("Views").click();
    }

    @Test(priority = 3)
    public void openMenuUsingAppActivityTest() throws InterruptedException {
        openAppUsingPackage(AppPackages.ALERT_DIALOGUE);
        driver.findElementByXPath("//*[@content-desc='List dialog']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Command two']").click();
        String actualText = driver.findElementByXPath("//*[@resource-id='android:id/message']").getText();
        Assert.assertEquals(actualText, "You selected: 1 , Command two");
    }

    @Test(priority = 4)
    public void findElementByUIAutomatorTest() {
        openAppUsingPackage(AppPackages.LANDING_PAGE);
        waitForElementTobeClickable(findElementByText("App")).click();
        Assert.assertTrue(findElementByText("Action Bar").isDisplayed());
    }

    @Test(priority = 5)
    public void scrollElementTest() {
        openAppUsingPackage(AppPackages.LANDING_PAGE);
        findElementByText("Views").click();
        scrollAndFindElementByText("ScrollBars").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("1. Basic").isDisplayed());
    }

}
