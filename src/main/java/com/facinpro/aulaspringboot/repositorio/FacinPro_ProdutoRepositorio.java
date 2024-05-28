package com.facinpro.aulaspringboot.repositorio;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facinpro.aulaspringboot.modelo.Facinpro_ProdutoModelo;


@Repository
public interface FacinPro_ProdutoRepositorio extends JpaRepository<Facinpro_ProdutoModelo, UUID>{
    
}
