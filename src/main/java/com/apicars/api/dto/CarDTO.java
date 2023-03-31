package com.apicars.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO(
    
    @NotNull
    String modelo, 
    
    @NotNull
    String fabricante, 
    
    @Past 
    Date dataFabricacao, 
    
    @NotNull
    Double valor, 
    
    @NotNull
    int anoModelo) 
    {
    
}
