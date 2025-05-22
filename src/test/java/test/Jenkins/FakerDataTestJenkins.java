package test.Jenkins;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import test.TestBase;

@DisplayName("Allure/Jenkins FakerData тест")

public class FakerDataTestJenkins extends TestBase {

    @Tag("demoqa")
    @Feature("Форма регистрации 'automation-practice-form")
    @Story("Тестирование формы регистрации 'automation-practice-form")
    @Owner("inna_tyulyaeva")
    @DisplayName("Успешная отправка формы регистрации со всеми заполненными полями")
    @Test
    //AllPositive
    void fillFormTestAllPositive() {
        WebStepsFakerDataTestJenkins steps = new WebStepsFakerDataTestJenkins();
        steps.openMainPage()
                .setAllValueFormTest ()
                .checkAllValueFormTest ();
    }

    @Tag("demoqa")
    @Feature("Форма регистрации 'automation-practice-form")
    @Story("Тестирование формы регистрации 'automation-practice-form")
    @Owner("inna_tyulyaeva")
    @DisplayName("Успешная отправка формы регистрации только с обязательными заполненными полями")
    @Test
    //MinPositive
    void fillFormTestMinPositive() {
        WebStepsFakerDataTestJenkins steps = new WebStepsFakerDataTestJenkins();
        steps.openMainPage()
                .setMinValueFormTest ()
                .checkMinValueFormTest ();
    }

    @Tag("demoqa")
    @Feature("Форма регистрации 'automation-practice-form")
    @Story("Тестирование формы регистрации 'automation-practice-form")
    @Owner("inna_tyulyaeva")
    @DisplayName("Запрет отправки формы регистрации только с заполненным невалидным значением параметром")
    @Test
    //Test Negative
    void fillFormTestNegative() {
        WebStepsFakerDataTestJenkins steps = new WebStepsFakerDataTestJenkins();
        steps.openMainPage()
                .setNegativeValueFormTest ()
                .checkNegativeValueFormTest ();
    }

}