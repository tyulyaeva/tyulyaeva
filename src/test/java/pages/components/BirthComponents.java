package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BirthComponents {
    private final SelenideElement selectYear = $(".react-datepicker__year-select");
    private final SelenideElement selectMonth = $(".react-datepicker__month-select");

    public void setValueDateOfBirth (String day, String month, String year) {
        selectMonth.selectOption(month);
        selectYear.selectOption(year);
        $$("div.react-datepicker__day").findBy(text(day)).click();
    }
}
