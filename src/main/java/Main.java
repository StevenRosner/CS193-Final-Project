package main.java;

import java.io.IOException;

public class Main {
    void main() {
        IO.println("==============================");
        IO.println("    WEATHER OUTFIT ADVISOR");
        IO.println("==============================");

        String location = IO.readln("Enter your city and state (City, ST):\n");
        location += ",US";
        IO.println();
        IO.println("Fetching weather data...");

        try {
            WeatherData weather = WeatherAPI.getCurrentWeather(location);

            System.out.println();
            System.out.println("====== CURRENT WEATHER =======");
            System.out.println("Location: " + weather.getCity());
            System.out.println("Temperature: " + weather.getTemp() + "°F");
            System.out.println("Humidity: " + weather.getHumidity() + "%");
            System.out.println("Conditions: " + weather.getDescription());
            System.out.println("==============================");

        } catch (IOException e) {
            IO.println("Error retrieving weather: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            IO.println("Weather request was interrupted.");
        } catch (IllegalStateException e) {
            IO.println(e.getMessage());
        }
    }
}
