package com.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @ParameterizedTest(name = "В поисковой выдаче яндекса должно отображаться 10 результатов по запросу {0}")
    @ValueSource(strings = {
            "Selenide", "Allure"
    })
    @Tag("BLOCKER")
    public void searchResulstShouldBeGreaterThan10(String testData){
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$("li.serp-item").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(10));
    }

    @CsvSource(value = {
            "Selenide,      Selenide",
            "Allure,        Allure"
    })
    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отображаться текст {1}}")
    @Tag("BLOCKER")
    public void firstSearchResulstShouldContainExpectedText(String testData, String expectedText){
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$("li.serp-item").first().shouldHave(Condition.text(expectedText));
    }
}
