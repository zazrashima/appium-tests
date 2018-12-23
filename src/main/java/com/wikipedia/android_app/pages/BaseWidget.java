package com.wikipedia.android_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BaseWidget {

    final AppiumDriver driver;
    private final WebDriverWait wait;

    BaseWidget(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void sendKeys(WebElement element, String textToSend) {
        waitForElementToAppear(element);
        element.sendKeys(textToSend);
    }

    void click(WebElement element) {
        waitForElementToAppear(element);
        element.click();
    }
}