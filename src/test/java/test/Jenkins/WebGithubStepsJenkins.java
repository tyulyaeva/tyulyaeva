package test.Jenkins;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebGithubStepsJenkins {

        @Step("Открыть форму регистрации 'automation-practice-form'")
        public WebGithubStepsJenkins openMainPage() {
        open("automation-practice-form");
        return this;
            }

        @Step("Заполнить форму регистрации 'automation-practice-form' валидными значениями")
        public WebGithubStepsJenkins setValueFormTest() {
            $("#firstName").setValue("Инна");
            $("#lastName").setValue("Тюляева");
            $("#userEmail").setValue("tyulyaeva.inna@yandex.ru");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("9178332203");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1991");
            $(".react-datepicker__month").$(byText("20")).click();
            $("#subjectsInput").setValue("Arts").pressEnter();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#uploadPicture").uploadFromClasspath("retouch.jpg");
            $("#currentAddress").setValue("Санкт-Петербург, п. Парглово").pressEnter();
            $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
            $("#react-select-4-input").setValue("Agra").pressEnter();
            $("#submit").click();
            return this;
    }
        @Step("Проверка заполнения формы регистрации 'automation-practice-form'")
        public WebGithubStepsJenkins checkValueFormTest() {
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Инна Тюляева"));
            $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("tyulyaeva.inna@yandex.ru"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9178332203"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 July,1991"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("retouch.jpg"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Санкт-Петербург, п. Парглово"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
            return this;
    }
}
