package com.exer4.exer4.infra.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Base")
public abstract class BaseController<T extends IEntidadeBase> {

    @Autowired
    private BaseService<T> service;

    @GetMapping("/Recuperar")
    public ResponseEntity<Object> recuperar(@RequestParam("id") Integer id) {
        try {
            var registro = service.recuperar(id);
            return ResponseEntity.status(200).body(registro);
        } catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao recuperar registro! " + e.getMessage());
        }
    }

    @GetMapping("/RecuperarTodos")
    public ResponseEntity<Object> recuperar() {
        try {
            var registro = service.recuperar();
            return ResponseEntity.status(200).body(registro);
        } catch (Exception e){
            return ResponseEntity.status(500).body("Erro ao recuperar registros! " + e.getMessage());
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> salvar(@RequestBody T entidade) {
        try {
            Integer id = service.salvar(entidade);
            return ResponseEntity.status(200).body("Registro salvo com sucesso: " + id);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar registro! " + e.getMessage());
        }
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Object> remover(@RequestParam("id") Integer id) {
        try {
            service.remover(id);
            return ResponseEntity.status(200).body("Registro removido com sucesso!");
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao remover registro!" + e.getMessage());
        }

    }
}