package com.example.api.Cep.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfigs {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
