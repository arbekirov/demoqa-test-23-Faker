package pages.components;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayNameGenerator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckResultComponent {
    private final static SelenideElement tableResult = $(".table-responsive");
    public void checkKeyValue(String key, String value) {
        tableResult.$(byText(key)).parent().shouldHave(text(value));
    }
}

