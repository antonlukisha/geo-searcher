package org.example.backend.model;

import lombok.Data;

import java.util.List;

@Data
public class LocationModel {
    private List<Wrapper> hits;

    @Data
    public static class Wrapper {
        private String id;
        private String name;
        private String country;
        private LocationModel.Wrapper.Point point;

        @Data
        public static class Point {
            private double lat;
            private double lng;
        }
    }

}


