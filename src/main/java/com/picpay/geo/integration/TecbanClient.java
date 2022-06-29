package com.picpay.geo.integration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TecbanClient {

    private final String uri = "https://api.homol.buscaatm.24horasdigital.com.br/v3/localizacao";
    private final String x_api_key = "XaVmpwFgQU7sG9KZFbm50agQzgI5zw4satFE1FVJ";

    public String getAll(String lat, String lon) {
        String params = "?acessivel=0&lista=1&limite=10";
        params += "&latitude=" + lat;
        params += "&longitude=" + lon;
        return this.httpRequest(uri + params);
    }

    public String find(int id) {
        String params = "pc?pc=" + id;
        return this.httpRequest(uri + params);
    }

    private String httpRequest(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-api-key", x_api_key)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
}
