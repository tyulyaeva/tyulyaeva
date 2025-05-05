package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.BirthComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPageObjects {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genterWrapperInput = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityInput = $("#react-select-4-input");
    private final SelenideElement submitClosed = $("#submit");
    BirthComponent birthComponent = new BirthComponent();


    public FormPageObjects openPage () {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }
    public FormPageObjects setValueFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public FormPageObjects setValueLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public FormPageObjects setValueEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public FormPageObjects setValueGenterWrapper (String value) {
        genterWrapperInput.$(byText(value)).click();
        return this;
    }
    public FormPageObjects setValueUserNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public FormPageObjects setValueDateOfBirthday (String day, String month, String year) {
        dateOfBirthInput.click();
        birthComponent.setValueDateOfBirth (day, month, year);
        return this;
    }

    public FormPageObjects setValueSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public FormPageObjects setValueHobbiesWrapper (String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }
    public FormPageObjects setValueUploadPicture (String fileName) {
        uploadPictureInput.uploadFromClasspath("retouch.jpg");
        return this;
    }
    public FormPageObjects setValueCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public FormPageObjects setValueState (String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    public FormPageObjects setValueCity (String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }
    public FormPageObjects clickSubmit () {
        submitClosed.click();
        return this;
    }
}
