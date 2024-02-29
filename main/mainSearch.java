package main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.ApiResponseDto;
import model.Article;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class mainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

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

        NewsApiClient CallSearch = new NewsApiClient();
        CallSearch.Response(country,selectedCategory );



    }
}
