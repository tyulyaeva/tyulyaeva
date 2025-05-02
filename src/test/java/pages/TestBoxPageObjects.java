package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxShouldHaveText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxPageObjects {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitClosed = $("#submit");

    public void textBoxResults() {
        new TextBoxShouldHaveText().textBoxResults();
    }

    public TestBoxPageObjects openPage() {
        open("https://demoqa.com/text-box");
        return this;
    }


    public TestBoxPageObjects setFirstName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TestBoxPageObjects setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TestBoxPageObjects setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TestBoxPageObjects setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TestBoxPageObjects clickSubmit() {
        submitClosed.click();
        return this;
    }
}
