package com.example.Weather.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MeteoDaily {
    private ArrayList<String> time;
    private ArrayList<String> sunrise;
    private ArrayList<String> sunset;
    private ArrayList<Double> rain_sum;
}
