package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.List;

@Epic("Сайт 'https://yadro.com/'")
@Feature("Главная страница")
public class BaseContentTests extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @Story("Проверка контента главной страницы")
    @DisplayName("Проверка работы кнопки 'Перейти на портал'")
    public void checkGoToPortalButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickGoToPortalButton()
                .checkPortalLogo()
                .checkMenuButtons(List.of("Темы", "Мастерская", "Интервью", "Склад ума", "Лекторий", "Подкасты"));
    }

    @Test
    @Story("Проверка контента главной страницы")
    @DisplayName("Проверка работы кнопки 'Познакомьтесь с TATLIN.BACKUP'")
    public void checkTatlinProductButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickTatlinProductButton()
                .checkHeader("TATLIN.BACKUP")
                .checkProductInfo("Специализированная система для хранения данных резервных копий")
                .checkSubTitles(List.of("Узнайте больше о TATLIN.BACKUP", "Характеристики", "Технологии",
                        "Расчет экономии хранения", "Подробности о продукте"));
    }
}
