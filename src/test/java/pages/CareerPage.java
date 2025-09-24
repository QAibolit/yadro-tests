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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareerPage {

    private final SelenideElement header = $("h1"),
            searchInput = $("input.first-screen__search"),
            allVacanciesButton = $("a.cards__link");

    private final ElementsCollection menuButtons = $$(".nav__list-wrapper a");

    @Step("Проверить, что заголовок страницы содержит '{headerText}'")
    public CareerPage checkHeader(String headerText) {
        this.header.shouldHave(text(headerText));
        return this;
    }

    @Step("Проверить, что отображается поле поиска вакансий")
    public CareerPage checkVacanciesSearchInput() {
        this.searchInput.shouldHave(visible, clickable);
        return this;
    }

    @Step("Проверить, что отображается кнопка 'Все вакансии'")
    public CareerPage checkAllVacanciesButton() {
        this.allVacanciesButton.shouldHave(visible, clickable)
                .shouldHave(attribute("href", "https://careers.yadro.com/vacancies/"));
        return this;
    }

    @Step("Проверить, что названия кнопок меню соответсвуют переданным")
    public CareerPage checkMenuButtons(List<String> buttonNames) {
        this.menuButtons.shouldHave(texts(buttonNames));
        return this;
    }
}
