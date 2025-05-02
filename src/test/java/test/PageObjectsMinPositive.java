package test;

import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import pages.components.BirthComponents;
import pages.components.ShouldHaveText;

public class PageObjectsMinPositive extends TestBase {
    FormPageObjects pageObjects = new FormPageObjects();
    BirthComponents birthComponents = new BirthComponents();
    ShouldHaveText shouldHaveText = new ShouldHaveText();

    @Test
    void fillFormTest() {
        pageObjects.openPage()
                .setValueFirstName("Инна")
                .setValueLastName("Тюляева")
                .setValueGenterWrapper("Female")
                .setValueUserNumber("9178332203")
                .clickSubmit();

        shouldHaveText.checkResult("Student Name", "Инна Тюляева")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9178332203");


    }
}