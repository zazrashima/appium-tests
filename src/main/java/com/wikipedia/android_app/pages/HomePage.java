package com.wikipedia.android_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseWidget {
    @FindBy(xpath = "//*[@text='SKIP']")
    private WebElement skipButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage skipAppSetup() {
        click(skipButton);
        return this;
    }
}
