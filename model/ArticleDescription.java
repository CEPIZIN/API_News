package model;

public record ArticleDescription
        (String title,
         String description,
         String url,
         String imageUrl,
         String publishedAt,
         String source,
         String author,
         String content) {
}
