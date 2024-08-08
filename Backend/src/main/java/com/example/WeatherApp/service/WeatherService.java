package com.example.WeatherApp.service;

import com.example.WeatherApp.apiResponse.WeatherResponse;
import com.example.WeatherApp.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${weather.api}")
    private String API;

    public WeatherResponse getWeatherDetails(String place){
       String finalApi= API.replace("city",place);
        ResponseEntity<WeatherResponse> response=restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);
        return  response.getBody();


    }


}
