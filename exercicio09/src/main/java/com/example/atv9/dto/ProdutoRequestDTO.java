package com.example.atv9.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProdutoRequestDTO {
    @NotBlank(message = " nome obrigatorio")
    private String nome;

    @Min(value = 0, message = "preço deve ser maior ou igual a 0")
    private Double preco;
}
