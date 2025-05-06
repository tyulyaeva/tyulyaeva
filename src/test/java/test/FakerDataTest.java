package test;
import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import pages.components.ResultTableComponent;
import utils.DataForTest;

public class FakerDataTest extends TestBase {
    FormPageObjects pageObjects = new FormPageObjects();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    DataForTest dataForTest = new DataForTest();

    @Test
    //AllPositive
    void fillFormTestAllPositive() {
        pageObjects.openPage()
                .setValueFirstName(dataForTest.firstNameInput)
                .setValueLastName(dataForTest.lastNameInput)
                .setValueEmail(dataForTest.userEmailInput)
                .setValueGenterWrapper(dataForTest.genterWrapperInput)
                .setValueUserNumber(dataForTest.userNumberInput)
                .setValueDateOfBirthday(dataForTest.dayOfBirthInput, dataForTest.monthOfBirthInput, dataForTest.yearOfBirthInput)
                .setValueSubjects(dataForTest.subjectsInput)
                .setValueHobbiesWrapper(dataForTest.hobbiesWrapperInput)
                .setValueUploadPicture(dataForTest.uploadPictureInput)
                .setValueCurrentAddress(dataForTest.currentAddressInput)
                .setValueState(dataForTest.stateInput)
                .setValueCity(dataForTest.cityInput)
                .clickSubmit();


        resultTableComponent.checkResult("Student Name", dataForTest.firstNameInput + " " + dataForTest.lastNameInput)
                .checkResult("Student Email", dataForTest.userEmailInput)
                .checkResult("Gender", dataForTest.genterWrapperInput)
                .checkResult("Mobile", dataForTest.userNumberInput)
                .checkResult("Date of Birth", dataForTest.dayOfBirthInput + " " + dataForTest.monthOfBirthInput + "," + dataForTest.yearOfBirthInput)
                .checkResult("Subjects", dataForTest.subjectsInput)
                .checkResult("Hobbies", dataForTest.hobbiesWrapperInput)
                .checkResult("Picture", dataForTest.uploadPictureInput)
                .checkResult("Address", dataForTest.currentAddressInput)
                .checkResult("State and City", dataForTest.stateInput + " " + dataForTest.cityInput);
    }

    @Test
    //MinPositive
    void fillFormTestMinPositive() {
        pageObjects.openPage()
                .setValueFirstName(dataForTest.firstNameInput)
                .setValueLastName(dataForTest.lastNameInput)
                .setValueGenterWrapper(dataForTest.genterWrapperInput)
                .setValueUserNumber(dataForTest.userNumberInput)
                .clickSubmit();

        resultTableComponent.checkResult("Student Name", dataForTest.firstNameInput + " " + dataForTest.lastNameInput)
                .checkResult("Gender", dataForTest.genterWrapperInput)
                .checkResult("Mobile", dataForTest.userNumberInput);
    }

    @Test
    //Test Negative
    void fillFormTestNegative() {
        pageObjects.openPage()
                .setValueFirstName(dataForTest.firstNameInput)
                .setValueLastName(dataForTest.lastNameInput)
                .setValueEmail(dataForTest.userEmailInput)
                .setValueGenterWrapper(dataForTest.genterWrapperInput)
                .setValueUserNumber("917833220j")
                .setValueUploadPicture(dataForTest.uploadPictureInput)
                .setValueCurrentAddress(dataForTest.currentAddressInput)
                .setValueState(dataForTest.stateInput)
                .setValueCity(dataForTest.cityInput)
                .clickSubmit();

        resultTableComponent.negativeCheck ();
    }

}