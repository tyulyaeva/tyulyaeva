package test;

import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import pages.components.ResultTableComponent;

public class PageObjectsMinPositive extends TestBase {
    FormPageObjects pageObjects = new FormPageObjects();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    void fillFormTest() {
        pageObjects.openPage()
                .setValueFirstName("Инна")
                .setValueLastName("Тюляева")
                .setValueGenterWrapper("Female")
                .setValueUserNumber("9178332203")
                .clickSubmit();

        resultTableComponent.checkResult("Student Name", "Инна Тюляева")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9178332203");


    }
}