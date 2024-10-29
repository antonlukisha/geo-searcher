package org.example.backend.controller;

import lombok.AllArgsConstructor;
import org.example.backend.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class WeatherController {

    private WeatherService locationService;

    @GetMapping("/weather")
    @CrossOrigin(origins = "http://localhost:3000")
    public CompletableFuture<?> searchLocations(@RequestParam("lat") double latitude, @RequestParam("lon") double longitude) {
        return locationService.getWeather(latitude, longitude);
    }
}

