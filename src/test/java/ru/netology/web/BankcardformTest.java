package ru.netology.web;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class BankcardformTest {
    @Test
    void formAutomationTest() {
        open("http://localhost:9999");
        $("[data-test-id = 'name'] input").setValue("Александр Соколов");
        $("[data-test-id = 'phone'] input").setValue("+79589999999");
        $("[data-test-id = 'agreement']").click();
        $(By.className("button__content")).click();
        $("[data-test-id='order-success']").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}
