package com.gustavo.api_clima.service;

import com.gustavo.api_clima.client.ClimaApiClient;
import com.gustavo.api_clima.dto.ClimaRespuestaDto;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClimaService {

    @Autowired
    private ClimaApiClient climaApiClient;

//    public String obtenerClimaActual(String ciduad){
//        return climaApiClient.obtenerClimaActual(ciduad);
//    }

    @SuppressWarnings("unchecked")
    public ClimaRespuestaDto obtenerClimaActual(String ciudad){

        Map<String, Object> respuesta =
                climaApiClient.obtenerClimaActual(ciudad);

        Map<String, Object> main = (Map<String, Object>) respuesta.get("main");
        Map<String, Object> wind = (Map<String, Object>) respuesta.get("wind");
        Map<String, Object> sys = (Map<String, Object>) respuesta.get("sys");

        List<Map<String, Object>> weather =
                (List<Map<String, Object>>) respuesta.get("weather");

        return new ClimaRespuestaDto(
                (String) respuesta.get("name"),
                (String) sys.get("country"),
                ((Number) main.get("temp")).doubleValue(),
                ((Number) main.get("feels_like")).doubleValue(),
                ((Number) main.get("humidity")).intValue(),
                (String) weather.get(0).get("description"),
                ((Number) wind.get("speed")).doubleValue()
        );
    }
}
