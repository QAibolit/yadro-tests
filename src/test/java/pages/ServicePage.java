package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ServicePage {

    private final SelenideElement header = $("h1");
    private final ElementsCollection serviceTabs = $$("#service-menu li");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public ServicePage checkHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что названия табов сервисов соответсвуют переданным")
    public ServicePage checkServiceTabs(List<String> subtitles) {
        this.serviceTabs.shouldHave(texts(subtitles));
        return this;
    }
}
