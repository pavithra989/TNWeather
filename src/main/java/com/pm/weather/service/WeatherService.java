package com.pm.weather.service;

import com.pm.weather.entity.Weather;
import com.pm.weather.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class WeatherService {

    private WeatherRepo weatherRepo;

    public WeatherService(WeatherRepo weatherrepo) {
        this.weatherRepo = weatherrepo;
    }

    public Weather getWeatherByCity(String city){
        return weatherRepo.findByCity(city);
    }


    public Weather createWeather(Weather weather)
    {
       return weatherRepo.save(weather);
    }

    public List<Weather> getAllWeather()
    {
        return weatherRepo.findAll();
    }

}
