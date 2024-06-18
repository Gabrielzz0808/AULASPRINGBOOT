package com.facinpro.aulaspringboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record PacienteDto(@NotBlank String nome, @NotBlank String tel) {
    
}
