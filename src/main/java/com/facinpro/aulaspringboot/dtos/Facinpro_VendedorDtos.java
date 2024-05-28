package com.facinpro.aulaspringboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Facinpro_VendedorDtos(@NotBlank String nome, @NotNull String tel, @NotNull double comissao) {
    
}
