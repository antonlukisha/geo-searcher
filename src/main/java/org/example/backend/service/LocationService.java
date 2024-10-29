package org.example.backend.service;

import org.example.backend.config.LocationConfig;
import org.example.backend.config.PlaceConfig;
import org.example.backend.config.WeatherConfig;
import org.example.backend.model.LocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Service
public class LocationService {

    private final WebClient webLocationClient;

    private final LocationConfig locationConfig;

    @Autowired
    public LocationService(LocationConfig locationConfig, WeatherConfig weatherConfig, PlaceConfig placeConfig) {
        this.locationConfig = locationConfig;
        this.webLocationClient = WebClient.builder()
                .baseUrl(locationConfig.getApiUrl())
                .build();
    }

    public CompletableFuture<LocationModel> getLocation(String location) {
        return webLocationClient.get()
                .uri("/geocode?q={location}&locale={lang}&key={api_key}", location, "ru", locationConfig.getApiKey())
                .retrieve()
                .bodyToMono(LocationModel.class)
                .toFuture();
    }
}
