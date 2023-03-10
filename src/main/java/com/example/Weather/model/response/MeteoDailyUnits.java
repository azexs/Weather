package com.example.Weather.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MeteoDailyUnits {

    private String time;
    private String sunrise;
    private String sunset;
    @JsonProperty("rain_sum")
    private String rainSum;
}
