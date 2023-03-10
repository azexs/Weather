package com.example.Weather.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MeteoResponse {

    private double latitude;
    private double longitude;
    private double generationtimeMs;
    private int utc_offset_seconds;
    private String timezone;
    private String timezoneAbbreviation;
    private double elevation;
    @JsonProperty("daily_units")
    private MeteoDailyUnits dailyUnits;
    private MeteoDaily daily;
}