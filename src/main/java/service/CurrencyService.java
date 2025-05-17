package service;

import com.google.gson.Gson;
import model.CurrencyResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import utils.EnvUtils;

public class CurrencyService {

    public CurrencyResponse converterMoeda(String from, String to, double amount) {


        String API_KEY  = EnvUtils.getApiKey();
        String URL_Req = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to + "/" + amount;

        System.out.println("Executando sua requisição");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_Req))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), CurrencyResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao chamar API" , e);
        }
    }
}
