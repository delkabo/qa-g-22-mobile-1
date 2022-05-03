package com.delkabo.config;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.aeonbits.owner.Config;
import org.junit.jupiter.params.provider.CsvSource;

@Config.Sources({
        "classpath:property/${deviceHost}.properties"
})
public interface CredentialConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("loginWP")
    String loginWP();

    @Key("passwordWP")
    String passwordWP();

    @Key("loginBS")
    String loginBS();

    @Key("passwordBS")
    String passwordBS();

    @Key("identificateapp")
    String identificateapp();

    @Key("url")
    String url();

}
