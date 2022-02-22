package com.driver;

import static com.config.ConfigFactory.*;
import com.enums.RunMode;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.driver.DriverManager.*;
import static com.driver.DriverManager.getDriver;

public class Driver {

    private Driver() {}

    public static void initDriver() {
        if (Objects.isNull(getDriver())) {
            RunMode runmode = RunMode.valueOf(getConfig().mode().toUpperCase());
            WebDriver driver = DriverFactory.get(runmode);
            setDriver(driver);
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
