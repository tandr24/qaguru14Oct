package pages.component;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {
    private SelenideElement checkResultInput = $("div.table-responsive");
    private SelenideElement checkInput = $("#example-modal-sizes-title-lg");

    public CheckComponent checkResult(String value) {
        checkResultInput.shouldHave(text(value));
        return this;
    }
    public CheckComponent checkResult(List<String> value) {
        for (String s : value) {
            checkResultInput.shouldHave(text(s));
        }
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
