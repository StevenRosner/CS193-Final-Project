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

            IO.println();
            IO.println("====== CURRENT WEATHER =======");
            IO.println("Location: " + weather.getCity());
            IO.println("Temperature: " + weather.getTemp() + "°F");
            IO.println("Feels Like: " + weather.getFeelsLike() + "°F");
            IO.println("Humidity: " + weather.getHumidity() + "%");
            IO.println("Conditions: " + weather.getDescription());
            IO.println("==============================");

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
