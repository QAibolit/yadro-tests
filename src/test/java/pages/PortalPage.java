package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PortalPage {

    private final SelenideElement portalLogo = $("img.engineer-logo");
    private final ElementsCollection menuButtons = $$(".navbar-nav-wrap .navbar-nav a");

    @Step("Проверить, что отображается логотип портала")
    public PortalPage checkPortalLogo() {
        this.portalLogo.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что названия кнопок меню соответсвуют переданным")
    public PortalPage checkMenuButtons(List<String> buttonNames) {
        this.menuButtons.shouldHave(texts(buttonNames));
        return this;
    }
}
