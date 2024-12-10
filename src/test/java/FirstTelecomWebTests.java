import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("TELECOM")
@DisplayName("Тестирование сайта Telecom")
public class FirstTelecomWebTests extends TestBase {

    @DisplayName("Открытие информации по увеличению скорости интернета")
    @Test
    void GetInformationBoostInternetSpeedTest() {
        step("Open main page", () -> {
            open("/");
            $("header").should(appear);
            executeJavaScript("let footer = document.querySelector('footer'); " +
                    "if (footer) footer.remove();");
        });

        step("Navigate to Internet section", () -> {
            $("a.main-menu__navigation-link[href='/ru/common/internet']").shouldBe(visible).click();
            $("div.TabPackageService").should(appear);
        });

        step("Open Sapa+ details page", () -> {
            $("div.SAPAPLUSBanner").shouldBe(visible);
            $("div.SAPAPLUSBanner button.check-btn").shouldHave(text("Подробнее")).click();
        });
    }

    @DisplayName("Получение информации по подключению Тарифа Keremet TV")
    @Test
    void GetInformationActivateServicesTest() {
        step("Open main page", () -> {
            open("/");
            $("header").should(appear);
            executeJavaScript("let footer = document.querySelector('footer'); " +
                    "if (footer) footer.remove();");
        });

        step("Navigate to Internet section", () -> {
            $("a.main-menu__navigation-link[href='/ru/common/internet']").shouldBe(visible).click();
            $("div.TabPackageService").should(appear);
        });

        step("Select Activate Keremet TV", () -> {
            $("#slide-ftth0371").$("button.btn").click();
        });
    }

    @Disabled("Временное отключение Проверки тех возможности")
    @DisplayName("Проверка технической возможности")
    @Test
    void fillTechnicalCheckFormTest() {
        step("Open main page", () -> {
            open("/");
            $("header").should(appear);
            executeJavaScript("let footer = document.querySelector('footer'); " +
                    "if (footer) footer.remove();");
        });

        step("Navigate to Internet section", () -> {
            $("a.main-menu__navigation-link[href='/ru/common/internet']").shouldBe(visible).click();
            $("div.TabPackageService").should(appear);
        });

        step("Navigate to Technical Check section", () -> {
            $("a.main-menu__submenu-link[href='/ru/technical-check']").shouldBe(visible).click();
            $("div.technical-check").should(appear);
        });

        step("Fill phone number", () -> {
            $("input[name='phone']").shouldBe(visible, enabled).setValue("7000000000");
        });

    }

}
