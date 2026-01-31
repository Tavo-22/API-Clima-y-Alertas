package com.gustavo.api_clima.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ClimaApiClient {

    private final RestTemplate restTemplate;
    private final String urlBase;
    private final String apiKey;

    public ClimaApiClient(
            RestTemplate restTemplate,
            @Value("${openweather.api.url}") String urlBase,
            @Value("${openweather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.urlBase = urlBase;
        this.apiKey = apiKey;
    }

    public Map<String, Object> obtenerClimaActual(String ciudad) {
        String url = String.format(
                "%s?q=%s&units=metric&lang=es&appid=%s",
                urlBase,
                ciudad,
                apiKey
        );

        return restTemplate.getForObject(url, Map.class);
    }

}
