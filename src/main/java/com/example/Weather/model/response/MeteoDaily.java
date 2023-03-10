package com.example.Weather.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MeteoDaily {
    private ArrayList<String> time;
    private ArrayList<String> sunrise;
    private ArrayList<String> sunset;
    @JsonProperty("rain_sum")
    private ArrayList<Double> rainSum;
}
