package com.facinpro.aulaspringboot.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facinpro.aulaspringboot.modelo.PacienteModelo;

public interface PacienteRepositorio extends JpaRepository<PacienteModelo, UUID> {
    
}
