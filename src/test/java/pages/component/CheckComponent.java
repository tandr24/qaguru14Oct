package pages.component;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class CheckComponent {
    private SelenideElement checkResultInput = $("div.table-responsive");
    private SelenideElement checkInput = $("#example-modal-sizes-title-lg");

    public CheckComponent checkResult(String value) {
        checkResultInput.shouldHave(text(value));
        return this;
    }

    public CheckComponent haveResultPhrase() {
        checkInput.shouldHave(visible);
        return this;
    }

    public CheckComponent notHaveResultPhrase() {
        checkInput.shouldNotHave(visible);
        return this;
    }
}
