package com.facinpro.aulaspringboot.modelo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "TB_PRODUTOS")
public class Facinpro_ProdutoModelo extends RepresentationModel<Facinpro_ProdutoModelo> implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id_produto;

    private String nome;
	private BigDecimal valor;

    public UUID getIdProduto() {
        return id_produto;
    }

    public void setIdProduto(UUID id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
}
