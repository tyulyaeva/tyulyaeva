package test;

import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import pages.components.ResultTableComponent;

public class PageObjectsAllPositive extends TestBase {
    FormPageObjects pageObjects = new FormPageObjects();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

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

        resultTableComponent.checkResult("Student Name", "Инна Тюляева")
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