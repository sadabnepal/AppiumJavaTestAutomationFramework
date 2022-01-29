package com.tests;

import com.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Objects;


public class BaseTest {

    protected static AndroidDriver<WebElement> driver;

    @BeforeTest
    public void setUp() {
        if(Objects.isNull(driver)) {
            driver = DriverFactory.getDriver();
        }
    }

    @AfterTest
    public void tearDown() {
        if(Objects.nonNull(driver)) {
            driver.quit();
        }
    }

}
