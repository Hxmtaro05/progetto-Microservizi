package com.corso.garage_service.RestClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class RestClientConfiguration {
    @Value("$services.bikes.url}")
    private String bikeUrl;

    @Value("${services.cars.url}")
    private String carUrl;

    
}
