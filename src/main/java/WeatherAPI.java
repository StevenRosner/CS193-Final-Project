package main.java;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPI {

    public static WeatherData getCurrentWeather(String location) throws IOException, InterruptedException {
        String key = System.getenv("OPENWEATHER_API_KEY");

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("API key not found");
        }

        // URL Encoding the user location
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
        // Structuring url request type and variables
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + encodedLocation
                + "&appid=" + key
                + "&units=imperial";
        // client and request set up
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        // get response from request
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Weather API Request failed. Status code: " + response.statusCode());
        }
        // start parsing json response into variables
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

        String city = json.get("name").getAsString();

        JsonObject main = json.getAsJsonObject("main");

        double temp = main.get("temp").getAsDouble();
        int humidity = main.get("humidity").getAsInt();
        // weather is an array inside the json response
        JsonArray weatherArray = json.getAsJsonArray("weather");

        String description = weatherArray.get(0).getAsJsonObject().get("description").getAsString();

        return new WeatherData(city, temp, humidity, description);
    }
}
