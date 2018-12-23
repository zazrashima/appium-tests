package com.wikipedia.android_app.tests;

import com.wikipedia.android_app.pages.HomePage;
import com.wikipedia.android_app.pages.SearchWidget;
import com.wikipedia.android_app.utils.ExtentReports.ExtentTestManager;
import com.wikipedia.android_app.utils.Log;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(com.wikipedia.android_app.listeners.TestListener.class)
public class SearchTest extends BaseTest {

    private static final String SEARCH_TERM = "Software testing";
    private static final String INVALID_SEARCH = "klhsdkalsfdsa";
    private SearchWidget searchWidget;

    @Test(priority = 1, description = "Search returns should be empty")
    public void invalid_search_should_return_no_results() {
        ExtentTestManager.getTest().setDescription("Search returns should be empty");

        Log.info("Background: Wikipedia Setup is skipped");
        HomePage homePage = new HomePage(driver);
        homePage.skipAppSetup();

        Log.info("When I search for a topic");
        searchWidget = new SearchWidget(driver);
        searchWidget.searchForInvalid(INVALID_SEARCH);

        Log.info("It should return empty results");
        assertThat(searchWidget.searchResultsIsEmpty()).isTrue();

        searchWidget.closeSearch();
    }

    @Test(priority = 2, description = "Search results should return relevant articles")
    public void search_topic_should_return_relevant_article() {
        ExtentTestManager.getTest().setDescription("Search results should return relevant articles");

        Log.info("Background: Wikipedia Setup is skipped");
        HomePage homePage = new HomePage(driver);
        homePage.skipAppSetup();

        Log.info("When I search for a topic");
        searchWidget = new SearchWidget(driver);
        searchWidget.searchForTopic(SEARCH_TERM);

        Log.info("It should return relevant articles");
        assertThat(searchWidget.getNumberOfSearchResults()).isGreaterThan(0);
        assertThat(searchWidget.searchResultContains(SEARCH_TERM)).isTrue();

        searchWidget.closeSearch();
    }
}
