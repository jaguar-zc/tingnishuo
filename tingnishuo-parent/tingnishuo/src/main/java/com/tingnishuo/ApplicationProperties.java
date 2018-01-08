package com.tingnishuo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "application")
public class ApplicationProperties {
    String name;
    String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
