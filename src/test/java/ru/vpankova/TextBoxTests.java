package ru.vpankova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    WebDriver driver;

    @BeforeEach
    void driverSetup(){
        // Устанавливаем WebDriverManager для Chrome
        WebDriverManager.chromedriver().setup();

        // Создаем ChromeOptions и добавляем аргумент для открытия браузера в полноэкранном режиме
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Открытие браузера в полном окне

        // Создаем экземпляр ChromeDriver с этими опциями
        driver = new ChromeDriver(options);

        // Устанавливаем созданный WebDriver в WebDriverRunner
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    void filFormTest() {
        // Объявление переменных
        String name = "Varvara";
        String email = "varvarapankova@mail.ru";
        String currentAddress = "test current address";
        String permanentAddress = "test permanent address";

        // Открываем нужную страницу
        open("https://demoqa.com/text-box");

        // Заполняем форму
        $("#userName").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        // Нажимаем кнопку отправки
        $("#submit").click();

        // Проверка заполнения
        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
