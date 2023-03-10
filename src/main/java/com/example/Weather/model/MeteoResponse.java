package com.example.Weather.model;

import lombok.Data;

@Data
public class MeteoResponse {

    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private double elevation;
    private MeteoDailyUnits daily_units;
    private MeteoDaily daily;
}