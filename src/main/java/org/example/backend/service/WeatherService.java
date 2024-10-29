package org.example.backend.service;

import org.example.backend.config.*;
import org.example.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Service
public class WeatherService {

    private final WebClient webWeatherClient;

    private final WeatherConfig weatherConfig;

    @Autowired
    public WeatherService(LocationConfig locationConfig, WeatherConfig weatherConfig, PlaceConfig placeConfig) {
        this.weatherConfig = weatherConfig;
        this.webWeatherClient = WebClient.builder()
                .baseUrl(weatherConfig.getApiUrl())
                .build();
    }

    public CompletableFuture<WeatherModel> getWeather(double latitude, double longitude) {
        return webWeatherClient.get()
                .uri("/weather?lang={lang}&lat={latitude}&lon={longitude}&appid={api_key}", "ru", latitude, longitude, weatherConfig.getApiKey())
                .retrieve()
                .bodyToMono(WeatherModel.class)
                .toFuture();
    }
}
