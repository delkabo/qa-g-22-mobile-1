package com.delkabo.config;

import org.aeonbits.owner.Config;

public interface CredentialConfig extends Config {

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
