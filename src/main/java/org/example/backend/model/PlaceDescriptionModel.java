package org.example.backend.model;

import lombok.Data;

@Data
public class PlaceDescriptionModel {
    private Info wikipedia_extracts;

    @Data
    private static class Info {
        private String text;
    }

}
