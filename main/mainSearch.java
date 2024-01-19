package main;

import com.google.gson.Gson;
import model.ApiResponseDto;
import model.Article;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class mainSearch {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> category = new HashMap<>();
        category.put(1, "business");
        category.put(2, "entertainment");
        category.put(3, "health");
        category.put(4, "sports");

        Scanner scr = new Scanner(System.in);

        System.out.println("Enter your country: ");
        String country = scr.nextLine();

        System.out.println("Enter your Topic");
        for (Integer i : category.keySet()) {
            System.out.println(i + ". " + category.get(i));
        }
        int TopicChoice = scr.nextInt();
        String selectedCategory = category.get(TopicChoice);

        System.out.println("Selected Topic: " + selectedCategory);

        String URL =STR."https://newsapi.org/v2/top-headlines?country=\{country}&category=\{selectedCategory}&apiKey=c196de70f8ca483ea848fdf786285e90";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                ApiResponseDto search = gson.fromJson(json, ApiResponseDto.class);

                List<Article> articles = search.getArticles();

                if (articles.isEmpty()) {
                   throw new BadRequestException("nothing");
                }
                    for (int i = 0; i < 5 && i < articles.size(); i++) {
                        System.out.println(articles.get(i).toString());
                    }

            } else {
                System.out.println("Error: Unable to fetch data. HTTP status code: " + response.statusCode());
            }
        } catch (BadRequestException |InterruptedException err) {
            System.out.println(err);
        }
    }
}
