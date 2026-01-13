package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

public class SearchTests extends TestBase {

    private SearchScreen searchScreen;

    @Test
    @Tag("SearchTests")
    @Description("Проверка поисковой строки и вывода релевантного значения в поиске")
    void successfulSearchTest() {
        searchScreen = new SearchScreen();
        String searchTerm = "Appium";
        searchScreen.openSearch();
        searchScreen.typeSearch(searchTerm);
        searchScreen.verifyResultsArePresent();
    }

    @Test
    @Tag("SearchTests")
    @Description("Проверка поисковой строки и открытия статьи при клике на результат")
    void searchAndOpenArticle() {
        searchScreen = new SearchScreen();
        String searchTerm = "RestApi";
        String expectedTitle = "REST";
        searchScreen.openSearch();
        searchScreen.typeSearch(searchTerm);
        searchScreen.clickFirstResult();
        searchScreen.verifyTitleIs(expectedTitle);
    }
}
