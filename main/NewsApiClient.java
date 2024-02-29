package main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.jfr.Category;
import model.ApiResponseDto;
import model.Article;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


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

    public void Response(String Country, String SelectTopic) throws  IOException,InterruptedException{
        try {
            String jsonResponse = NewsApiClient.getNews(Country, SelectTopic);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();

            ApiResponseDto search = gson.fromJson(jsonResponse, ApiResponseDto.class);
            List<Article> articles = search.getArticles();

            if (articles.isEmpty()) {
                throw new BadRequestException("o results found for "+SelectTopic+" in " + Country);
            }

            for (int i = 0; i < 5 && i < articles.size(); i++) {
                System.out.println(articles.get(i).toString());

                String toJson = gson.toJson(articles);
                FileWriter writer = new FileWriter("My_Articles.json");
                writer.write(toJson);
                writer.close();
            }

        } catch (BadRequestException | InterruptedException err) {
            System.out.println(err);
        }
    }
}
