package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ProjectConfig.projectConfig;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = projectConfig.baseUrl();
        Configuration.pageLoadStrategy = projectConfig.pageLoadStrategy();
        Configuration.timeout = projectConfig.timeout();
        Configuration.browser = System.getProperty("browser", projectConfig.browser());
        Configuration.browserVersion = System.getProperty("browserVersion", projectConfig.browserVersion());
        Configuration.browserSize = System.getProperty("browserSize", projectConfig.browserSize());

        if (projectConfig.remote()) {
            Configuration.remote = System.getProperty("remoteUrl");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", projectConfig.enableVnc(),
                    "enableVideo", projectConfig.enableVideo()
            ));
            Configuration.browserCapabilities = capabilities;
        }

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (projectConfig.remote() && projectConfig.enableVideo()) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}
