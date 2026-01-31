package com.gustavo.api_clima.controller;

import com.gustavo.api_clima.dto.ClimaRespuestaDto;
import com.gustavo.api_clima.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/saludo")
    public String saludo(){
        return "API de Clima y Alertas funcionando correctamente";
    }

    @GetMapping("/actual")
    public ClimaRespuestaDto obtenerClimaActual(@RequestParam String ciudad){
        return climaService.obtenerClimaActual(ciudad);
    }
}
