package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverTest {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void FifthLesson() {
        open(baseUrl);
        $(".HeaderMenu-nav").shouldHave(text("Solutions")).$(byText("Solutions")).hover();;
        $(byTagAndText("a","Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(
                text("The AI-powered\n" +
                        "developer platform"));
    }
}