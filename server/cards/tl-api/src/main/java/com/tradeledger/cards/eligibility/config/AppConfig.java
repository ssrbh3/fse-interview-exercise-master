package com.tradeledger.cards.eligibility.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "server.thirdparty")
public class AppConfig {
    private String baseUrl;
}
