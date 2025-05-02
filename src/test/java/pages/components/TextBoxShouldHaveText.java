package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxShouldHaveText {
    public void textBoxResults() {
        $("#output").shouldHave(text("Name:Инна Тюляева\n" +
                "\n" +
                "Email:tyulyaeva.inna@yandex.ru\n" +
                "\n" +
                "Current Address :Санкт-Петербург, п. Парглово\n" +
                "\n" +
                "Permananet Address :Санкт-Петербург, п. Парглово 2"));
    }


}
