package com.example.atv7.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {
    @NotBlank(message = "nome nao pode estar em branco")
    private String nome;

    @NotNull(message = "saldo nao pode ser nulo")
    private Double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
