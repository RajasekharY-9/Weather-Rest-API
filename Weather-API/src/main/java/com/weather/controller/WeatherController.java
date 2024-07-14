package com.weather.controller;

import com.weather.entity.Weather;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/{city}")
    //http://localhost:8089/api/v2/weather/Bangalore
    public Weather getWeatherDetails(@PathVariable String city){
      return   weatherService.getWeatherResponsebyCity(city);
    }
}
