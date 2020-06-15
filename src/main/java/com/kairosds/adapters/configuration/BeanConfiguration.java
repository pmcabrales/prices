package com.kairosds.adapters.configuration;

import com.kairosds.PricesApplication;
import com.kairosds.adapters.persistence.PricesRepository;
import com.kairosds.application.services.PricesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PricesApplication.class)
public class BeanConfiguration {

    @Bean
    PricesService pricesService(PricesRepository repository) {
        return new PricesService(repository);
    }
}
