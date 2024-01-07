package main;
import model.Article;
import model.ArticleDescription;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class mainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter your search: ");
        var topic = scr.nextLine();

        String URL = "https://newsapi.org/v2/everything?q=" + topic + "&apiKey=c196de70f8ca483ea848fdf786285e90";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println("json puro da api ");
        System.out.println(json);

        Gson gson = new Gson();
        System.out.println("como ta vindo");
        ArticleDescription search = gson.fromJson(json, ArticleDescription.class);
        System.out.println(search);

    }
}
