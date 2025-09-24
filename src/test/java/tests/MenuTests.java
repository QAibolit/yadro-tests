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
public class MenuTests extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Продукты'")
    public void checkProductsButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickProductMenuButton()
                .checkHeader("Скорость, экономия места, надежность")
                .checkSubTitles(List.of("Данные — это новый вид энергии", "Новый импульс для развития бизнеса",
                        "Шедевры, вдохновленные искусством", "Инновационная архитектура. Революционный результат.",
                        "Серверы VEGMAN Rx20 G2", "СХД TATLIN.UNIFIED GEN2", "Системы хранения TATLIN.OBJECT"));
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Партнеры'")
    public void checkPartnersButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickPartnersMenuButton()
                .checkHeader("Партнерская экосистема YADRO")
                .checkBecomePartnerButton()
                .checkPartnerPortalButton()
                .checkSubTitles(List.of("Развитие партнерской экосистемы – один из приоритетов YADRO",
                        "Как устроена экосистема партнеров YADRO?",
                        "Преимущества партнерства с YADRO", "Взаимовыгодное сотрудничество"));
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Сервис'")
    public void checkServiceButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickServiceMenuButton()
                .checkHeader("Ваша уверенность в надежности технологической инфраструктуры — наш основной приоритет")
                .checkServiceTabs(List.of("Программы и опции поддержки", "Дополнительные сервисы",
                        "Сервисный портал", "О Сервисе"));
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'О нас'")
    public void checkAboutCompanyButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickAboutCompanyMenuButton()
                .checkHeader("Мы бросаем вызов стереотипам, создаем востребованные инновационные технологии и постоянно развиваемся")
                .checkOurProductsButton()
                .clickOurProductsButton()
                .checkHeader("Скорость, экономия места, надежность");
    }

    @Test
    @Story("Проверка меню")
    @DisplayName("Проверка работы кнопки 'Вакансии'")
    public void checkVacanciesButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickVacanciesMenuButton()
                .checkHeader("Быть первым — значит быть частью YADRO")
                .checkVacanciesSearchInput()
                .checkAllVacanciesButton()
                .checkMenuButtons(List.of("Образование", "Карьера", "Стажировки"));
    }
}
