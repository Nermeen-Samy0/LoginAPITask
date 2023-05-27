package com.foodics.infrastructure.configurations;

public class BaseConfiguration {
    private String baseURL = "https://pay2.foodics.dev";

    public String getEnvironmentURL() {
            return baseURL;
    }
}
