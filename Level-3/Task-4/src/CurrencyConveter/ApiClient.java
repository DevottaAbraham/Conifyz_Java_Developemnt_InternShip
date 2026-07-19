import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private final HttpClient client;

    public ApiClient() {
        client = HttpClient.newHttpClient();
    }

    public String getExchangeRate(
            String baseCurrency,
            String targetCurrency
    ) throws Exception {

        String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency; // We will add the real endpoint next

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "API request failed. Status code: "
                            + response.statusCode()
            );
        }

        return response.body();
    }
}