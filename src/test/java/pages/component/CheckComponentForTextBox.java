package pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponentForTextBox {
    private SelenideElement checkInput = $("#output");

    public CheckComponentForTextBox checkResult (String value) {
        checkInput.shouldHave(text(value));
        return this;
    }
}
