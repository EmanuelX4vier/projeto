package com.seuprojeto.produtos.dto;

import jakarta.validation.constraints.*;

public record ProdutoDTO(
        @NotBlank String nome,
        @NotNull @Positive Double preco,
        @NotNull @Min(0) Integer quantidade
) {}
