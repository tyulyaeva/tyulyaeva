package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BookvoedBookSearchTest {
    @BeforeEach
    void setupConfig() {
        Configuration.browserSize = "1920x1080";
        open("https://www.bookvoed.ru/");
        Configuration.pageLoadStrategy = "eager";
    }

    @ValueSource(strings = {
            "стивен кинг", "агата кристи"
    })
    @ParameterizedTest(name = "Для поискового запроса - {0} - должен отдавать не пустой список книжных карточек")
    @Tag("SMOKE")
    @DisplayName("Тест-кейс №1: Проверка на непустой результат поиска книжных карточек")
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        $("[name=search]").
                setValue(searchQuery).pressEnter();
        $$("div.app-catalog__list")
                .shouldBe(sizeGreaterThan(0));

    }
    @CsvSource(value = {
            "Дэн Симмонс | Гиперион",
            "Анджей Сапковский | Сага о Рейневане"
    }, delimiter = '|')
    @ParameterizedTest(name = "Для поискового запроса {0}- в результате поиска должна быть книга - {1}")
    @Tag("BLOCKER")
    @DisplayName("Тест-кейс №2: Проверка поиска определенной серии книг")
    void searchResultsShouldContainDeterminedBook (String searchQuery, String bookName) {
        $("[name=search]").
                setValue(searchQuery).pressEnter();
        $("div.app-catalog__list")
                .shouldHave(text(bookName));
    }

    @CsvFileSource(resources = "/TestDataFromFile/searchResultsShouldContainDeterminedBookFromFile.csv")
    @ParameterizedTest(name = "Для поискового запроса {0}- в результате поиска должна быть книга - {1}")
    @Tag("BLOCKER")
    @DisplayName("Тест-кейс №3: Проверка поиска определенной серии книг из файла")
    void searchResultsShouldContainDeterminedBookFromFile (String searchQuery, String bookName) {
        $("[name=search]").
                setValue(searchQuery).pressEnter();
        $("div.app-catalog__list")
                .shouldHave(text(bookName));
    }
}
