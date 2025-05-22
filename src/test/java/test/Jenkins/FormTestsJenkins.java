package test.Jenkins;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import test.TestBase;

@DisplayName("Allure/Jenkins тест")

public class FormTestsJenkins  extends TestBase {
    @Tag("registration_form")
    @Feature("Форма регистрации 'automation-practice-form")
    @Story("Тестирование формы регистрации 'automation-practice-form")
    @Owner("inna_tyulyaeva")
    @DisplayName("Успешная отправка формы регистрации со всеми заполненными полями")
    @Test
    void fillFormTest() {
        WebGithubStepsJenkins steps = new WebGithubStepsJenkins();
           steps.openMainPage()
                .setValueFormTest ()
                .checkValueFormTest ();
    }
}