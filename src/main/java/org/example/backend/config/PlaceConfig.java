package org.example.backend.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PlaceConfig {
    @Value("${place.api.url}")
    private String apiUrl;
    @Value("${place.api.key}")
    private String apiKey;
}
