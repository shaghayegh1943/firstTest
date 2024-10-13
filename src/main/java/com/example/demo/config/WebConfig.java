package com.example.demo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * this class declare on ore more Bean methods therefore @configuration
 */
@Configuration
public class WebConfig {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }
}
