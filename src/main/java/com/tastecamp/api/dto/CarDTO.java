package com.tastecamp.api.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO (
    @NotBlank
    String modelo, 

    @NotBlank
    String fabricante, 

    @Past
    Date dataFabricacao, 

    @NotNull
    int valor,

    @NotNull
    int anoModelo
){
    
}
