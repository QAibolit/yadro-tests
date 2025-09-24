package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PartnersPage {

    private final SelenideElement header = $("h1"),
            becomePartnerButton = $(byText("Стать партнером")),
            partnerPortalButton = $(byText("Партнерский портал"));
    private final ElementsCollection subtitles = $$("h2");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public PartnersPage checkHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что отображается кнопка 'Стать партнером'")
    public PartnersPage checkBecomePartnerButton() {
        this.becomePartnerButton.shouldHave(visible, clickable)
                .shouldHave(attribute("href", "https://partners.yadro.com/?is_partner=true"));
        return this;
    }

    @Step("Проверить, что отображается кнопка 'Партнерский портал'")
    public PartnersPage checkPartnerPortalButton() {
        this.partnerPortalButton.shouldHave(visible, clickable)
                .shouldHave(attribute("href", "https://partners.yadro.com/"));
        return this;
    }

    @Step("Проверить, что подзаголовки на странице соответсвуют переданным")
    public PartnersPage checkSubTitles(List<String> subtitles) {
        this.subtitles.shouldHave(texts(subtitles));
        return this;
    }
}
