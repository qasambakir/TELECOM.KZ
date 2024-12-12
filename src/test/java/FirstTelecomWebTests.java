
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("TELECOM")
@DisplayName("Тестирование сайта Telecom")
public class FirstTelecomWebTests extends TestBase {

    @DisplayName("Открытие информации по увеличению скорости интернета")
    @Test
    void getInformationBoostInternetSpeedTest() {
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
    void getInformationActivateServicesTest() {
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


    @DisplayName("Проверка ввода телефона в поле номер")
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

    @DisplayName("Проверка формы Вопросы и Ответы")
    @Test
    void fillCheckFormTestQuestionsAndAnswers() {
        step("Open main page", () -> {
            open("/");
            $("header").should(appear);
            executeJavaScript("let footer = document.querySelector('footer'); " +
                    "if (footer) footer.remove();");
        });

        step("Open questions and answers", () -> {
            $("a.main-menu__navigation-link[href='/ru/knowledge/14']").shouldBe(visible).click();
            $("div.main-menu__submenu").should(appear);
        });

        step("Select Contact and address", () -> {
            $("a.main-menu__submenu-link[href='/ru/pages/12263/172099']").shouldBe(visible).click();
            $("div.col-lg-8").should(appear);
        });
    }

    @DisplayName("Проверка формы Поиска")
    @Test
    void fillCheckFormSearch() {
        step("Open main page", () -> {
            open("/");
            $("header").should(appear);
            executeJavaScript("let footer = document.querySelector('footer'); " +
                    "if (footer) footer.remove();");
        });

        step("Open questions and answers", () -> {
            $("a.main-menu__navigation-link[href='/ru/knowledge/14']").shouldBe(visible).click();
            $("div.main-menu__submenu").should(appear);
        });

        step("Input Word Loyalty Program and search", () -> {
            // Находим поле ввода внутри блока поиска
            $("div.knowledge__search__wrap input").shouldBe(visible, enabled).setValue("Программа Лояльности");
            // Кликаем на кнопку поиска
            $("div.knowledge__search__wrap button").shouldBe(visible).click();
        });

        step("Expand and verify search result text", () -> {
            // Находим и кликаем по кнопке, чтобы раскрыть текст
            $("div.knowledge__content__item div.knowledge__toggle").shouldBe(visible).click();
            // Проверяем наличие ожидаемого текста
            $("div#search_question_id_2686").shouldHave(text("Программа Лояльности находится в нашем мобильном приложении TelecomKz в разделе \"Бонусы\""));
        });
    }
}
