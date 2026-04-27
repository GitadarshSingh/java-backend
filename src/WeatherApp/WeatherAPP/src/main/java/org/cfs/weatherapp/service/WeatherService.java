package org.cfs.weatherapp.service;


import org.cfs.weatherapp.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {


    @Value("${weather.api.key}")
    private String apikey; // application.properties se value read kkarte @Value se

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.forecast.url}")
    private String apiForecastUrl;

    //RestTemplate dushri api ko consume karti hai
    private RestTemplate template = new RestTemplate();

    public String test(){
        return "good";
    }

    public WeatherResponse getData(String city)
    {
        String url= apiUrl+"?key="+apikey+"&q="+city;

        //agar aap apni api se dushri application ka data consume karna chayte ho, uske liye use hota hai : Resttemplate
        Root response = template.getForObject(url,Root.class);
        WeatherResponse WeatherResponse = new WeatherResponse();
//        String cities=response.getLocation().name;
//        String regions=response.getLocation().region;
//        String countries=response.getLocation().country;   oR

        WeatherResponse.setCity(response.getLocation().name);
        WeatherResponse.setCountry(response.getLocation().country);
        WeatherResponse.setRegion(response.getLocation().region);

        String condition = response.getCurrent().getCondition().getText();

        WeatherResponse.setCondition(condition);
        WeatherResponse.setTemp(response.getCurrent().getTemp_c());



        return WeatherResponse;
    }

    public WeatherForecast getForeCast(String city, int days)
    {
        WeatherForecast weatherForecast = new WeatherForecast();
        WeatherResponse weatherResponse = getData(city);
        WeatherForecast response =new WeatherForecast();
        response.setWeatherResponse(weatherResponse);


        List<DayTemp> dayList=new ArrayList<>();
        String url= apiForecastUrl+"?key="+apikey+"&q="+city+"&days="+days;
        Root apiResponse = template.getForObject(url,Root.class);
        Forecast forecast=apiResponse.getForecast();
        ArrayList<Forecastday> forecastday = forecast.getForecastday();

        for(Forecastday rs: forecastday)
        {
            DayTemp d =new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().mintemp_c);
            d.setAvgTemp(rs.getDay().avgtemp_c);
            d.setMaxTemp(rs.getDay().maxtemp_c);

            dayList.add(d);

        }
        response.setDayTemp(dayList);
        return response;



    }

}
