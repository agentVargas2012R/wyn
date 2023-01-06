package com.rest.api.config;

import com.rest.api.services.ApiRestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    public ApiRestService getApiService() {
        return new ApiRestService();
    }
}
