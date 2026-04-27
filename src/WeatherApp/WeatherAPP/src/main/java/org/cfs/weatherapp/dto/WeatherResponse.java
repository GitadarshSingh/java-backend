package org.cfs.weatherapp.dto;

public class WeatherResponse {

    private String city;
    private String region;
    private String country;
    private String condition;
    private String temperature;

    public WeatherResponse() {
    }

    public WeatherResponse(String city, String region, String country, String condition, String temp) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.condition = condition;
        this.temperature = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTemp() {
        return temperature;
    }

    public void setTemp(String temp) {
        this.temperature = temp;
    }
}
