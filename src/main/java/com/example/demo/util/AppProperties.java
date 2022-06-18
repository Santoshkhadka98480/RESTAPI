package com.example.demo.util;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@ConfigurationProperties(prefix = "app")
@Configuration("appProperties")
public class AppProperties  {
    private String username;
    private String password;
    private String algorithm;
}
