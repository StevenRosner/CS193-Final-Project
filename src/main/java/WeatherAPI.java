package main.java;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherAPI {
    
    public static String getCurrentWeather(String location) throws IOException, InterruptedException {
        String key = System.getenv("OPENWEATHER_API_KEY");

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("API key not found");
        }
        
        //URL Encoding the user location
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
        //Structuring url request type and variables
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
            + encodedLocation
            + "&appid=" + key
            + "&units=imperial";
        //client and request set up
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        //get response from request
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new IOException("Weather API Request failed. Status code: " + response.statusCode());
        }
        
        return response.body();
    }
}
