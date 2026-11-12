package main.java;

import java.io.IOException;

public class Main {
    void main() {
        IO.println("==============================");
        IO.println("     WEATHER OUTFIT ADVISOR");
        IO.println("==============================");

        String location = IO.readln("Enter your city and state:\n");
        location += ",US";
        IO.println();
        IO.println("Fetching weather data...");

        try {
            String weatherData = WeatherAPI.getCurrentWeather(location);

            IO.println("\nWeather API Response:");
            IO.println(weatherData);
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
