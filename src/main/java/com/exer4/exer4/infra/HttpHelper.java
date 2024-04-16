package com.exer4.exer4.infra;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpHelper {
    HttpClient httpClient = HttpClient.newHttpClient();

    public Object get(String url) throws Exception {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
        var response = this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Object post(String url, Object body) throws Exception {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
        var response = this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
