
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import CurrencyConveter.ApiClient; // This line is already correct, assuming ApiClient is in the CurrencyConveter package.
import java.text.DecimalFormat;

public class CurrencyService {
    
    private final ObjectMapper objectMapper;


    private ApiClient apiClient;
    
    public CurrencyService(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.objectMapper = new ObjectMapper();
    }

    public String convertCurrency(
            String baseCurrency,
            String targetCurrency,
            double amount
    ) throws Exception {

        String jsonResponse = apiClient.getExchangeRate(
                baseCurrency,
                targetCurrency
        );

        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        String result = rootNode.path("result").asText();
        if (!"success".equals(result)) {
            throw new RuntimeException("API did not return a success result.");
        }

        double exchangeRate = rootNode.path("rates").path(targetCurrency).asDouble();
        double convertedAmount = amount * exchangeRate;

        return String.format("Converted Amount: %.2f %s", convertedAmount, targetCurrency);
    }
}