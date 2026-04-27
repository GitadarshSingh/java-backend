package org.cfs.weatherapp.controller;

import org.cfs.weatherapp.dto.WeatherForecast;
import org.cfs.weatherapp.dto.WeatherResponse;
import org.cfs.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class WeatherController {

    @Autowired
    public WeatherService weatherService;

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city)
    {
        return weatherService.test();
    }

    @GetMapping("/my/{city}")
    public WeatherResponse weatherResponse(@PathVariable String city)
    {
        return weatherService.getData(city);
    }

    @GetMapping("/forecast")
    public WeatherForecast getForecast(@RequestParam  String city, @RequestParam int days)
    {
        return weatherService.getForeCast(city,days);
    }
}
