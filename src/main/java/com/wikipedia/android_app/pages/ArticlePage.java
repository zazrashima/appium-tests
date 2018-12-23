package com.wikipedia.android_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BaseWidget {

    @FindBy(id = "heading_0")
    private WebElement articleHeader;

    ArticlePage(AppiumDriver driver) {
        super(driver);
    }

    void waitForArticlePageToLoad() {
        waitForElementToAppear(articleHeader);
    }

    public String getArticleTitle() {
        System.out.println(articleHeader.getText());
        return articleHeader.getText();
    }
}
