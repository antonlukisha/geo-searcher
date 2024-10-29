package org.example.backend.controller;

import lombok.AllArgsConstructor;
import org.example.backend.service.PlaceDescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class PlaceDescriptionController {

    private PlaceDescriptionService locationService;

    @GetMapping("/description")
    @CrossOrigin(origins = "http://localhost:3000")
    public CompletableFuture<?> searchLocations(@RequestParam("id") String id) {
        return locationService.getPlaceDescription(id);
    }
}

