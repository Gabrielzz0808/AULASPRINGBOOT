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

import com.facinpro.aulaspringboot.dtos.Facinpro_VendedorDtos;
import com.facinpro.aulaspringboot.modelo.Facinpro_VendedorModelo;
import com.facinpro.aulaspringboot.repositorio.Facinpro_VendedorRepositorio;

import jakarta.validation.Valid;

@RestController
public class Facinpro_VendedorControle {

    @Autowired
    private Facinpro_VendedorRepositorio facinpro_VendedorRepositorio;

    @PostMapping("/Vendedor")
    public ResponseEntity<Facinpro_VendedorModelo> AdicionarVendedor(@RequestBody @Valid Facinpro_VendedorDtos facinpro_VendedorDtos){
        var facinpro_VendedorModelo = new Facinpro_VendedorModelo();
        BeanUtils.copyProperties(facinpro_VendedorDtos, facinpro_VendedorModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(facinpro_VendedorRepositorio.save(facinpro_VendedorModelo));
    }

    @GetMapping("/Vendedor")
    public ResponseEntity<List<Facinpro_VendedorModelo>> BuscarTdsVendedor(){
        return ResponseEntity.status(HttpStatus.OK).body(facinpro_VendedorRepositorio.findAll());
    }

    @GetMapping("/Vendedor/{id}")
    public ResponseEntity<Object> buscarVendedorId(@PathVariable(value = "id") UUID id){
        Optional<Facinpro_VendedorModelo> vended = facinpro_VendedorRepositorio.findById(id);
        if(vended.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vended.get());
    }

    @PutMapping("/Vendedor/{id}")
    public ResponseEntity<Object> EditarVendedor(@PathVariable (value = "id") UUID id, @RequestBody @Valid Facinpro_VendedorDtos facinpro_VendedorDtos){
        Optional<Facinpro_VendedorModelo> vended = facinpro_VendedorRepositorio.findById(id);
        if (vended.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor não Encontrado");
        }
        Facinpro_VendedorModelo facinpro_VendedorModelo = vended.get();
        BeanUtils.copyProperties(facinpro_VendedorDtos, facinpro_VendedorModelo);
        return ResponseEntity.status(HttpStatus.OK).body(facinpro_VendedorRepositorio.save(facinpro_VendedorModelo));
    }

    @DeleteMapping("/Vendedor/{id}")
    public ResponseEntity<Object> deletarVendedor(@PathVariable(value = "id") UUID id){
        Optional<Facinpro_VendedorModelo> vended = facinpro_VendedorRepositorio.findById(id);
        if(vended.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor não Encontrado");
        }
        facinpro_VendedorRepositorio.delete(vended.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vendedor excluido com sucesso");
    }


}
