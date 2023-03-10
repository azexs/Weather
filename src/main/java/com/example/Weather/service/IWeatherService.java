package com.example.Weather.service;

import com.example.Weather.model.MeteoResponse;

public interface IWeatherService {

    MeteoResponse getWeatherDetails(Double longtitude, Double latitude);

    void saveRequestParameters(Double longitude, Double latitude);
}
