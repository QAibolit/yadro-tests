package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private final SelenideElement header = $("h1");
    private final ElementsCollection subtitles = $$("h2");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public ProductsPage checkHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что подзаголовки на странице продуктов соответсвуют переданным")
    public ProductsPage checkSubTitles(List<String> subtitles) {
        this.subtitles.shouldHave(texts(subtitles));
        return this;
    }

}
