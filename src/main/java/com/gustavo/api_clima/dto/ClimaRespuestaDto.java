package com.gustavo.api_clima.dto;

public record ClimaRespuestaDto(
        String ciudad,
        String pais,
        double temperatura,
        double sensacionTermica,
        int humedad,
        String descripcionClima,
        double velocidadViento
) {
}
