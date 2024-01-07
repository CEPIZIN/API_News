package model;

import java.util.List;

public class ApiResponseDto {

    private String status;
    private int totalResults;
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }
}
