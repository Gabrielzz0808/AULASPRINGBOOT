package com.facinpro.aulaspringboot.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facinpro.aulaspringboot.modelo.Facinpro_VendedorModelo;

public interface Facinpro_VendedorRepositorio extends JpaRepository<Facinpro_VendedorModelo, UUID> {
    
}
