package ru.vpankova;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class findJUnit5CodeExamples {

    @Test
    void softAssertionShouldHaveJUnit5CodeExample(){
        //Открыть Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейте в раздел Wiki проекта
        $("#wiki-tab").click();
        //Проверить, что в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        //Открыть страницу SoftAssertions
        $$("a").findBy(text("Soft Assertions")).click();
        //Проверить, что внутри есть пример кода для JUnit
        $$("div h4")
                .findBy(text("Using JUnit5"))
                .shouldHave(text("Using JUnit5"));
    }
}
