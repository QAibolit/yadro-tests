package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement header = $$("h1").first(),
            cookieBanner = $("[data-storage-item]"),
            cookieButton = $("[data-storage-item] button"),
            navbar = $(".yardo-top-menu"),
            productsMenuButton = $(".yardo-top-menu").$(byText("Продукты")),
            partnersMenuButton = $(".yardo-top-menu").$(byText("Партнеры")),
            serviceMenuButton = $(".yardo-top-menu").$(byText("Сервис")),
            aboutCompanyMenuButton = $(".yardo-top-menu").$(byText("О нас")),
            vacanciesMenuButton = $(".yardo-top-menu").$(byText("Вакансии")),
            goToPortalButton = $(byText("Перейти на портал")),
            tatlinProductButton = $(byText("Познакомьтесь с TATLIN.BACKUP")).parent();

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        this.navbar.shouldBe(visible);
        this.header.shouldHave(text("Портал инженерной культуры"));
        return this;
    }

    @Step("Закрыть cookie-баннер")
    public MainPage closeCookieBanner() {
        this.cookieBanner.shouldBe(visible);
        this.cookieButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Продукты' в меню")
    public ProductsPage clickProductMenuButton() {
        this.productsMenuButton.shouldBe(visible).click();
        return new ProductsPage();
    }

    @Step("Нажать на кнопку 'Партнеры' в меню")
    public PartnersPage clickPartnersMenuButton() {
        this.partnersMenuButton.shouldBe(visible).click();
        return new PartnersPage();
    }

    @Step("Нажать на кнопку 'Сервис' в меню")
    public ServicePage clickServiceMenuButton() {
        this.serviceMenuButton.shouldBe(visible).click();
        return new ServicePage();
    }

    @Step("Нажать на кнопку 'О нас' в меню")
    public AboutCompanyPage clickAboutCompanyMenuButton() {
        this.aboutCompanyMenuButton.shouldBe(visible).click();
        return new AboutCompanyPage();
    }

    @Step("Нажать на кнопку 'Вакансии' в меню")
    public CareerPage clickVacanciesMenuButton() {
        this.vacanciesMenuButton.shouldBe(visible).click();
        return new CareerPage();
    }

    @Step("Нажать на кнопку 'Перейти на портал' в меню")
    public PortalPage clickGoToPortalButton() {
        this.goToPortalButton.shouldBe(visible).click();
        return new PortalPage();
    }

    @Step("Нажать на кнопку 'Познакомьтесь с TATLIN.BACKUP' в меню")
    public TatlinProductPage clickTatlinProductButton() {
        int buttonWidth = this.tatlinProductButton.getSize().getWidth();
        this.tatlinProductButton.shouldBe(visible, clickable);
        new Actions(WebDriverRunner.getWebDriver())
                .moveToElement(this.tatlinProductButton, -buttonWidth / 2, 0)
                .click()
                .build()
                .perform();
        return new TatlinProductPage();
    }

}
