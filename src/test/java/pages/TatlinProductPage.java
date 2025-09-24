package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TatlinProductPage {

    private final SelenideElement header = $("h1.uppercase"),
            productInfo = $("h1.uppercase").sibling(0);

    private final ElementsCollection subtitles = $$("h2[class*='text']");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public TatlinProductPage checkHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что под заголовком отображается информация о продукте")
    public TatlinProductPage checkProductInfo(String productInfo) {
        this.productInfo.shouldHave(visible)
                .shouldHave(text(productInfo));
        return this;
    }

    @Step("Проверить, что подзаголовки на странице продукта соответсвуют переданным")
    public TatlinProductPage checkSubTitles(List<String> subtitles) {
        this.subtitles.shouldHave(texts(subtitles));
        return this;
    }
}
