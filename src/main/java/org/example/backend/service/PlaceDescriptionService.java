package org.example.backend.service;

import org.example.backend.config.*;
import org.example.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Service
public class PlaceDescriptionService {

    private final WebClient webPlaceDescriptionClient;

    private final PlaceConfig placeConfig;

    @Autowired
    public PlaceDescriptionService(LocationConfig locationConfig, WeatherConfig weatherConfig, PlaceConfig placeConfig) {
        this.placeConfig = placeConfig;
        this.webPlaceDescriptionClient = WebClient.builder()
                .baseUrl(placeConfig.getApiUrl())
                .build();
    }

    public CompletableFuture<PlaceDescriptionModel> getPlaceDescription(String placeId) {
        return webPlaceDescriptionClient.get()
                .uri("/{lang}/places/xid/{xid}?format={format}&apikey={api_key}", "ru", placeId, "geojson", placeConfig.getApiKey())
                .retrieve()
                .bodyToMono(PlaceDescriptionModel.class)
                .toFuture();
    }

}
