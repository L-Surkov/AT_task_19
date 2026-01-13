package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class GettingStartedScreen {

    private final SelenideElement screenPrimaryText = $(id("org.wikipedia:id/primaryTextView"));
    private final SelenideElement forwardButton = $(id("org.wikipedia:id/fragment_onboarding_forward_button"));
    private final SelenideElement doneButton = $(id("org.wikipedia:id/fragment_onboarding_done_button"));

    @Step("Заголовок соответствует макетам")
    public GettingStartedScreen primaryTextMatch(String header) {
        screenPrimaryText.shouldHave(com.codeborne.selenide.Condition.text(header));
        return this;
    }

    @Step("Переход к следющему экрану тапом")
    public GettingStartedScreen tapForwardButton() {
        forwardButton.click();
        return this;
    }

    @Step("Закончить онбординг")
    public void tapDoneButton() {
        doneButton.click();
    }
}