package com.example.Weather.service.impl;


import com.example.Weather.service.IWeatherService;
import com.example.Weather.model.MeteoResponse;
import com.example.Weather.model.RequestLog;
import com.example.Weather.repository.RequestLogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class WeatherService implements IWeatherService {

    private static final String URL = "https://api.open-meteo.com/v1/forecast";

    private static final String PATH = "?latitude={p1}&longitude={p2}&daily=sunrise,sunset,rain_sum&past_days=7&forecast_days=1&timezone=auto";

    RequestLogRepository requestLogRepository;

    public WeatherService(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    @Override
    public MeteoResponse getWeatherDetails(Double longitude, Double latitude) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MeteoResponse> meteoResponse
                = restTemplate.getForEntity(URL + PATH, MeteoResponse.class, latitude, longitude);

        System.out.println(meteoResponse.getBody());

        return meteoResponse.getBody();
    }

    @Override
    public void saveRequestParameters(Double longitude, Double latitude){
         requestLogRepository.save(RequestLog.builder()
                 .logitude(longitude)
                 .latitude(latitude)
                 .created(new Date())
                 .build());

    }


}
