package com.reports;

import com.aventstack.extentreports.Status;

import static com.aventstack.extentreports.MediaEntityBuilder.*;
import static com.reports.ExtentManager.getExtentTest;
import static com.utils.ScreenshotUtils.*;

public class ExtentLogger {

    private ExtentLogger() {}

    public static void pass(String message) {
        System.out.println(message);
        getExtentTest().pass(message);
    }

    public static void fail(String message) {
        System.out.println(message);
        getExtentTest().fail(message, createScreenCaptureFromBase64String(getBase64Image()).build());
    }

    public static void skip(String message) {
        System.out.println(message);
        getExtentTest().skip(message);
    }

    public static void info(String message) {
        System.out.println(message);
        getExtentTest().info(message);
    }

    public static void log(Status status, String message) {
        System.out.println(message);
        getExtentTest().log(status, message);
    }
}
