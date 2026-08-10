package com.pm.weather.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="weather")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String city;

    @NonNull
    private String forecast;

    public Weather(String city,String forecast)
    {
        this.city=city;
        this.forecast=forecast;
    }

}
