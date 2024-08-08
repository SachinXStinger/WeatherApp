package com.example.WeatherApp.apiResponse;


import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class WeatherResponse {
    private List<Weather> weather;
    private Main main;
    private String name;


    @Getter
    @Setter
    public static   class Main{
        private double temp;
        private double feels_like;
        private int humidity;

    }



    @Getter
    @Setter
    public static class Weather{
        private String description;

    }



}
