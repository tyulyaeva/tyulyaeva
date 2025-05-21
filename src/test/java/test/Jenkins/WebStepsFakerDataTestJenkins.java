package test.Jenkins;

import io.qameta.allure.Step;
import pages.FormPageObjects;
import pages.components.ResultTableComponent;
import utils.DataForTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsFakerDataTestJenkins {
    FormPageObjects pageObjects = new FormPageObjects();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    DataForTest dataForTest = new DataForTest();

        @Step("Открыть форму регистрации 'automation-practice-form'")
        public WebStepsFakerDataTestJenkins openMainPage() {
        open("automation-practice-form");
        return this;
            }

        @Step("Заполнить форму регистрации 'automation-practice-form' валидными значениями")
        public WebStepsFakerDataTestJenkins setAllValueFormTest() {
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
            return this;
    }
        @Step("Проверка заполнения формы регистрации 'automation-practice-form'")
        public WebStepsFakerDataTestJenkins checkAllValueFormTest() {
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
            return this;
    }

    @Step("Заполнить форму регистрации 'automation-practice-form' только обязательные параметры валидными значениями")
    public WebStepsFakerDataTestJenkins setMinValueFormTest() {
        pageObjects.openPage()
                .setValueFirstName(dataForTest.firstNameInput)
                .setValueLastName(dataForTest.lastNameInput)
                .setValueGenterWrapper(dataForTest.genterWrapperInput)
                .setValueUserNumber(dataForTest.userNumberInput);
        $("#state").scrollIntoView(true).click();
        pageObjects.clickSubmit();
        return this;
    }
    @Step("Проверка заполнения формы регистрации 'automation-practice-form' только обязательные параметры валидными значениями")
    public WebStepsFakerDataTestJenkins checkMinValueFormTest() {
        resultTableComponent.checkResult("Student Name", dataForTest.firstNameInput + " " + dataForTest.lastNameInput)
                .checkResult("Gender", dataForTest.genterWrapperInput)
                .checkResult("Mobile", dataForTest.userNumberInput);
        return this;
    }

    @Step("Заполнить на форме регистрации 'automation-practice-form' параметр невалидным значением")
    public WebStepsFakerDataTestJenkins setNegativeValueFormTest() {
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
        return this;
    }
    @Step("Проверка заполнения на форме регистрации 'automation-practice-form' параметра невалидным значением")
    public WebStepsFakerDataTestJenkins checkNegativeValueFormTest() {
        resultTableComponent.negativeCheck ();
        return this;
    }
}
