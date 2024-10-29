package org.example.backend.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherModel {
    private List<WeatherDescription> weather;
    private MainWeather main;

    @Data
    public static class WeatherDescription {
        private String description;
    }

    @Data
    private static class MainWeather {
        private double temp;
        private double feels_like;
        private int humidity;
    }

}


