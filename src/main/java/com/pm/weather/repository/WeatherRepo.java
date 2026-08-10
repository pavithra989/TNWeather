package com.pm.weather.repository;

import com.pm.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepo extends JpaRepository<Weather,Long> {

    Optional<Weather> findByCity(String city);
}
