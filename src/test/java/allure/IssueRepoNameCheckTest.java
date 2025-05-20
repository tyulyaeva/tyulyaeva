package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Allure тесты")

public class IssueRepoNameCheckTest
{
    private static final String REPOSITORY = "tyulyaeva/tyulyaeva";

    @BeforeEach
    public void setupConfig() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
    }

    @DisplayName("Проверка Issue и наименования 'tyulyaeva' в заголовке репозитория с помощью Selenide")
    @Test
    public void findIssueRepoNameTest()
    {
        open("https://github.com/");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").pressEnter();

        $("[href='/" + REPOSITORY + "']").click();
        $("[data-content=Issues]").shouldBe(visible)
                .shouldHave(text("Issues"));
        $("[itemprop=name]").shouldHave(text("tyulyaeva"));
    }

    @DisplayName("Проверка Issue и наименования 'tyulyaeva' в заголовке репозитория с помощью Lambda шагов")
    @Test
    public void findIssueRepoNameLambdaStepTest()
    {
        step("Открыть страницу GitHub", () ->
                open("https://github.com"));

        step("Произвести поиск репозитория", () ->
        {
            $(".search-input-container").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Открыть искомый репозиторий", () ->
                $("[href='/" + REPOSITORY + "']").click());

        step("Проверить наименование Issue в репозитории", () ->
                $("[data-content=Issues]").shouldHave(text("Issues")));

        step("Проверить в заголовке репозитория наименование 'tyulyaeva'", () ->
                $("[itemprop=name]").shouldHave(text("tyulyaeva")));
    }

    @DisplayName("Проверка Issue и наименования 'tyulyaeva' в заголовке репозитория с помощью шагов с аннотацией @Step")
    @Test
    public void findIssueRepoNameCommentStepTest()
    {
        WebGithubSteps steps = new WebGithubSteps();

        steps.openGithubMainPage()
                .searchRepository(REPOSITORY)
                .clickFoundRepository(REPOSITORY)
                .checkIssue()
                .checkRepositoryName();
    }
}
