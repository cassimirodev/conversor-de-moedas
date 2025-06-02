package service;

import com.google.gson.Gson;
import model.CurrencyCodeResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import model.CurrencyResponse;
import utils.EnvUtils;


public class CurrencyCodeService {

    public CurrencyCodeResponse getSupportedCodes() {
        String API_KEY  = EnvUtils.getApiKey();
        String URL_Req_getCodes = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/codes";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_Req_getCodes))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), CurrencyCodeResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao chamar API" , e);
        }
    }
}
