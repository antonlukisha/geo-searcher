package org.example.backend.model;

import lombok.Data;

import java.util.List;

@Data
public class PlaceModel {
    private List<Feature> features;

    @Data
    public static class Feature {
        private Properties properties;


        @Data
        public static class Properties {
            private String xid;
            private String name;
        }
    }
}
