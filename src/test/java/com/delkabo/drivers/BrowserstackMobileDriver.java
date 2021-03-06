package com.delkabo.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.delkabo.config.Project;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.delkabo.helpers.Browserstack.browserstackLogin;
import static com.delkabo.helpers.Browserstack.browserstackPassword;


public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Project.config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", browserstackLogin);
        mutableCapabilities.setCapability("browserstack.key", browserstackPassword);
        mutableCapabilities.setCapability("app", Project.config.identificateapp());
        mutableCapabilities.setCapability("device", Project.config.deviceName());
        mutableCapabilities.setCapability("os_version", Project.config.platformVersion());
        mutableCapabilities.setCapability("project", "QA.GURU lesson 11/22");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "Sample tests run");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

}