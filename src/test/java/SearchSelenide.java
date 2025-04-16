import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenide {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy ="eager";
    }
    @Test
    void FourthLesson() {
        open(baseUrl + "/selenide/selenide");
        $("#wiki-tab").shouldBe(visible).click();
        $("#wiki-body a[href$='SoftAssertions']").shouldBe(visible).click();
        $(".page").shouldHave(text("Using JUnit5 extend test class:"));

    }
}