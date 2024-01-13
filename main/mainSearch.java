package main;

import com.google.gson.Gson;
import model.ApiResponseDto;
import model.Article;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class mainSearch {
    public static void main(String[] args) {
        try {
            Scanner scr = new Scanner(System.in);
            System.out.println("Enter your country: ");
            var topic = scr.nextLine();

            String URL = "https://newsapi.org/v2/top-headlines?country=" + topic + "&apiKey=c196de70f8ca483ea848fdf786285e90";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                ApiResponseDto search = gson.fromJson(json, ApiResponseDto.class);
                List<Article> articles = search.getArticles();

                for (int i = 0; i < 5 && i < articles.size(); i++) {
                    System.out.println(articles.get(i).toString());
                }
            } else {
                System.out.println("Error: Unable to fetch data. HTTP status code: " + response.statusCode());
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("InterruptedException: " + e.getMessage());
        }
    }
}
