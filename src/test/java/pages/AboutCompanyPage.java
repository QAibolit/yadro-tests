package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AboutCompanyPage {

    private final SelenideElement header = $("h1"),
            ourProductsButton = $(byText("Познакомьтесь с продуктами YADRO"));

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public AboutCompanyPage checkHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что отображается кнопка 'Познакомьтесь с продуктами YADRO'")
    public AboutCompanyPage checkOurProductsButton() {
        this.ourProductsButton.shouldHave(visible, clickable)
                .shouldHave(attribute("href", "https://yadro.com/ru/products"));
        return this;
    }

    @Step("Нажать на кнопку 'Познакомьтесь с продуктами YADRO'")
    public ProductsPage clickOurProductsButton() {
        this.ourProductsButton.click();
        return new ProductsPage();
    }
}
