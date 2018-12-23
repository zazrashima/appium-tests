package com.wikipedia.android_app.servers;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServerManager {
    AppiumDriverLocalService appiumService;
    public AppiumServerManager() {
        appiumService = AppiumDriverLocalService.buildDefaultService();
    }

    public void startAppiumServer() {
        appiumService.start();
    }

    public void stopAppiumServer() {
        appiumService.stop();
    }

}
