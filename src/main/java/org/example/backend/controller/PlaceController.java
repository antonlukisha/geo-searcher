package org.example.backend.controller;

import lombok.AllArgsConstructor;
import org.example.backend.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class PlaceController {

    private PlaceService locationService;

    @GetMapping("/places")
    @CrossOrigin(origins = "http://localhost:3000")
    public CompletableFuture<?> searchLocations(@RequestParam("lat") double latitude, @RequestParam("lon") double longitude) {
        return locationService.getPlaces(latitude, longitude);
    }
}

