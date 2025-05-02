package test;

import org.junit.jupiter.api.Test;
import pages.TestBoxPageObjects;

public class TestBoxPageObjectsTest extends TestBase{
    TestBoxPageObjects testBoxPageObjects = new TestBoxPageObjects();

    @Test
    void successTextBoxPageTest() {
        testBoxPageObjects.openPage()
                .setFirstName("Инна Тюляева")
                .setEmail("tyulyaeva.inna@yandex.ru")
                .setCurrentAddress("Санкт-Петербург, п. Парглово")
                .setPermanentAddress("Санкт-Петербург, п. Парглово 2")
                .clickSubmit()
                .textBoxResults();
    }
}
