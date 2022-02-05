package com.driver;

import com.enums.RunMode;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver get(RunMode mode) {
        WebDriver driver = null;

        if (mode.equals(RunMode.LOCAL)) {
            driver = new LocalDriverImpl().getDriver();
        }
        else if (mode.equals(RunMode.BS)) {
            driver = new BrowserStackImpl().getDriver();
        }

        return driver;
    }
}
