package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSettingTests extends TestBase {

    @Test
    @Tag("android")
    void settingMenuAvailable() {
        step("Technical step to get rid of start menu", () ->
            back()
        );

        step("Click More icon", () ->
            $(AppiumBy.id("org.wikipedia.alpha:id/menu_icon"))
                    .click()
        );

        step("Click Setting menu", () ->
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"))
                    .click()
        );

        step("Setting menu Opened", () ->
            $(AppiumBy.id("android:id/title"))
                    .shouldHave(Condition.text("General"))
        );
    }
}
