package com.pm.weather.controller;

import com.pm.weather.entity.Weather;
import com.pm.weather.service.CacheInspectionServ;
import com.pm.weather.service.WeatherService;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {


    private  WeatherService weatherService;
    private CacheInspectionServ cacheInspectionServ;

    public WeatherController(WeatherService weatherService, CacheInspectionServ cacheInspectionServ) {
        this.weatherService = weatherService;
        this.cacheInspectionServ = cacheInspectionServ;
    }

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city){
        String weatherbyCity = weatherService.getWeatherByCity(city);
        return weatherbyCity;
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
    @GetMapping("/cachedata")
    public void getCachedate()
    {
        cacheInspectionServ.printCacheContents("weather");
    }
    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city,@RequestParam String weatherUpdate)
    {
        return weatherService.updateWeather(city,weatherUpdate);
    }

}
