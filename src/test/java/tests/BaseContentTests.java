package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.List;

@Tag("regress")
@Owner("Dina Kholomkina")
@Epic("Сайт 'https://yadro.com/'")
@Feature("Главная страница")
@Story("Проверка контента главной страницы")
public class BaseContentTests extends BaseTest {

    private final String productHeader = "TATLIN.BACKUP",
            productInfo = "Специализированная система для хранения данных резервных копий";

    private final List<String> portalMenuButtons = List.of("Темы", "Мастерская", "Интервью", "Склад ума",
            "Лекторий", "Подкасты");

    private final List<String> productSubtitles = List.of("Узнайте больше о TATLIN.BACKUP", "Характеристики",
            "Технологии", "Расчет экономии хранения", "Подробности о продукте");

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка работы кнопки 'Перейти на портал'")
    public void checkGoToPortalButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickGoToPortalButton()
                .checkPortalLogo()
                .checkMenuButtons(portalMenuButtons);
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Познакомьтесь с TATLIN.BACKUP'")
    public void checkTatlinProductButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickTatlinProductButton()
                .checkHeader(productHeader)
                .checkProductInfo(productInfo)
                .checkSubTitles(productSubtitles);
    }
}
