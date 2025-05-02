package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ShouldHaveText {
    private final SelenideElement submitModal = $(".table-responsive");

    public ShouldHaveText checkResult(String key, String value) {
        submitModal.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    
    public ShouldHaveText negativeCheck () {
        submitModal.shouldNotBe(visible);
        return this;
    }    
}
