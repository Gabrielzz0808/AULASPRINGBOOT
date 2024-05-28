package com.facinpro.aulaspringboot.controle;

import java.util.Optional;
import java.util.UUID;

import java.util.List;
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
import com.facinpro.aulaspringboot.dtos.FacinPro_ProdutoRecordDto;
import com.facinpro.aulaspringboot.modelo.Facinpro_ProdutoModelo;
import com.facinpro.aulaspringboot.repositorio.FacinPro_ProdutoRepositorio;


import jakarta.validation.Valid;

@RestController
public class FacinPro_ProdutoControle {
    

    @Autowired
    FacinPro_ProdutoRepositorio facinPro_ProdutoRepositorio;

    @PostMapping("/produtos")
	public ResponseEntity<Facinpro_ProdutoModelo> saveProduct(@RequestBody @Valid FacinPro_ProdutoRecordDto facinpro_ProdutoRecordDto) {
	    var facinpro_ProdutoModelo = new Facinpro_ProdutoModelo();
		BeanUtils.copyProperties(facinpro_ProdutoRecordDto, facinpro_ProdutoModelo);
		return ResponseEntity.status(HttpStatus.CREATED).body(facinPro_ProdutoRepositorio.save(facinpro_ProdutoModelo));
	}

    @GetMapping("/produtos")
    public ResponseEntity<List<Facinpro_ProdutoModelo>> getAllProducts(){
    return ResponseEntity.status(HttpStatus.OK).body(facinPro_ProdutoRepositorio.findAll());
    }
    

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){
        Optional<Facinpro_ProdutoModelo> productO = facinPro_ProdutoRepositorio.findById(id);
        if(productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return null;
    }

    @PutMapping("/produto{id}")
    public ResponseEntity<Object> EditarProduto(@PathVariable (value = "id") UUID id, @RequestBody @Valid FacinPro_ProdutoRecordDto facinPro_ProdutoRecordDto){
        Optional<Facinpro_ProdutoModelo> Produto = facinPro_ProdutoRepositorio.findById(id);
        if(Produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        var facinpro_ProdutoModelo = new Facinpro_ProdutoModelo();
        BeanUtils.copyProperties(facinPro_ProdutoRecordDto, facinpro_ProdutoModelo);
        return ResponseEntity.status(HttpStatus.OK).body(facinPro_ProdutoRepositorio.save(facinpro_ProdutoModelo));
    }

    @DeleteMapping("/produto{id}")
    public ResponseEntity <Object> DeletarProduto(@PathVariable (value = "id")UUID id){
        Optional<Facinpro_ProdutoModelo> Produto = facinPro_ProdutoRepositorio.findById(id);
        if(Produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        facinPro_ProdutoRepositorio.delete(Produto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto Excluido com sucesso.");
    }
    
} 
