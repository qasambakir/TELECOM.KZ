import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

        @BeforeAll
        static void setup() {
            Configuration.baseUrl = "https://telecom.kz/ru/";
            Configuration.pageLoadStrategy = "eager";
            Configuration.timeout = 10000;
            Configuration.remote = "https://" + System.getProperty("REMOTE_LOGIN") + "@" + System.getProperty("REMOTE_URL");
            Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserVersion = System.getProperty("browserVersion", "126.0");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "videoName", System.getProperty("REMOTE_VIDEO_URL", "default_video.mp4")
            ));
            Configuration.browserCapabilities = capabilities;

            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }

        @AfterEach
        void afterEach() {
            Attach.screenshotAs("Last screenshot");
            Attach.addVideo();
            Selenide.closeWebDriver();
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }

}