package com.alura_challenge_2.modulo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private String json;
    private String urlBase = "https://v6.exchangerate-api.com/v6/0a7730bf1759c3dd1955a1c4/pair/";
    public String url;

    public API(String baseCode, String secondBase) throws IOException, InterruptedException {
        this.url = urlBase + baseCode + "/" + secondBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        this.json = response.body();
    }

    public String getJson() {
        return json;
    }

    public String getUrlBase () {
        return urlBase;
    }

    }