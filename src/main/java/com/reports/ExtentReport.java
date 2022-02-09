package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

import static com.constants.PathConstants.REPORT_PATH;
import static com.reports.ExtentManager.*;

public class ExtentReport {

    public static ExtentReports extent;

    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(REPORT_PATH);
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Mobile Test Report");
            spark.config().setDocumentTitle("AppiumReport");
            extent.attachReporter(spark);
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            unload();
        }
    }

    public static void createExtentTest(String testName) {
        setExtentTest(extent.createTest(testName));
    }

    public static void endExtentTest(String testName) {
        extent.removeTest(testName);
    }
}
