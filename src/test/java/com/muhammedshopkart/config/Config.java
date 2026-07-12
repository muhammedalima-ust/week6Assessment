package com.muhammedshopkart.config;

public class Config {
    private Config() {}

    private static final String BASEURL = TestEnvironment.optional("baseUrl","http://localhost:8080");
    private static final String APIURL = TestEnvironment.optional("apiUrl","http://localhost:8080");
    private static final String BROWSER = TestEnvironment.optional("browser","chrome");
    private static final String BROWSERSIZE = TestEnvironment.optional("browsersize","1440x900");
    private static final boolean HEADLESS = Boolean.parseBoolean(TestEnvironment.optional("headless", "false"));

    public static String BASEURL_UI(){
        return BASEURL;
    }
    public static String APIURL(){
        return APIURL;
    }

    public static String BROWSER(){
        return BROWSER;
    }

    public static String BROWSERSIZE(){
        return BROWSERSIZE;
    }

    public static boolean HEADLESS(){
        return HEADLESS;
    }

}