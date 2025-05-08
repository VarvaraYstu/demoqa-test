package ru.vpankova;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class findJUnit5CodeExamples {

    @Test
    void softAssertionShouldHaveJUnit5CodeExample(){
        //������� Selenide � Github
        open("https://github.com/selenide/selenide");
        //������� � ������ Wiki �������
        $("#wiki-tab").click();
        //���������, ��� � ������ ������� (Pages) ���� �������� SoftAssertions
        $(".js-wiki-more-pages-link").click();
        //������� �������� SoftAssertions
        $$("a").findBy(text("Soft Assertions")).click();
        //���������, ��� ������ ���� ������ ���� ��� JUnit
        $$("div h4")
                .findBy(text("Using JUnit5"))
                .shouldHave(text("Using JUnit5"));
    }
}
