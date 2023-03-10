package com.example.Weather.builder;


import com.example.Weather.model.response.MeteoResponse;
import com.example.Weather.model.response.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherReponseBuilder {

    private static final Integer hoursPerDay = 24;

    public List<WeatherResponse> buildResponse( MeteoResponse details){
        List<WeatherResponse> response = new ArrayList<>();

        String rainUnit = details.getDailyUnits().getRainSum();

        ArrayList<String> time = details.getDaily().getTime();
        ArrayList<String> sunrise = details.getDaily().getSunrise();
        ArrayList<String> sunset = details.getDaily().getSunset();
        ArrayList<Double> rainSum = details.getDaily().getRainSum();

        for (int i = 1; i < time.size(); i++) {
            WeatherResponse weatherResponse = WeatherResponse.builder()
                    .day(time.get(i))
                    .sunrise(sunrise.get(i))
                    .sunset(sunset.get(i))
                    .avarage((rainSum.get(i) / hoursPerDay) + rainUnit)
                    .build();

            response.add(weatherResponse);
        }

        return response;
    }

}
