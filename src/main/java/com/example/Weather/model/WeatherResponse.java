package com.example.Weather.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponse {

    String day;
    String avarage;
    String sunrise;
    String sunset;

}
