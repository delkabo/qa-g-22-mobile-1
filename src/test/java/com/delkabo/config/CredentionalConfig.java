package com.delkabo.config;

import org.aeonbits.owner.Config;

public interface CredentionalConfig extends Config {

    @Key("loginWP")
    String loginWP();

    @Key("passwordWP")
    String passwordWP();

    @Key("urlApp")
    String urlApp();

    @Key("loginBS")
    String loginBS();

    @Key("passwordBS")
    String passwordBS();

}
