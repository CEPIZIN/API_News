package model;

public record Article(

         String title,
         String description,
         String url,
         String urlToImage,
         String publishedAt,
         String content
) {

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                //", description='" + description + '\'' +
               // ", url='" + url + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
