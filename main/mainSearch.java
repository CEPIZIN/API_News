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

import static java.lang.StringTemplate.STR;

public class mainSearch {
    public static void main(String[] args) {
        try {
            Scanner scr = new Scanner(System.in);
            System.out.println("Enter your country: ");
            var topic = scr.nextLine();

            String URL =STR."https://newsapi.org/v2/top-headlines?country=\{topic}&apiKey=c196de70f8ca483ea848fdf786285e90" ;

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

                if (articles.isEmpty())badRequestException();

                for (int i = 0; i < 5 && i < articles.size(); i++) {
                    System.out.println(articles.get(i).toString());
                }

            } else if (response.statusCode() ==404) {
                badRequestException();
            } else {
                System.out.println("Error: Unable to fetch data. HTTP status code: " + response.statusCode());
            }

        } catch (Exception  er) {
            System.out.println("Excepetion" + er.getMessage());
        }
    }
    private static void  badRequestException(){
        throw new BadRequestException("Bad request");
    }
}

