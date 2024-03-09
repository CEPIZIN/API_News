## News API  📰

This application utilizes the News API to retrieve top headlines based on the user's specified country and the user category. The News API is a convenient HTTP REST API for accessing real-time articles from various sources on the web.

### Obtaining an API Key🔑

To use this application, you need to obtain an API key from News API. Follow these steps:

1. Sign up for a free account on the [News API website](https://newsapi.org/).
2. Once logged in, navigate to your dashboard to find your API key.
3. Copy your API key and replace the placeholder in the `URL` variable within the `mainSearch` class.

### Example URL 🌍

``
https://newsapi.org/v2/everything?q=technology&apiKey=your-api-key
``


### Usage

1. **Compile:** Compile the project using your Java IDE or command line.
2. **Run Application:** Execute the `mainSearch` class.
3. **Input Country:** Enter the desired country when prompted.
4. **Select Topic:** Choose a topic from the provided categories.
5. **View Results:** The application will display the top headlines based on your selections.

### Code Structure

| Class            | Description                                                                                   |
|------------------|-----------------------------------------------------------------------------------------------|
| `mainSearch.java`   | Contains the main class responsible for user interaction and API call initiation.            |
| `NewsApiClient.java` | Implements API client functionality for making requests to the News API.                       |
| `Article.java`       | Defines the structure of an article retrieved from the API.                                    |
| `ApiResponseDto.java` | Represents the structure of the API response, including status, total results, and a list of articles. |

### DTOs (Data Transfer Objects)

#### ArticleDTO

The `ArticleDTO` class encapsulates information about a single news article.

| Field       | Description                                  |
|-------------|----------------------------------------------|
| `title`     | The title of the article.                    |
| `description` | A brief description or summary of the article. |
| `url`         | The URL link to access the full article.      |
| `urlToImage`  | The URL link to the image associated with the article. |
| `publishedAt` | The date and time when the article was published.    |
| `content`     | The main textual content of the article.             |

#### ApiResponseDTO

The `ApiResponseDTO` class represents the structure of the response obtained from the News API.

| Field           | Description                                                                 |
|-----------------|-----------------------------------------------------------------------------|
| `status`        | The status of the API request (e.g., "ok" for successful requests).         |
| `totalResults`  | The total number of articles matching the query parameters.                 |
| `articles`      | A list of `ArticleDTO` objects containing details of individual articles.   |

### Dependencies

- **Google Gson:** Used for JSON serialization and deserialization.
- **Java HttpClient:** Utilized for making HTTP requests to the News API.

### Conclusion

This application offers a convenient way to access real-time news articles based on user-defined parameters. By integrating the News API, it provides a seamless experience for retrieving relevant news content.

For further details on the News API, refer to the official documentation provided by News API.
