package com.example.atv7.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransacaoDTO {
    @NotBlank(message = "recebedor nao pode estar em branco")
    private String recebedor;

    @NotBlank(message = "pagador n pode estar em branco")
    private String pagador;

    @NotNull(message = "quantidade n pode ser nula")
    @Min(value = 0, message = "A quantidade deve ser maior que zero")
    private Double quantidade;

    public String getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(String recebedor) {
        this.recebedor = recebedor;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
