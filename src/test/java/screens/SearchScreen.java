package screens;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;


public class SearchScreen {

    private final String searchButton = "Search Wikipedia";
    private final String searchInputId = "org.wikipedia.alpha:id/search_src_text";
    private final String resultItemId = "org.wikipedia.alpha:id/page_list_item_title";

    @Step("Открыть поиск")
    public void openSearch() {
        $(accessibilityId(searchButton)).click();
    }

    @Step("Ввести запрос: {term}")
    public void typeSearch(String term) {
        $(id(searchInputId)).sendKeys(term);
    }

    @Step("Кликнуть по первому результату")
    public void clickFirstResult() {
        $(id(resultItemId)).click();
    }

    @Step("Проверить, что результаты поиска отобразились")
    public void verifyResultsArePresent() {
        int size = $$(id(resultItemId)).size();
        assertThat(size)
                .withFailMessage("Результаты поиска не найдены. Ожидалось > 0, найдено: %d", size)
                .isGreaterThan(0);
    }

    @Step("Проверить, что заголовок статьи — {expectedTitle}")
    public void verifyTitleIs(String expectedTitle) {
        $(byText(expectedTitle))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText(expectedTitle));
    }
}
