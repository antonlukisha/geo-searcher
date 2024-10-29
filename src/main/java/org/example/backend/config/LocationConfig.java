package org.example.backend.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;

@Data
@Configuration
public class LocationConfig {
    @Value("${location.api.url}")
    private String apiUrl;

    @Value("${location.api.key}")
    private String apiKey;

}
