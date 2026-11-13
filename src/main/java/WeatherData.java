package main.java;

//creates weather data object
public class WeatherData {
    private String city;
    private double temp;
    private int humidity;
    private String description;

    public WeatherData(String city, double temp, int humidity, String description) {
        this.city = city;
        this.temp = temp;
        this.humidity = humidity;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }

}
