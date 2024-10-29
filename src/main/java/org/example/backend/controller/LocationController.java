package org.example.backend.controller;

import lombok.AllArgsConstructor;
import org.example.backend.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/locations")
    public CompletableFuture<?> searchLocations(@RequestParam("location") String location) {
        return locationService.getLocation(location);
    }
}

