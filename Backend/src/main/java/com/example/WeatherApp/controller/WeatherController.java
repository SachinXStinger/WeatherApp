package com.example.WeatherApp.controller;

import com.example.WeatherApp.apiResponse.WeatherResponse;

import com.example.WeatherApp.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    public WeatherService weatherService;

    @GetMapping("{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city){

        try {
            WeatherResponse response = weatherService.getWeatherDetails(city);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Place Not Found.", HttpStatus.NOT_FOUND);
        }



    }
}
