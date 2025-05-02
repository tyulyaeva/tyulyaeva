package test;

import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import pages.components.BirthComponents;
import pages.components.ShouldHaveText;

public class PageObjectsAllPositive extends TestBase {
    FormPageObjects pageObjects = new FormPageObjects();
    BirthComponents birthComponents = new BirthComponents();
    ShouldHaveText shouldHaveText = new ShouldHaveText();

    @Test
    void fillFormTest() {
        pageObjects.openPage()
                .setValueFirstName("Инна")
                .setValueLastName("Тюляева")
                .setValueEmail("tyulyaeva.inna@yandex.ru")
                .setValueGenterWrapper("Female")
                .setValueUserNumber("9178332203")
                .setValueDateOfBirthday("20", "July", "1991")
                .setValueSubjects("Arts")
                .setValueHobbiesWrapper("Reading")
                .setValueUploadPicture("retouch.jpg")
                .setValueCurrentAddress("Санкт-Петербург, п. Парглово")
                .setValueState("Uttar Pradesh")
                .setValueCity("Agra")
                .clickSubmit();

        shouldHaveText.checkResult("Student Name", "Инна Тюляева")
                .checkResult("Student Email", "tyulyaeva.inna@yandex.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9178332203")
                .checkResult("Date of Birth", "20 July,1991")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "retouch.jpg")
                .checkResult("Address", "Санкт-Петербург, п. Парглово")
                .checkResult("State and City", "Uttar Pradesh Agra");

    }
}