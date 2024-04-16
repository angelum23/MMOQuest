package com.exer4.exer4.infra;

import com.exer4.exer4.domain.Enums.Chuva;
import com.exer4.exer4.domain.WeatherDto;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WeatherHelper {
    @Autowired
    private HttpHelper httpHelper;

    @Autowired
    private ObjectMapper objectMapper;

    private final String urlBase = "http://my.meteoblue.com/packages/";

    public WeatherDto recuperarClima() throws Exception {
        final String key = "oYrVI8jmzTdJyCOR";
        final String latideLongitude = "lat=40.65&lon=22.1832";
        final String tipoExibicao = "basic-day";

        try {
            String url = urlBase + tipoExibicao + "?" + latideLongitude + "&apikey=" + key;
            var response = (String) httpHelper.get(url);

            return objectMapper.readValue(response, WeatherDto.class);
        } catch (Exception e) {
            throw new Exception("Erro ao recuperar clima: " + e.getMessage());
        }
    }
}