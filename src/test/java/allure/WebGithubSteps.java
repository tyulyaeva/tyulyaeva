package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebGithubSteps
{
    @Step("Открыть страницу GitHub")
    public WebGithubSteps openGithubMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Произвести поиск репозитория")
    public WebGithubSteps searchRepository(String repositoryName) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(repositoryName);
        $("#query-builder-test").pressEnter();
        return this;
    }

    @Step("Открыть искомый репозиторий")
    public WebGithubSteps clickFoundRepository(String repositoryName) {
        $("[href='/" + repositoryName + "']").click();
        return this;
    }

    @Step("Проверить наименование Issue в репозитории")
    public WebGithubSteps checkIssue() {
        $("[data-content=Issues]").shouldHave(text("Issues"));
        return this;
    }
    @Step("Проверить в заголовке репозитория наименование 'tyulyaeva'")
    public WebGithubSteps checkRepositoryName() {
        $("[itemprop=name]").shouldHave(text("tyulyaeva"));
        return this;
    }
}
