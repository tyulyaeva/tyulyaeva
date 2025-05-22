package test.Jenkins;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.TestBase;

import java.util.Map;

@DisplayName("Allure/Jenkins FakerData тест")

public class FakerDataTestJenkins extends TestBase {

//    @BeforeAll
//    static void setupConfig(){
//        Configuration.browserSize = "1920x1080";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.pageLoadStrategy ="eager";
//        Configuration.timeout = 10000;
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
//    }

//    @AfterEach
//    void addAttachments() {
//        Attachments.screenshotAs("Last screenshot");
//        Attachments.pageSource();
//        Attachments.browserConsoleLogs();
//        Attachments.addVideo();
//        Selenide.closeWebDriver();
//    }

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