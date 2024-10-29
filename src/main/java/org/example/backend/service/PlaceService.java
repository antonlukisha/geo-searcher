package org.example.backend.service;

import org.example.backend.config.*;
import org.example.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Service
public class PlaceService {

    private final WebClient webPlaceClient;

    private final PlaceConfig placeConfig;

    @Autowired
    public PlaceService(LocationConfig locationConfig, WeatherConfig weatherConfig, PlaceConfig placeConfig) {
        this.placeConfig = placeConfig;
        this.webPlaceClient = WebClient.builder()
                .baseUrl(placeConfig.getApiUrl())
                .build();
    }

    public CompletableFuture<PlaceModel> getPlaces(double latitude, double longitude) {
        return webPlaceClient.get()
                .uri("/{lang}/places/radius?radius={radius}&lat={latitude}&lon={longitude}&format={format}&apikey={api_key}", "ru", 2000, latitude, longitude, "geojson", placeConfig.getApiKey())
                .retrieve()
                .bodyToMono(PlaceModel.class)
                .toFuture();
    }

}
