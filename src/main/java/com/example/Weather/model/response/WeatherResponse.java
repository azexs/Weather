package com.example.Weather.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponse {

    private String day;
    private String avarage;
    private String sunrise;
    private String sunset;

}
