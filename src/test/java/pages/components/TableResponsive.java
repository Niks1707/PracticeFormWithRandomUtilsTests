package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsive {

    public void checkResult(String key, String value) {
        $(".modal-body").$(byText(key)).parent().shouldHave(text(value));
    }

}

