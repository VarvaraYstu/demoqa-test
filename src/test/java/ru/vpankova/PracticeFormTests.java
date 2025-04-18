package ru.vpankova;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

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
    void fillFormTest(){
        // Переменные
        String name = "Varvara";
        String lastName = "Pankova";
        String email = "varvarapankova@mail.ru";
        String phoneNumber = "8915012112";
        String address = "Moscow,Sergiev Posad, str. 1st May, 24, 12";


        open("https://demoqa.com/automation-practice-form");

        // Заполняем форму
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-2 + label").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__day.react-datepicker__day--016").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbies-checkbox-1 + label").click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        // Проверка
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(name + lastName),
                text(email),
                text("Female"),
                text(phoneNumber),
                text("16 August,2002"),
                text("Maths, Chemistry"),
                text("Sports"),
                text("1.png"),
                text(address),
                text("Haryana Karnal")
        );




    }
}
