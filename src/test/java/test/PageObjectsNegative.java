package test;


import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import pages.components.ShouldHaveText;

public class PageObjectsNegative extends TestBase {
    FormPageObjects pageObjects = new FormPageObjects();
    ShouldHaveText shouldHaveText = new ShouldHaveText();

    @Test
    void fillFormTest() {
        pageObjects.openPage()
                .setValueFirstName("Инна")
                .setValueLastName("Тюляева")
                .setValueEmail("tyulyaeva.inna@yandex.ru")
                .setValueGenterWrapper("Female")
                .setValueUserNumber("917833220j")
                .setValueUploadPicture("retouch.jpg")
                .setValueCurrentAddress("Санкт-Петербург, п. Парглово")
                .setValueState("Uttar Pradesh")
                .setValueCity("Agra")
                .clickSubmit();


        shouldHaveText.negativeCheck ();
    }

}

