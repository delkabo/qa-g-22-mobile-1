package com.delkabo.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static CredentialConfig config = ConfigFactory.create(CredentialConfig.class);

    public static boolean ifBrowserStack() {
        return System.getProperty("deviceHost").equals("browserstack");
    }
}


