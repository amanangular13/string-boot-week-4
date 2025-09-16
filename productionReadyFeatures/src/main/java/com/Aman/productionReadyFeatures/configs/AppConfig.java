package com.Aman.productionReadyFeatures.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper getmodelMapper() {
        return new ModelMapper();
    }
}
