package com.example.atv7.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
    @NotBlank
    private String nome;
    private Double saldo;
    //n inclui senha
}
