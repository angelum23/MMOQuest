package com.exer4.exer4.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class BaseController<T extends IEntidadeBase> {

    @Autowired
    private BaseService<T> service;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody T entidade) {
        try {
            service.salvar(entidade);
            return ResponseEntity.status(200).body("Registro salvo com sucesso!");
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar registro! " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Integer id) {
        try {
            service.remover(id);
            return ResponseEntity.status(200).body("Registro removido com sucesso!");
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao remover registro!" + e.getMessage());
        }

    }
}