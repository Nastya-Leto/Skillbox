
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

public class TestShop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;


    }

    @Test
    void testShopAuto() {

        open("http://intershop.skillbox.ru/");
        $(".site-title").shouldBe(Condition.visible);
        $("[name=s]").setValue("Машина").pressEnter();
        $$("li.shipping-taxable").shouldHave(sizeGreaterThanOrEqual(3));
        $$("li.shipping-taxable").first().shouldBe(Condition.visible)
                .shouldHave(Condition.textCaseSensitive("машина"));


    }
}

