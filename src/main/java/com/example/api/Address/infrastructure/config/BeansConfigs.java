package com.example.api.Address.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfigs {

    @Bean
    public RestClient restClient(){
        return RestClient.create();
    }
}
