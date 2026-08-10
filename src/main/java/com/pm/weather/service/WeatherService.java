package com.pm.weather.service;

import com.pm.weather.entity.Weather;
import com.pm.weather.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    private WeatherRepo weatherRepo;

    public WeatherService(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @Cacheable(value = "weather", key = "#city")
    public String getWeatherByCity(String city){
        System.out.println("fetching data from db");
        Optional<Weather> weather = weatherRepo.findByCity(city);
        return weather.map(Weather::getForecast).orElse("data not avail");
    }


    public Weather createWeather(Weather weather)
    {
       return weatherRepo.save(weather);
    }

    public List<Weather> getAllWeather()
    {
        return weatherRepo.findAll();
    }
    @CachePut(value = "weather", key = "#city")
    public String updateWeather(String city, String weatherUpdate) {
      weatherRepo.findByCity(city).ifPresent(weather->{weather.setForecast(weatherUpdate);weatherRepo.save(weather);});
        return weatherUpdate;

    }
}
