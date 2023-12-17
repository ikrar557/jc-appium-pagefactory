package com.juaracoding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;

    // Setup environment for emulator device with android studio
    public static void Android_Emulator_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 6 API 30 Appium");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/catatan_keuangan_1.1.1.apk");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true); // For auto allow the permission
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
    }

    // Setup environment for real device
    public static void Android_RealDevice_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Xiaomi 11T");
        capabilities.setCapability("udid", "xkam49krs8vodace");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/catatan_keuangan_1.1.1.apk");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoGrantPermissions", true);  // For auto allow the permission
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
    }

    public static void tearDown(){
        if (null != driver){
            driver.quit();
        }
    }
}
