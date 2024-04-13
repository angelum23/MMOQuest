package com.exer4.exer4.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class BaseController<T> {

    @Autowired
    private BaseService<T> service;

    @GetMapping
    public ResponseEntity<List<T>> recuperar() {
        try {
            return service.recuperar();
        }
        catch (Exception e) {
            return ResponseEntity.status(500);
        }
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody T entidade) {
        try {
            service.salvar(entidade);
            return ResponseEntity.status(200).body("Registro inserido com sucesso!");
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao inserir registro! " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> alterar(@RequestBody T entidade) {
        try {
            service.alterar(entidade);
            return ResponseEntity.status(200).body("Registro alterado com sucesso!");
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao alterar registro!" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        try {
            service.remover(id);
            return ResponseEntity.status(200).body("Registro removido com sucesso!");
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao remover registro!" + e.getMessage());
        }

    }
}