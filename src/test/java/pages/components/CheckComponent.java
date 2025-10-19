package pages.components;

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
    public CheckComponent checkResult(List<String> value, int num) {
        for (int i = 0; i < num; i++) {
            checkResultInput.shouldHave(text(value.get(i)));
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
