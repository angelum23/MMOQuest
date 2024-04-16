package com.exer4.exer4.domain.Enums;

import org.springframework.stereotype.Component;

@Component
public class Coordenada {
    private Float latitude;
    private Float longitude;

    public Float getLatitude() {
        return latitude;
    }
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
