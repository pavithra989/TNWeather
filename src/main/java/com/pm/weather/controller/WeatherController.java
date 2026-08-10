package com.pm.weather.controller;

import com.pm.weather.entity.Weather;
import com.pm.weather.service.WeatherService;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {


    private  WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public Weather getWeather(@PathVariable String city){
        return weatherService.getWeatherByCity(city);
    }
    @PostMapping
    public Weather addWeather(@RequestBody Weather weather)
    {
        return weatherService.createWeather(weather);
    }
    @GetMapping("/all")
    public List<Weather> getAllWeather()
    {
        return weatherService.getAllWeather();
    }


}
