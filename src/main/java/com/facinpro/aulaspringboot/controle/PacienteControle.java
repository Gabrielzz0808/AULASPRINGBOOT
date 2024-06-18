package com.facinpro.aulaspringboot.controle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facinpro.aulaspringboot.dtos.PacienteDto;
import com.facinpro.aulaspringboot.modelo.PacienteModelo;
import com.facinpro.aulaspringboot.repositorio.PacienteRepositorio;

import jakarta.validation.Valid;

@RestController
public class PacienteControle {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @PostMapping("/Paciente")
    public ResponseEntity<PacienteModelo> AdicionarPaciente(@RequestBody @Valid PacienteDto pacienteDto){
        var pacienteModelo = new PacienteModelo();
        BeanUtils.copyProperties(pacienteDto, pacienteModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepositorio.save(pacienteModelo));
    }

    @GetMapping("/Paciente")
    public ResponseEntity<List<PacienteModelo>> BuscarTdsPaciente(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepositorio.findAll());
    }

    @GetMapping("/Paciente/{id}")
    public ResponseEntity<Object> buscarPacienteId(@PathVariable(value = "id") UUID id){
        Optional<PacienteModelo> paciente = pacienteRepositorio.findById(id);
        if(paciente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(paciente.get());
    }

    @PutMapping("/Paciente/{id}")
    public ResponseEntity<Object> EditarPaciente(@PathVariable (value = "id") UUID id, @RequestBody @Valid PacienteDto pacienteDto){
        Optional<PacienteModelo> paciente = pacienteRepositorio.findById(id);
        if (paciente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não Encontrado");
        }
        PacienteModelo pacienteModelo = paciente.get();
        BeanUtils.copyProperties(pacienteDto, pacienteModelo);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepositorio.save(pacienteModelo));
    }

    @DeleteMapping("/Paciente/{id}")
    public ResponseEntity<Object> deletarPaciente(@PathVariable(value = "id") UUID id){
        Optional<PacienteModelo> paciente = pacienteRepositorio.findById(id);
        if(paciente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não Encontrado");
        }
        pacienteRepositorio.delete(paciente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente excluido com sucesso");
    }


}
