package com.web.core;

import com.web.poms.Login;
import com.web.poms.Menu;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String CONFIG_PATH = "application.conf";

    protected Logger log;
    private static LocalDateTime timePoint = LocalDateTime.now();
    private String dateTime = timePoint.get(ChronoField.YEAR_OF_ERA) + "-" + timePoint.getMonth() + "-"
            + timePoint.getDayOfMonth() + "_" + timePoint.getHour() + "-" + timePoint.getMinute() + "-"
            + timePoint.getSecond();
    private String testName = this.getClass().getSimpleName();
    protected WebDriver driver;
    protected Config conf =	ConfigFactory.parseFile(new File(CONFIG_PATH));

    @BeforeClass
    public void beforeClass() {
        System.setProperty("log4j.configurationFile", "resources/log4j2.xml");
        String logPath = "logs/" + testName + "_" + dateTime + "/" ;
        String logFileName = logPath + testName + "_" + dateTime + ".log";
        System.setProperty("logPath", logPath);
        System.setProperty("logFileName", logFileName);

        ((LoggerContext) LogManager.getContext(false)).reconfigure();

        log = LogManager.getLogger(testName);
        log.info("'" + testName + "' test started");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (!result.isSuccess()) {
            takeScreenshot();
        }
        driver.close();
        driver.quit();
    }

    public void takeScreenshot() {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        LocalDateTime timePoint = LocalDateTime.now();
        String name = System.getProperty("logPath") + testName + "_" + timePoint.get(ChronoField.YEAR_OF_ERA) + "-"
                + timePoint.getMonth() + "-" + timePoint.getDayOfMonth() + "_" + timePoint.getHour() + "-"
                + timePoint.getMinute() + "-" + timePoint.getSecond() + ".png";
        File DestFile = new File(name);
        log.info("Screenshot name is " + name);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginWithDefaultUser() {
        loginWithUser(conf.getString("username"), conf.getString("password"));
    }

    public void loginWithUser(String username, String password) {
        driver.get(conf.getString("adminUrl"));
        Login login = new Login(driver);

        login.usernameInput.sendKeys(username);
        login.passwordInput.sendKeys(password);
        login.loginBtn.click();
    }
}