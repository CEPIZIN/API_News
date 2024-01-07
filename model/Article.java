package model;


public record Article(

         String title,
         String description,
         String url,
         String urlToImage,
         String publishedAt,
         String content
) {
}
