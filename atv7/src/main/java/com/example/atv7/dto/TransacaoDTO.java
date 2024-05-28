package com.example.atv7.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransacaoDTO {
    @NotBlank
    private String recebedor;
    @NotBlank
    private String pagador;
    @NotNull
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
