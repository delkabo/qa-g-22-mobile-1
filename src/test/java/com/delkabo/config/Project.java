package com.delkabo.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static CredentialConfig config = ConfigFactory.create(CredentialConfig.class, System.getProperties());

    public static String getLoginwp() {
        return config.loginWP();
    }

    public static String getPasswordwp() {
        return config.passwordWP();
    }

    public static String getLoginbs() {
        return config.loginBS();
    }

    public static String getPasswordbs() {
        return config.passwordBS();
    }

    public static String getIdentapp() {
        return config.identificateapp();
    }

    public static String getUrl() {
        return config.url();
    }
}
