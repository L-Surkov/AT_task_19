package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.GettingStartedScreen;

public class GettingStartedTest extends TestBase{

    GettingStartedScreen getStarted = new GettingStartedScreen();
    String firstScreenHeader = "The Free Encyclopedia\n…in over 300 languages";
    String secondScreenHeader = "New ways to explore";
    String thirdScreenHeader = "Reading lists";
    String fourthScreenHeader = "Data & Privacy";

    @Test
    @Tag("GettingStartedTests")
    @Description("Проверка корректного отображения экрана онбординга и заголовков")
    void getStartedScreenPositiveTest() {
        getStarted
                .primaryTextMatch(firstScreenHeader)
                .tapForwardButton()
                .primaryTextMatch(secondScreenHeader)
                .tapForwardButton()
                .primaryTextMatch(thirdScreenHeader)
                .tapForwardButton()
                .primaryTextMatch(fourthScreenHeader)
                .tapDoneButton();
    }
}