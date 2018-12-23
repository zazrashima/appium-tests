package com.wikipedia.android_app.tests;

import com.wikipedia.android_app.servers.AppiumServerManager;
import com.wikipedia.android_app.utils.JsonHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;

public class BaseTest {

    AppiumDriver driver;
    private AppiumServerManager appiumServerManager = new AppiumServerManager();
    private final JSONObject appiumConfigurations = JsonHelper.readJsonFile(System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "test" + File.separator + "resources" + File.separator + "config.json");

    public AppiumDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    protected void setup() throws Exception {
        appiumServerManager.startAppiumServer();
        File app = new File(System.getProperty("user.dir") + File.separator + "app" + File.separator + appiumConfigurations.get("app"));
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, (String) appiumConfigurations.get("platformVersion"));
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, (String) appiumConfigurations.get("deviceName"));
        dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        dc.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "org.*");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        appiumServerManager.stopAppiumServer();
    }
}
