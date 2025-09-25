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
@Story("Проверка меню")
public class MenuTests extends BaseTest {

    private final String productsHeader = "Скорость, экономия места, надежность",
            partnerHeader = "Партнерская экосистема YADRO",
            serviceHeader = "Ваша уверенность в надежности технологической инфраструктуры — наш основной приоритет",
            aboutCompanyHeader = "Мы бросаем вызов стереотипам, создаем востребованные инновационные технологии и постоянно развиваемся",
            careerPageHeader = "Быть первым — значит быть частью YADRO";

    private final List<String> productsSubtitles = List.of("Данные — это новый вид энергии",
            "Новый импульс для развития бизнеса", "Шедевры, вдохновленные искусством",
            "Инновационная архитектура. Революционный результат.", "Серверы VEGMAN Rx20 G2",
            "СХД TATLIN.UNIFIED GEN2", "Системы хранения TATLIN.OBJECT");

    private final List<String> partnersSubtitles = List.of("Развитие партнерской экосистемы – один из приоритетов YADRO",
            "Как устроена экосистема партнеров YADRO?", "Преимущества партнерства с YADRO", "Взаимовыгодное сотрудничество");

    private final List<String> serviceTabs = List.of("Программы и опции поддержки", "Дополнительные сервисы",
            "Сервисный портал", "О Сервисе");

    private final List<String> careerMenuButtons = List.of("Образование", "Карьера", "Стажировки");

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка работы кнопки 'Продукты'")
    public void checkProductsButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickProductMenuButton()
                .checkHeader(productsHeader)
                .checkSubTitles(productsSubtitles);
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Партнеры'")
    public void checkPartnersButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickPartnersMenuButton()
                .checkHeader(partnerHeader)
                .checkBecomePartnerButton()
                .checkPartnerPortalButton()
                .checkSubTitles(partnersSubtitles);
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Сервис'")
    public void checkServiceButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickServiceMenuButton()
                .checkHeader(serviceHeader)
                .checkServiceTabs(serviceTabs);
    }

    @Test
    @DisplayName("Проверка работы кнопки 'О нас'")
    public void checkAboutCompanyButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickAboutCompanyMenuButton()
                .checkHeader(aboutCompanyHeader)
                .checkOurProductsButton()
                .clickOurProductsButton()
                .checkHeader(productsHeader);
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Вакансии'")
    public void checkVacanciesButtonTest() {
        mainPage.openPage()
                .closeCookieBanner()
                .clickVacanciesMenuButton()
                .checkHeader(careerPageHeader)
                .checkVacanciesSearchInput()
                .checkAllVacanciesButton()
                .checkMenuButtons(careerMenuButtons);
    }
}
