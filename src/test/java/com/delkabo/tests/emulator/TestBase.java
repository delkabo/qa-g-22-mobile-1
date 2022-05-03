package com.delkabo.tests.emulator;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.delkabo.config.Project;
import com.delkabo.drivers.BrowserstackMobileDriver;
import com.delkabo.drivers.EmulatorMobileDriver;
import com.delkabo.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {

    @BeforeAll
    public static void setup() {

    addListener("AllureSelenide", new AllureSelenide());

        switch (System.getProperty("deviceHost")) {
            case "real":
            case "emulation":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException("need choose deviceHost");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {

        String sessionId = "";

        if (Project.ifBrowserStack()) {
            sessionId = Attach.sessionId();
            Attach.video(sessionId);
        }

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        if (Project.ifBrowserStack()) {
            Attach.video(sessionId);
        }

    }
}