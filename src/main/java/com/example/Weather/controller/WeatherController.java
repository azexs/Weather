package com.example.Weather.controller;


import com.example.Weather.builder.WeatherReponseBuilder;
import com.example.Weather.service.IWeatherService;

import com.example.Weather.model.MeteoResponse;
import com.example.Weather.model.WeatherResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    IWeatherService weatherService;
    WeatherReponseBuilder weatherReponseBuilder;

    public WeatherController(IWeatherService weatherService, WeatherReponseBuilder weatherReponseBuilder) {
        this.weatherService = weatherService;
        this.weatherReponseBuilder = weatherReponseBuilder;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherResponse>> getWeatherDetails(
            @RequestParam Double longitude,
            @RequestParam Double latitude) {

        weatherService.saveRequestParameters(longitude, latitude);

        MeteoResponse meteoResponse = weatherService.getWeatherDetails(longitude, latitude);

        List<WeatherResponse> requestResponse = weatherReponseBuilder.buildResponse(meteoResponse);

        return ResponseEntity.ok(requestResponse);
    }

}