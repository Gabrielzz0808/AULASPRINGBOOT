package com.facinpro.aulaspringboot.modelo;
import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendedor")
public class Facinpro_VendedorModelo extends RepresentationModel<Facinpro_VendedorModelo> implements Serializable  {

    public static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private UUID idVendedor;
    private String nome;
    private String tel;
    private double comissao;
    
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UUID getIdVendedor() {
        return idVendedor;
    }
    public void setIdVendedor(UUID idVendedor) {
        this.idVendedor = idVendedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
