package main;

import jdk.jfr.Category;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class NewsApiClient {

    private static final String API_KEY = "c196de70f8ca483ea848fdf786285e90";

    public static String getNews(String country, String category) throws IOException, InterruptedException {
        String URL =STR."https://newsapi.org/v2/top-headlines?country=\{country}&category=\{category}&apiKey=\{API_KEY}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
