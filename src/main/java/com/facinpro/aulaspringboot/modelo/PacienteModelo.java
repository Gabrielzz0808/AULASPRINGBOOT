package com.facinpro.aulaspringboot.modelo;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.*;

@Entity
@Table(name = "Paciente")
public class PacienteModelo extends RepresentationModel<PacienteModelo> implements Serializable {
    public static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPaciente;
    private String Nome;
    private String tel;

    public UUID getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
